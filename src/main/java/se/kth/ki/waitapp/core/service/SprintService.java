package se.kth.ki.waitapp.core.service;

import java.util.Optional;
import java.util.UUID;

import io.quarkus.hibernate.reactive.panache.Panache;
import io.quarkus.security.identity.SecurityIdentity;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import se.kth.ki.waitapp.core.interfaces.ISprintService;
import se.kth.ki.waitapp.core.model.sprint.Sprint;
import se.kth.ki.waitapp.dto.sprint.SprintDTO;
import se.kth.ki.waitapp.mappers.ISprintMapper;

@ApplicationScoped
public class SprintService extends GenericService<Sprint, SprintDTO> implements ISprintService {

    @Inject
    public SprintService(ISprintMapper mapper, SecurityIdentity identity) {
        super(mapper, identity);
    }

    @Override
    public Uni<Optional<SprintDTO>> latest() {
        String sub = (String) jwt.claim("sub").get();
        if (sub == null || sub.isEmpty()) {
            return Uni.createFrom().failure(new SecurityException("not able to get sub from jwt"));
        }
        var owner = UUID.fromString(sub);
        return Panache.withSession(() -> Sprint
                .find("WHERE owner = ?1 ORDER BY CAST(startDate AS date) DESC", owner).firstResult()
                .onItem().transform(entity -> {
                    if (entity == null || !entity.isPersistent()) {
                        return Optional.empty();
                    }
                    return Optional.of(mapper.toDTO((Sprint) entity));
                }));
    }

    @Override
    public Uni<Optional<SprintDTO>> latestActive() {
        String sub = (String) jwt.claim("sub").get();
        if (sub == null || sub.isEmpty()) {
            return Uni.createFrom().failure(new SecurityException("not able to get sub from jwt"));
        }
        var owner = UUID.fromString(sub);
        return Panache.withSession(() -> Sprint.find(
                "WHERE owner = ?1 AND completed = false AND CAST(endDate AS date) >= CURRENT_DATE ORDER BY CAST(startDate AS date) DESC",
                owner).firstResult()
                .onItem().transform(entity -> {
                    if (entity == null || !entity.isPersistent()) {
                        return Optional.empty();
                    }
                    return Optional.of(mapper.toDTO((Sprint) entity));
                }));
    }

}
