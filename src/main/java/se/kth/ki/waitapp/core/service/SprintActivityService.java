package se.kth.ki.waitapp.core.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.quarkus.hibernate.reactive.panache.common.WithTransaction;
import io.quarkus.security.identity.SecurityIdentity;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;

import se.kth.ki.waitapp.core.interfaces.repository.ISprintActivityRepository;
import se.kth.ki.waitapp.core.interfaces.repository.ITaskRepository;
import se.kth.ki.waitapp.core.interfaces.service.ISprintActivityService;
import se.kth.ki.waitapp.core.model.sprint.Level;
import se.kth.ki.waitapp.core.model.sprint.SprintActivity;
import se.kth.ki.waitapp.core.model.sprint.SprintType;
import se.kth.ki.waitapp.dto.sprint.SprintActivityDTO;
import se.kth.ki.waitapp.mappers.ISprintActivityMapper;

@ApplicationScoped
public class SprintActivityService extends GenericOwnableService<SprintActivity, SprintActivityDTO>
                implements ISprintActivityService {

        @Inject
        ITaskRepository taskRepository;

        private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

        @Inject
        public SprintActivityService(ISprintActivityMapper mapper, ISprintActivityRepository repository,
                        SecurityIdentity identity) {
                super(mapper, repository, identity);
        }

        @Transactional
        @WithTransaction
        @Override
        public Uni<List<SprintActivity>> getSprintActivitiesForUser(UUID userID, Level sprintLevel,
                        SprintType sprintType,
                        int amount) {
                return taskRepository.find(
                                "where sprintNr = ?3 and level = ?1 and type = ?2 and active = true order by dateOffset",
                                sprintLevel,
                                sprintType, 0).page(0, amount).list()
                                .onFailure().invoke(e -> LOGGER.error("Error fetching tasks: ", e))
                                .map(tasks -> {
                                        List<SprintActivity> sprintActivities = new ArrayList<>();
                                        sprintActivities.addAll(tasks
                                                        .stream()
                                                        .map(task -> SprintActivity
                                                                        .builder()
                                                                        .owner(userID)
                                                                        .task(task)
                                                                        .assignedDate(LocalDate
                                                                                        .now()
                                                                                        .plusDays(task.getDateOffset()))
                                                                        .completed(false)
                                                                        .build())
                                                        .toList());
                                        return sprintActivities;
                                });

        }

        @Override
        public Uni<Boolean> markCompleted(Long id, Boolean value) {
                if (identity == null || identity.isAnonymous()) {
                        return Uni.createFrom().failure(new SecurityException("No identity provided"));
                }

                String sub = jwt.getSubject();
                if (sub == null || sub.isEmpty()) {
                        return Uni.createFrom().failure(new SecurityException("Unable to get subject from JWT"));
                }
                UUID owner = UUID.fromString(sub);

                return sf.withSession(session -> {
                        return repository.find("id = ?1", id).firstResult()
                                        .onItem().transformToUni(entity -> {
                                                if (entity == null) {
                                                        return Uni.createFrom().failure(
                                                                        new NotFoundException("Entity not found"));
                                                }

                                                boolean isOwner = entity.getOwner().equals(owner);
                                                boolean isAdmin = identity.hasRole("admin");

                                                if (!isOwner && !isAdmin) {
                                                        return Uni.createFrom().failure(new SecurityException(
                                                                        "User is not the owner or an admin"));
                                                }

                                                entity.setCompleted(value);

                                                return repository.persistAndFlush(entity)
                                                                .onItem().transform(savedEntity -> true);
                                        });
                });
        }

}
