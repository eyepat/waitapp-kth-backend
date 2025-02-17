package se.kth.ki.waitapp.core.service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Optional;
import java.util.UUID;

import io.quarkus.hibernate.reactive.panache.Panache;
import io.quarkus.security.identity.SecurityIdentity;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import se.kth.ki.waitapp.core.interfaces.repository.ISprintRepository;
import se.kth.ki.waitapp.core.interfaces.service.ISprintActivityService;
import se.kth.ki.waitapp.core.interfaces.service.ISprintService;
import se.kth.ki.waitapp.core.model.sprint.Sprint;
import se.kth.ki.waitapp.dto.sprint.SprintDTO;
import se.kth.ki.waitapp.mappers.ISprintMapper;

@ApplicationScoped
public class SprintService extends GenericService<Sprint, SprintDTO> implements ISprintService {

    @Inject
    ISprintActivityService sprintActivityService;

    @Inject
    public SprintService(ISprintMapper mapper, ISprintRepository repository, SecurityIdentity identity) {
        super(mapper, repository, identity);
    }

    @Override
    public Uni<Optional<SprintDTO>> latest() {
        String sub = jwt.getSubject();
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
        String sub = jwt.getSubject();
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

    @Override
    public Uni<SprintDTO> create(SprintDTO dto) {
        if (identity == null || identity.isAnonymous()) {
            return Uni.createFrom().failure(new SecurityException("No identity provided"));
        }

        dto.setId(null);
        var entity = mapper.toEntity(dto);
        String sub = jwt.getClaim("sub");
        UUID user = UUID.fromString(sub);
        entity.setOwner(UUID.fromString(sub));

        if (dto.getStartDate() == null) {
            dto.setStartDate(LocalDate.now());
        }
        if (dto.getEndDate() == null) {
            dto.setEndDate(dto.getStartDate().plusDays(10));
        }
        int daysBetween = (int) ChronoUnit.DAYS.between(dto.getStartDate(), dto.getEndDate());

        return sprintActivityService.getSprintActivitiesForUser(user, dto.getLevel(), dto.getSprintType(), daysBetween)
                .onItem().transformToUni(activities -> {
                    // Set the fetched activities on the entity
                    activities.forEach((a) -> a.setSprint(entity));
                    entity.setActivities(activities);

                    // Persist the Sprint entity along with its activities
                    return sf.withSession(s -> {
                        return repository.persistAndFlush(entity)
                                .onItem().transform(savedEntity -> {
                                    // Convert the saved entity to a DTO and return
                                    var dto_ = mapper.toDTO(savedEntity);
                                    return dto_;
                                });
                    });
                });
    }

}
