package se.kth.ki.waitapp.core.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.eclipse.microprofile.jwt.JsonWebToken;

import io.quarkus.hibernate.reactive.panache.Panache;
import io.quarkus.security.identity.SecurityIdentity;
import io.smallrye.mutiny.Uni;
import jakarta.inject.Inject;
import lombok.NoArgsConstructor;
import se.kth.ki.waitapp.core.interfaces.IGenericService;
import se.kth.ki.waitapp.core.model.BaseModel;
import se.kth.ki.waitapp.dto.BaseDTO;
import se.kth.ki.waitapp.mappers.IGenericMapper;

@NoArgsConstructor
public abstract class GenericService<T extends BaseModel, TDTO extends BaseDTO> implements IGenericService<T, TDTO> {

    protected SecurityIdentity identity;
    protected IGenericMapper<T, TDTO> mapper;

    @Inject
    JsonWebToken jwt;

    public GenericService(IGenericMapper<T, TDTO> mapper, SecurityIdentity identity) {
        this.mapper = mapper;
        this.identity = identity;
    }

    @SuppressWarnings("unchecked")
    @Override
    public Uni<List<TDTO>> findAll() {
        if (identity == null || identity.isAnonymous()) {
            return Uni.createFrom().failure(new SecurityException("No identity provided"));
        }

        return Panache.withSession(() -> T.findAll().list()
                .onItem().transform(entities -> entities.stream()
                        .map(entity -> mapper.toDTO((T) entity))
                        .toList()));
    }

    @SuppressWarnings("unchecked")
    @Override
    public Uni<Optional<TDTO>> findById(Long id) {
        if (identity == null || identity.isAnonymous()) {
            return Uni.createFrom().failure(new SecurityException("No identity provided"));
        }
        return Panache.withSession(() -> T.find("id", id).firstResult()
                .onItem()
                .transform(entity -> {
                    if (entity == null || !entity.isPersistent()) {
                        return Optional.empty();
                    }
                    return Optional.of(mapper.toDTO((T) entity));
                }));
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

        return Panache.withSession(() -> entity.persistAndFlush()
                .onItem().transform(savedEntity -> {
                    System.out.println(entity);
                    var dto_ = mapper.toDTO(entity);
                    System.out.println(dto_);
                    return dto_;
                }));
    }

    @SuppressWarnings("unchecked")
    @Override
    public Uni<Optional<TDTO>> update(Long id, TDTO dto) {
        if (identity == null || identity.isAnonymous()) {
            return Uni.createFrom().failure(new SecurityException("No identity provided"));
        }
        return Panache.withSession(() -> T.find("id", id).firstResult()
                .onItem().transformToUni(existing -> {
                    if (existing == null) {
                        return Uni.createFrom().item(Optional.empty());
                    }
                    String sub = jwt.getClaim("sub");
                    if (!sub.equals(((T) existing).getOwner().toString()) && !identity.hasRole("admin")) {
                        return Uni.createFrom()
                                .failure(new SecurityException("Not authorized to update this resource"));
                    }
                    mapper.updateEntity(dto, (T) existing);
                    return ((T) existing).persistAndFlush()
                            .onItem().transform(updated -> Optional.of(mapper.toDTO((T) updated)));
                }));
    }

    @Override
    public Uni<Boolean> delete(Long id) {
        if (identity == null || identity.isAnonymous()) {
            return Uni.createFrom().failure(new SecurityException("No identity provided"));
        }
        return Panache.withSession(() -> T.delete("id", id)
                .onItem().transform(deletedCount -> deletedCount > 0));
    }

    @Override
    public Uni<Boolean> existsById(Long id) {
        if (identity == null || identity.isAnonymous()) {
            return Uni.createFrom().failure(new SecurityException("No identity provided"));
        }
        return Panache.withSession(() -> T.count("id", id)
                .map(count -> count > 0));
    }
}
