package se.kth.ki.waitapp.core.service;

import java.util.List;
import java.util.Optional;

import io.quarkus.hibernate.reactive.panache.Panache;
import io.smallrye.mutiny.Uni;
import lombok.NoArgsConstructor;
import se.kth.ki.waitapp.core.interfaces.IGenericService;
import se.kth.ki.waitapp.core.model.BaseModel;
import se.kth.ki.waitapp.dto.BaseDTO;
import se.kth.ki.waitapp.mappers.IGenericMapper;

@NoArgsConstructor
public abstract class GenericService<T extends BaseModel, TDTO extends BaseDTO> implements IGenericService<T, TDTO> {
    protected IGenericMapper<T, TDTO> mapper;

    public GenericService(IGenericMapper<T, TDTO> mapper) {
        this.mapper = mapper;
    }

    @SuppressWarnings("unchecked")
    @Override
    public Uni<List<TDTO>> findAll() {
        return Panache.withSession(() -> T.findAll().list()
                .onItem().transform(entities -> entities.stream()
                        .map(entity -> mapper.toDTO((T) entity))
                        .toList()));
    }

    @SuppressWarnings("unchecked")
    @Override
    public Uni<Optional<TDTO>> findById(Long id) {
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
        T entity = mapper.toEntity(dto);
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
        return Panache.withSession(() -> T.find("id", id).firstResult()
                .onItem().transformToUni(existing -> {
                    if (existing == null) {
                        return Uni.createFrom().item(Optional.empty());
                    }
                    mapper.updateEntity(dto, (T) existing);
                    return ((T) existing).persistAndFlush()
                            .onItem().transform(updated -> Optional.of(mapper.toDTO((T) updated)));
                }));
    }

    @Override
    public Uni<Boolean> delete(Long id) {
        return Panache.withSession(() -> T.delete("id", id)
                .onItem().transform(deletedCount -> deletedCount > 0));
    }

    @Override
    public Uni<Boolean> existsById(Long id) {
        return Panache.withSession(() -> T.count("id", id)
                .map(count -> count > 0));
    }
}
