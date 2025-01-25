package se.kth.ki.waitapp.core.service;

import java.util.Optional;
import java.util.UUID;

import io.quarkus.security.identity.SecurityIdentity;
import io.smallrye.mutiny.Uni;
import lombok.NoArgsConstructor;
import se.kth.ki.waitapp.core.interfaces.repository.IGenericMetricRepository;
import se.kth.ki.waitapp.core.interfaces.service.IGenericMetricService;
import se.kth.ki.waitapp.core.model.metrics.GenericMetric;
import se.kth.ki.waitapp.dto.BaseDTO;
import se.kth.ki.waitapp.mappers.IGenericMapper;

@NoArgsConstructor
public abstract class GenericMetricService<T extends GenericMetric<?>, TDTO extends BaseDTO>
        extends GenericService<T, TDTO>
        implements IGenericMetricService<T, TDTO> {

    public GenericMetricService(IGenericMapper<T, TDTO> mapper, IGenericMetricRepository<T> repository,
            SecurityIdentity identity) {
        super(mapper, repository, identity);
    }

    public Uni<Optional<TDTO>> latest() {
        String sub = (String) jwt.claim("sub").get();
        if (sub == null || sub.isEmpty()) {
            return Uni.createFrom().failure(new SecurityException("not able to get sub from jwt"));
        }
        var owner = UUID.fromString(sub);
        return sf.withSession((s) -> {
            return repository.find("WHERE owner = ?1 ORDER BY timestamp DESC", owner).firstResult()
                    .onItem().transform(entity -> {
                        if (entity == null || !entity.isPersistent()) {
                            return Optional.empty();
                        }
                        return Optional.of(mapper.toDTO(entity));
                    });
        });
    }

}
