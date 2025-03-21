package se.kth.ki.waitapp.core.service;

import java.util.List;
import java.util.Optional;

import org.eclipse.microprofile.jwt.JsonWebToken;
import org.hibernate.reactive.mutiny.Mutiny;

import io.quarkus.security.identity.SecurityIdentity;
import io.smallrye.mutiny.Uni;
import jakarta.inject.Inject;
import lombok.NoArgsConstructor;
import se.kth.ki.waitapp.core.interfaces.repository.IGenericRepository;
import se.kth.ki.waitapp.core.interfaces.service.IGenericService;
import se.kth.ki.waitapp.core.model.IBaseModel;
import se.kth.ki.waitapp.dto.IBaseDTO;
import se.kth.ki.waitapp.mappers.IGenericMapper;
import se.kth.ki.waitapp.util.models.Page;

@NoArgsConstructor
public abstract class GenericService<T extends IBaseModel, TDTO extends IBaseDTO> implements IGenericService<T, TDTO> {

    protected SecurityIdentity identity;
    protected IGenericMapper<T, TDTO> mapper;
    protected IGenericRepository<T> repository;

    @Inject
    JsonWebToken jwt;

    @Inject
    Mutiny.SessionFactory sf;

    public GenericService(IGenericMapper<T, TDTO> mapper, IGenericRepository<T> repository, SecurityIdentity identity) {
        this.mapper = mapper;
        this.repository = repository;
        this.identity = identity;
    }

    @Override
    public Uni<List<TDTO>> findAll() {
        if (identity == null || identity.isAnonymous()) {
            return Uni.createFrom().failure(new SecurityException("No identity provided"));
        }

        return sf.withSession((s) -> {
            return repository.findAll().list()
                    .onItem().transform(entities -> entities.stream().map(e -> {
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

        int paramc = 1;

        String searchCondition = "(CAST(id AS string) LIKE ?" + paramc++ + ")";

        final String processedQuery = searchQuery.isPresent() ? "WHERE " + searchCondition : "";
        final String processedCountQuery = searchQuery.isPresent() ? "WHERE " + searchCondition : "";
        final Object[] processedParams = searchQuery.isPresent()
                ? new Object[] { "%" + searchQuery.get() + "%" }
                : new Object[] {};
        final int offset = page * size;

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

        return sf.withSession((s) -> {
            return repository.find("WHERE id = ?1", id).firstResult()
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

        if (!identity.hasRole("admin")) {
            return Uni.createFrom()
                    .failure(new SecurityException("Not authorized to create this resource"));
        }

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
        dto.setId(id);

        return sf.withSession((s) -> {
            return repository.find("WHERE id = ?1", id).firstResult()
                    .onItem().transformToUni(existing -> {
                        if (existing == null) {
                            return Uni.createFrom().item(Optional.empty());
                        }
                        if (!identity.hasRole("admin")) {
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

        if (!identity.hasRole("admin")) {
            return Uni.createFrom()
                    .failure(new SecurityException("Not authorized to delete this resource"));
        }

        return sf.withSession((s) -> {
            return repository.delete("WHERE id = ?1", id)
                    .onItem().transform(deletedCount -> deletedCount > 0);
        });
    }

    @Override
    public Uni<Boolean> existsById(Long id) {
        if (identity == null || identity.isAnonymous()) {
            return Uni.createFrom().failure(new SecurityException("No identity provided"));
        }

        return sf.withSession((s) -> {
            return repository.count("WHERE id = ?1", id)
                    .map(count -> count > 0);
        });
    }

}
