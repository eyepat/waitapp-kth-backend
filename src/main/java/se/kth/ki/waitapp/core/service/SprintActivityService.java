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
import se.kth.ki.waitapp.core.model.sprint.Task;
import se.kth.ki.waitapp.core.model.sprint.TaskVariant;
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

        // TODO: look at previous activities to make sure the user gets activities that
        // match
        // TODO: make it work smarter, needs to balance so there are rest tasks too
        // (Variant is REST) and order them
        // TODO: make it based on the users needs
        // Parallel didnt work, got ("Illegal pop() with non-matching
        // JdbcValuesSourceProcessingState), hence the sequential querying :(
        @Transactional
        @WithTransaction
        @Override
        public Uni<List<SprintActivity>> getSprintActivitiesForUser(UUID userID, Level sprintLevel,
                        SprintType sprintType,
                        int amount) {
                return taskRepository
                                .find("level = ?1 and type = ?2 and variant != ?3 and active = true", sprintLevel,
                                                sprintType,
                                                TaskVariant.REST)
                                .page(0, amount)
                                .list()
                                .onFailure().invoke(e -> LOGGER.error("Error fetching active tasks: ", e))
                                .flatMap(activeTasks -> taskRepository
                                                .find("level = ?1 and type = ?2 and variant = ?3 and active = true",
                                                                sprintLevel, sprintType,
                                                                TaskVariant.REST)
                                                .page(0, amount)
                                                .list()
                                                .onFailure().invoke(e -> LOGGER.error("Error fetching rest tasks: ", e))
                                                .flatMap(restTasks -> repository
                                                                .find("owner = ?1 and completed = true", userID)
                                                                .list()
                                                                .onFailure()
                                                                .invoke(e -> LOGGER.error(
                                                                                "Error fetching previous activities: ",
                                                                                e))
                                                                .onFailure().recoverWithItem(List.of())
                                                                .map(previousActivities -> {
                                                                        // Step 5: Filter tasks to exclude those that
                                                                        // have already been completed
                                                                        List<Task> availableActiveTasks = activeTasks
                                                                                        .stream()
                                                                                        .filter(task -> previousActivities
                                                                                                        .stream()
                                                                                                        .noneMatch(activity -> activity
                                                                                                                        .getTask()
                                                                                                                        .equals(task)))
                                                                                        .toList();

                                                                        List<Task> availableRestTasks = restTasks
                                                                                        .stream()
                                                                                        .filter(task -> previousActivities
                                                                                                        .stream()
                                                                                                        .noneMatch(activity -> activity
                                                                                                                        .getTask()
                                                                                                                        .equals(task)))
                                                                                        .toList();

                                                                        // Balance tasks with REST tasks (Variant.REST)
                                                                        int normalTasksNeeded = amount - Math.min(
                                                                                        availableRestTasks.size(),
                                                                                        amount);
                                                                        normalTasksNeeded = Math.min(normalTasksNeeded,
                                                                                        availableActiveTasks.size());

                                                                        // Step 6: Prepare SprintActivity list
                                                                        List<SprintActivity> sprintActivities = new ArrayList<>();
                                                                        sprintActivities.addAll(availableActiveTasks
                                                                                        .stream()
                                                                                        .limit(normalTasksNeeded)
                                                                                        .map(task -> SprintActivity
                                                                                                        .builder()
                                                                                                        .owner(userID)
                                                                                                        .task(task)
                                                                                                        .assignedDate(LocalDate
                                                                                                                        .now())
                                                                                                        .completed(false)
                                                                                                        .build())
                                                                                        .toList());

                                                                        // Step 7: Add REST tasks
                                                                        int restCount = Math.min(
                                                                                        availableRestTasks.size(),
                                                                                        amount - sprintActivities
                                                                                                        .size());
                                                                        sprintActivities.addAll(availableRestTasks
                                                                                        .stream()
                                                                                        .limit(restCount)
                                                                                        .map(task -> SprintActivity
                                                                                                        .builder()
                                                                                                        .owner(userID)
                                                                                                        .task(task)
                                                                                                        .assignedDate(LocalDate
                                                                                                                        .now())
                                                                                                        .completed(false)
                                                                                                        .build())
                                                                                        .toList());

                                                                        // Step 8: Ensure enough tasks are available,
                                                                        // refill if needed
                                                                        if (sprintActivities.size() < amount) {
                                                                                List<Task> remainingTasks = activeTasks
                                                                                                .stream()
                                                                                                .filter(task -> !sprintActivities
                                                                                                                .stream()
                                                                                                                .anyMatch(activity -> activity
                                                                                                                                .getTask()
                                                                                                                                .equals(task)))
                                                                                                .toList();
                                                                                sprintActivities.addAll(remainingTasks
                                                                                                .stream()
                                                                                                .limit(amount - sprintActivities
                                                                                                                .size())
                                                                                                .map(task -> SprintActivity
                                                                                                                .builder()
                                                                                                                .owner(userID)
                                                                                                                .task(task)
                                                                                                                .assignedDate(LocalDate
                                                                                                                                .now())
                                                                                                                .completed(false)
                                                                                                                .build())
                                                                                                .toList());
                                                                        }

                                                                        if (sprintActivities.size() < amount) {
                                                                                LOGGER.error("Unable to fill requested activities, requested "
                                                                                                + amount
                                                                                                + ", but only got "
                                                                                                + sprintActivities
                                                                                                                .size());
                                                                        }

                                                                        if (sprintActivities.size() == 0) {
                                                                                throw new IllegalStateException(
                                                                                                "Unable to find any tasks");
                                                                        }

                                                                        return sprintActivities;
                                                                })));
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
                                        return Uni.createFrom().failure(new NotFoundException("Entity not found"));
                                }

                                boolean isOwner = entity.getOwner().equals(owner);
                                boolean isAdmin = identity.hasRole("admin");

                                if (!isOwner && !isAdmin) {
                                        return Uni.createFrom().failure(new SecurityException("User is not the owner or an admin"));
                                }

                                entity.setCompleted(value);

                                return repository.persistAndFlush(entity)
                                        .onItem().transform(savedEntity -> true);
                                });
                });
        }

}
