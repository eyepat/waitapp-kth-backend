package se.kth.ki.waitapp.core.service;

import java.util.Optional;

import io.quarkus.hibernate.reactive.panache.Panache;
import io.smallrye.mutiny.Uni;
import lombok.NoArgsConstructor;
import se.kth.ki.waitapp.core.interfaces.IGenericMetricService;
import se.kth.ki.waitapp.core.model.BaseModel;
import se.kth.ki.waitapp.dto.BaseDTO;
import se.kth.ki.waitapp.mappers.IGenericMapper;

@NoArgsConstructor
public abstract class GenericMetricService<T extends BaseModel, TDTO extends BaseDTO> extends GenericService<T, TDTO>
        implements IGenericMetricService<T, TDTO> {

    public GenericMetricService(IGenericMapper<T, TDTO> mapper) {
        super(mapper);
    }

    @SuppressWarnings("unchecked")
    public Uni<Optional<TDTO>> latest() {
        return Panache.withSession(() -> T.find("ORDER BY timestamp DESC LIMIT 1").firstResult()
                .onItem().transform(entity -> {
                    if (entity == null || !entity.isPersistent()) {
                        return Optional.empty();
                    }
                    return Optional.of(mapper.toDTO((T) entity));
                }));
    }

}
