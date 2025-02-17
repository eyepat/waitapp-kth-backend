package se.kth.ki.waitapp.core.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import io.quarkus.security.identity.SecurityIdentity;
import io.smallrye.mutiny.Uni;
import se.kth.ki.waitapp.core.interfaces.repository.IGenericRepository;
import se.kth.ki.waitapp.core.interfaces.service.IGenericOwnableService;
import se.kth.ki.waitapp.core.model.IOwnableModel;
import se.kth.ki.waitapp.dto.IOwnableDTO;
import se.kth.ki.waitapp.mappers.IGenericMapper;
import se.kth.ki.waitapp.util.models.Page;

public class GenericOwnableService<T extends IOwnableModel, TDTO extends IOwnableDTO>
        extends GenericService<T, TDTO>
        implements IGenericOwnableService<T, TDTO> {

    public GenericOwnableService(IGenericMapper<T, TDTO> mapper, IGenericRepository<T> repository,
            SecurityIdentity identity) {
        super(mapper, repository, identity);
    }

    @Override
    public Uni<List<TDTO>> findAll() {
        if (identity == null || identity.isAnonymous()) {
            return Uni.createFrom().failure(new SecurityException("No identity provided"));
        }

        String sub = jwt.getSubject();
        if (sub == null || sub.isEmpty()) {
            return Uni.createFrom().failure(new SecurityException("not able to get sub from jwt"));
        }
        var owner = UUID.fromString(sub);
        return sf.withSession((s) -> {
            return repository.find("WHERE owner = ?1", owner).list()
                    .onItem().transform(entities -> entities.stream().map(e -> {
                        System.out
                                .println("Processing entity of type: " + e.getClass().getSimpleName());
                        return e;
                    })
                            .map(entity -> mapper.toDTO(entity))
                            .toList());
        });
    }

    @Override
    public Uni<Page<TDTO>> findPaginated(int page, int size, Optional<String> searchQuery) {
        if (identity == null || identity.isAnonymous()) {
            return Uni.createFrom().failure(new SecurityException("No identity provided"));
        }

        String sub = jwt.getSubject();
        if (sub == null || sub.isEmpty()) {
            return Uni.createFrom().failure(new SecurityException("Not able to get sub from JWT"));
        }

        boolean isAdmin = identity.hasRole("admin");
        String query = isAdmin ? "" : "WHERE owner = ?1";
        String countQuery = isAdmin ? "" : "WHERE owner = ?1";
        Object[] params = isAdmin ? new Object[] {} : new Object[] { UUID.fromString(sub) };

        System.out.println("ISADMIN: " + isAdmin + ", " + searchQuery.isPresent());
        int paramc = isAdmin ? 1 : 2;
        if (searchQuery.isPresent()) {
            String searchCondition = "(CAST(id AS string) LIKE ?" + paramc++ + " OR CAST(owner AS string) LIKE ?"
                    + paramc++ + ")";
            if (isAdmin) {
                query = "WHERE " + searchCondition;
                countQuery = "WHERE " + searchCondition;
                params = new Object[] { "%" + searchQuery.get() + "%", "%" + searchQuery.get() + "%" };
            } else {
                query += " AND " + searchCondition;
                countQuery += " AND " + searchCondition;
                params = new Object[] { UUID.fromString(sub), "%" + searchQuery.get() + "%",
                        "%" + searchQuery.get() + "%" };
            }
        }

        final String processedQuery = query;
        final String processedCountQuery = countQuery;
        final Object[] processedParams = params;
        final int offset = page * size;

        System.out.println(processedQuery);

        return sf.withSession(s -> repository.count(processedCountQuery, processedParams)
                .flatMap(totalElements -> repository.find(processedQuery, processedParams)
                        .range(offset, offset + size - 1)
                        .list()
                        .onItem().transform(entities -> Page.of(entities.stream()
                                .map(mapper::toDTO)
                                .toList(),
                                page,
                                size,
                                totalElements))));
    }

    @Override
    public Uni<Optional<TDTO>> findById(Long id) {
        if (identity == null || identity.isAnonymous()) {
            return Uni.createFrom().failure(new SecurityException("No identity provided"));
        }

        String sub = jwt.getSubject();
        if (sub == null || sub.isEmpty()) {
            return Uni.createFrom().failure(new SecurityException("not able to get sub from jwt"));
        }
        var owner = UUID.fromString(sub);
        return sf.withSession((s) -> {
            return repository.find("WHERE owner = ?1 AND id = ?2", owner, id).firstResult()
                    .onItem()
                    .transform(entity -> {
                        if (entity == null || !entity.isPersistent()) {
                            return Optional.empty();
                        }
                        return Optional.of(mapper.toDTO(entity));
                    });
        });
    }

    @Override
    public Uni<TDTO> create(TDTO dto) {
        if (identity == null || identity.isAnonymous()) {
            return Uni.createFrom().failure(new SecurityException("No identity provided"));
        }
        dto.setId(null);
        T entity = mapper.toEntity(dto);
        String sub = jwt.getClaim("sub");
        entity.setOwner(UUID.fromString(sub));

        return sf.withSession((s) -> {
            return repository.persistAndFlush(entity)
                    .onItem().transform(savedEntity -> {
                        System.out.println(entity);
                        var dto_ = mapper.toDTO(entity);
                        System.out.println(dto_);
                        return dto_;
                    });
        });
    }

    @Override
    public Uni<Optional<TDTO>> update(Long id, TDTO dto) {
        if (identity == null || identity.isAnonymous()) {
            return Uni.createFrom().failure(new SecurityException("No identity provided"));
        }

        String sub = jwt.getSubject();
        if (sub == null || sub.isEmpty()) {
            return Uni.createFrom().failure(new SecurityException("not able to get sub from jwt"));
        }
        var owner = UUID.fromString(sub);
        dto.setId(id);
        dto.setOwner(owner);
        return sf.withSession((s) -> {
            return repository.find("WHERE owner = ?1 AND id = ?2", owner, id).firstResult()
                    .onItem().transformToUni(existing -> {
                        if (existing == null) {
                            return Uni.createFrom().item(Optional.empty());
                        }
                        if (!owner.equals((existing).getOwner()) && !identity.hasRole("admin")) {
                            return Uni.createFrom()
                                    .failure(new SecurityException("Not authorized to update this resource"));
                        }
                        mapper.updateEntity(dto, existing);
                        return repository.persistAndFlush(existing)
                                .onItem().transform(updated -> Optional.of(mapper.toDTO((T) updated)));
                    });
        });
    }

    @Override
    public Uni<Boolean> delete(Long id) {
        if (identity == null || identity.isAnonymous()) {
            return Uni.createFrom().failure(new SecurityException("No identity provided"));
        }

        String sub = jwt.getSubject();
        if (sub == null || sub.isEmpty()) {
            return Uni.createFrom().failure(new SecurityException("not able to get sub from jwt"));
        }
        var owner = UUID.fromString(sub);
        return sf.withSession((s) -> {
            return repository.delete("WHERE owner = ?1 AND id = ?2", owner, id)
                    .onItem().transform(deletedCount -> deletedCount > 0);
        });
    }

    @Override
    public Uni<Boolean> existsById(Long id) {
        if (identity == null || identity.isAnonymous()) {
            return Uni.createFrom().failure(new SecurityException("No identity provided"));
        }

        String sub = jwt.getSubject();
        if (sub == null || sub.isEmpty()) {
            return Uni.createFrom().failure(new SecurityException("not able to get sub from jwt"));
        }
        var owner = UUID.fromString(sub);
        return sf.withSession((s) -> {
            return repository.count("WHERE owner = ?1 AND id = ?2", owner, id)
                    .map(count -> count > 0);
        });
    }

}
