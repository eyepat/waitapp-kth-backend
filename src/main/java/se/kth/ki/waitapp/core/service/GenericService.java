package se.kth.ki.waitapp.core.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.eclipse.microprofile.jwt.JsonWebToken;
import org.hibernate.reactive.mutiny.Mutiny;

import io.quarkus.security.identity.SecurityIdentity;
import io.smallrye.mutiny.Uni;
import jakarta.inject.Inject;
import lombok.NoArgsConstructor;
import se.kth.ki.waitapp.core.interfaces.repository.IGenericRepository;
import se.kth.ki.waitapp.core.interfaces.service.IGenericService;
import se.kth.ki.waitapp.core.model.BaseModel;
import se.kth.ki.waitapp.dto.BaseDTO;
import se.kth.ki.waitapp.mappers.IGenericMapper;

@NoArgsConstructor
public abstract class GenericService<T extends BaseModel, TDTO extends BaseDTO> implements IGenericService<T, TDTO> {

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
