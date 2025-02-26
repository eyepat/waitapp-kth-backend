package se.kth.ki.waitapp.core.service;

import java.util.Optional;
import java.util.UUID;

import io.quarkus.security.identity.SecurityIdentity;
import io.smallrye.mutiny.Uni;
import jakarta.inject.Inject;
import jakarta.ws.rs.NotFoundException;
import lombok.NoArgsConstructor;
import se.kth.ki.waitapp.core.interfaces.repository.IGenericMetricRepository;
import se.kth.ki.waitapp.core.interfaces.repository.IUserRepository;
import se.kth.ki.waitapp.core.interfaces.service.IGenericMetricService;
import se.kth.ki.waitapp.core.model.metrics.IGenericMetric;
import se.kth.ki.waitapp.core.model.user.User;
import se.kth.ki.waitapp.dto.IOwnableDTO;
import se.kth.ki.waitapp.mappers.IGenericMapper;

@NoArgsConstructor
public abstract class GenericMetricService<T extends IGenericMetric<?>, TDTO extends IOwnableDTO>
        extends GenericOwnableService<T, TDTO>
        implements IGenericMetricService<T, TDTO> {

    @Inject
    IUserRepository userRepository;

    public GenericMetricService(IGenericMapper<T, TDTO> mapper, IGenericMetricRepository<T> repository,
            SecurityIdentity identity) {
        super(mapper, repository, identity);
    }

    public Uni<Optional<TDTO>> latest() {
        String sub = jwt.getSubject();
        if (sub.isEmpty()) {
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

    @Override
    public Uni<TDTO> create(TDTO dto) {
        if (identity == null || identity.isAnonymous()) {
            return Uni.createFrom().failure(new SecurityException("No identity provided"));
        }
        dto.setId(null);
        T entity = mapper.toEntity(dto);
        String sub = jwt.getClaim("sub");
        var owner = UUID.fromString(sub);
        entity.setOwner(owner);

        return sf.withSession((s) -> {
            return userRepository.find("owner = ?1", owner).firstResult()
                    .onItem().transformToUni(user -> {
                        if (user == null) {
                            return Uni.createFrom().failure(
                                    new NotFoundException("User for keycloak id not found. Please onboard the user"));
                        }
                        entity.setUserID(((User) user).getId());
                        System.out.println(entity);
                        return repository.persistAndFlush(entity)
                                .onItem().transform(savedEntity -> {
                                    System.out.println(entity);
                                    var dto_ = mapper.toDTO(entity);
                                    System.out.println(dto_);
                                    return dto_;
                                });
                    });
        });
    }

}
