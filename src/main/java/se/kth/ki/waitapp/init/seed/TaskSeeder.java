package se.kth.ki.waitapp.init.seed;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.reactive.mutiny.Mutiny;

import io.quarkus.runtime.StartupEvent;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;
import jakarta.inject.Inject;
import se.kth.ki.waitapp.core.interfaces.repository.ITaskRepository;
import se.kth.ki.waitapp.core.model.sprint.Level;
import se.kth.ki.waitapp.core.model.sprint.SprintType;
import se.kth.ki.waitapp.core.model.sprint.Task;
import se.kth.ki.waitapp.core.model.sprint.TaskVariant;

@ApplicationScoped
public class TaskSeeder {

    @Inject
    ITaskRepository repository;

    @Inject
    Mutiny.SessionFactory sf;

    public void onStart(@Observes StartupEvent ev) {
        sf.withSession(s -> repository.count())
                .onItem().transformToUni(count -> {
                    if (count == 0) {
                        // If count is 0, seed the data
                        return seedTasks();
                    } else {
                        // Skip seeding if data exists
                        return Uni.createFrom().voidItem();
                    }
                })
                .subscribe().with(
                        ignored -> {
                            // Successful completion, no-op
                        },
                        failure -> {
                            failure.printStackTrace();
                        });
    }

    private Uni<Void> seedTasks() {
        List<Task> tasks = new ArrayList<>();

        // Walking, Cycling, Swimming Task (Physical type)
        tasks.add(Task.builder()
                .type(SprintType.PHYSICAL)
                .level(Level.LOW)
                .variant(TaskVariant.ACTIVE)
                .title("walking-cycling-swimming-30min-workout")
                .description("walking-cycling-swimming-30min-workout-desc")
                .videoURL("")
                .build());

        tasks.add(Task.builder()
                .type(SprintType.PHYSICAL)
                .level(Level.MEDIUM)
                .variant(TaskVariant.ACTIVE)
                .title("walking-cycling-swimming-45min-workout")
                .description("walking-cycling-swimming-45min-workout-desc")
                .videoURL("")
                .build());

        tasks.add(Task.builder()
                .type(SprintType.PHYSICAL)
                .level(Level.HIGH)
                .variant(TaskVariant.ACTIVE)
                .title("walking-cycling-swimming-60min-workout")
                .description("walking-cycling-swimming-60min-workout-desc")
                .videoURL("")
                .build());

        // Resting Task (REST variant)
        tasks.add(Task.builder()
                .type(SprintType.PHYSICAL)
                .level(Level.LOW)
                .variant(TaskVariant.REST)
                .title("resting-workout")
                .description("resting-workout-desc")
                .videoURL("")
                .build());

        tasks.add(Task.builder()
                .type(SprintType.PHYSICAL)
                .level(Level.MEDIUM)
                .variant(TaskVariant.REST)
                .title("resting-workout-medium")
                .description("resting-workout-medium-desc")
                .videoURL("")
                .build());

        tasks.add(Task.builder()
                .type(SprintType.PHYSICAL)
                .level(Level.HIGH)
                .variant(TaskVariant.REST)
                .title("resting-workout-high")
                .description("resting-workout-high-desc")
                .videoURL("")
                .build());

        // Exercise 3 Tasks (Physical type)
        tasks.add(Task.builder()
                .type(SprintType.PHYSICAL)
                .level(Level.LOW)
                .variant(TaskVariant.ACTIVE)
                .title("exercise-1")
                .description("simple-three-workouts-desc")
                .videoURL("https://www.youtube.com/embed/-1qQjeHZEfY")
                .build());

        tasks.add(Task.builder()
                .type(SprintType.PHYSICAL)
                .level(Level.MEDIUM)
                .variant(TaskVariant.ACTIVE)
                .title("exercise-1-medium")
                .description("simple-three-workouts-medium-desc")
                .videoURL("https://www.youtube.com/embed/-1qQjeHZEfY")
                .build());

        tasks.add(Task.builder()
                .type(SprintType.PHYSICAL)
                .level(Level.HIGH)
                .variant(TaskVariant.ACTIVE)
                .title("exercise-1-high")
                .description("simple-three-workouts-high-desc")
                .videoURL("https://www.youtube.com/embed/-1qQjeHZEfY")
                .build());

        tasks.add(Task.builder()
                .type(SprintType.PHYSICAL)
                .level(Level.LOW)
                .variant(TaskVariant.ACTIVE)
                .title("exercise-2")
                .description("simple-three-workouts-desc")
                .videoURL("https://www.youtube.com/embed/qW3Zr1VAJYE")
                .build());

        tasks.add(Task.builder()
                .type(SprintType.PHYSICAL)
                .level(Level.MEDIUM)
                .variant(TaskVariant.ACTIVE)
                .title("exercise-2-medium")
                .description("simple-three-workouts-medium-desc")
                .videoURL("https://www.youtube.com/embed/qW3Zr1VAJYE")
                .build());

        tasks.add(Task.builder()
                .type(SprintType.PHYSICAL)
                .level(Level.HIGH)
                .variant(TaskVariant.ACTIVE)
                .title("exercise-2-high")
                .description("simple-three-workouts-high-desc")
                .videoURL("https://www.youtube.com/embed/qW3Zr1VAJYE")
                .build());

        tasks.add(Task.builder()
                .type(SprintType.PHYSICAL)
                .level(Level.LOW)
                .variant(TaskVariant.ACTIVE)
                .title("exercise-3")
                .description("simple-three-workouts-desc")
                .videoURL("https://www.youtube.com/embed/179xw7lGbPc")
                .build());

        tasks.add(Task.builder()
                .type(SprintType.PHYSICAL)
                .level(Level.MEDIUM)
                .variant(TaskVariant.ACTIVE)
                .title("exercise-3-medium")
                .description("simple-three-workouts-medium-desc")
                .videoURL("https://www.youtube.com/embed/179xw7lGbPc")
                .build());

        tasks.add(Task.builder()
                .type(SprintType.PHYSICAL)
                .level(Level.HIGH)
                .variant(TaskVariant.ACTIVE)
                .title("exercise-3-high")
                .description("simple-three-workouts-high-desc")
                .videoURL("https://www.youtube.com/embed/179xw7lGbPc")
                .build());

        // Exercise 4 Tasks (Physical type)
        tasks.add(Task.builder()
                .type(SprintType.PHYSICAL)
                .level(Level.LOW)
                .variant(TaskVariant.ACTIVE)
                .title("exercise-1")
                .description("simple-three-workouts-desc")
                .videoURL("https://www.youtube.com/embed/XqBtWqmitk8")
                .build());

        tasks.add(Task.builder()
                .type(SprintType.PHYSICAL)
                .level(Level.MEDIUM)
                .variant(TaskVariant.ACTIVE)
                .title("exercise-1-medium")
                .description("simple-three-workouts-medium-desc")
                .videoURL("https://www.youtube.com/embed/XqBtWqmitk8")
                .build());

        tasks.add(Task.builder()
                .type(SprintType.PHYSICAL)
                .level(Level.HIGH)
                .variant(TaskVariant.ACTIVE)
                .title("exercise-1-high")
                .description("simple-three-workouts-high-desc")
                .videoURL("https://www.youtube.com/embed/XqBtWqmitk8")
                .build());

        tasks.add(Task.builder()
                .type(SprintType.PHYSICAL)
                .level(Level.LOW)
                .variant(TaskVariant.ACTIVE)
                .title("exercise-2")
                .description("simple-three-workouts-desc")
                .videoURL("https://www.youtube.com/embed/Ypxw7Jcit1c")
                .build());

        tasks.add(Task.builder()
                .type(SprintType.PHYSICAL)
                .level(Level.MEDIUM)
                .variant(TaskVariant.ACTIVE)
                .title("exercise-2-medium")
                .description("simple-three-workouts-medium-desc")
                .videoURL("https://www.youtube.com/embed/Ypxw7Jcit1c")
                .build());

        tasks.add(Task.builder()
                .type(SprintType.PHYSICAL)
                .level(Level.HIGH)
                .variant(TaskVariant.ACTIVE)
                .title("exercise-2-high")
                .description("simple-three-workouts-high-desc")
                .videoURL("https://www.youtube.com/embed/Ypxw7Jcit1c")
                .build());

        tasks.add(Task.builder()
                .type(SprintType.PHYSICAL)
                .level(Level.LOW)
                .variant(TaskVariant.ACTIVE)
                .title("exercise-3")
                .description("simple-three-workouts-desc")
                .videoURL("https://www.youtube.com/embed/USyW4xv3BIQ")
                .build());

        tasks.add(Task.builder()
                .type(SprintType.PHYSICAL)
                .level(Level.MEDIUM)
                .variant(TaskVariant.ACTIVE)
                .title("exercise-3-medium")
                .description("simple-three-workouts-medium-desc")
                .videoURL("https://www.youtube.com/embed/USyW4xv3BIQ")
                .build());

        tasks.add(Task.builder()
                .type(SprintType.PHYSICAL)
                .level(Level.HIGH)
                .variant(TaskVariant.ACTIVE)
                .title("exercise-3-high")
                .description("simple-three-workouts-high-desc")
                .videoURL("https://www.youtube.com/embed/USyW4xv3BIQ")
                .build());

        tasks.add(Task.builder()
                .type(SprintType.PHYSICAL)
                .level(Level.LOW)
                .variant(TaskVariant.ACTIVE)
                .title("exercise-4")
                .description("simple-three-workouts-desc")
                .videoURL("https://www.youtube.com/embed/179xw7lGbPc")
                .build());

        tasks.add(Task.builder()
                .type(SprintType.PHYSICAL)
                .level(Level.MEDIUM)
                .variant(TaskVariant.ACTIVE)
                .title("exercise-4-medium")
                .description("simple-three-workouts-medium-desc")
                .videoURL("https://www.youtube.com/embed/179xw7lGbPc")
                .build());

        tasks.add(Task.builder()
                .type(SprintType.PHYSICAL)
                .level(Level.HIGH)
                .variant(TaskVariant.ACTIVE)
                .title("exercise-4-high")
                .description("simple-three-workouts-high-desc")
                .videoURL("https://www.youtube.com/embed/179xw7lGbPc")
                .build());

        // Cardio and Strength Task (Physical type)
        tasks.add(Task.builder()
                .type(SprintType.PHYSICAL)
                .level(Level.LOW)
                .variant(TaskVariant.ACTIVE)
                .title("cardio-strength-1")
                .description("cardio-and-strength")
                .videoURL("")
                .build());

        tasks.add(Task.builder()
                .type(SprintType.PHYSICAL)
                .level(Level.MEDIUM)
                .variant(TaskVariant.ACTIVE)
                .title("cardio-strength-2")
                .description("cardio-and-strength")
                .videoURL("")
                .build());

        tasks.add(Task.builder()
                .type(SprintType.PHYSICAL)
                .level(Level.HIGH)
                .variant(TaskVariant.ACTIVE)
                .title("cardio-strength-3")
                .description("cardio-and-strength")
                .videoURL("")
                .build());

        return sf.withSession(s -> {
            return repository.getSession().withContext((session, context) -> {
                return repository.persist(tasks.stream())
                        .onItem().invoke(ignored -> {
                            // Log the successful persistence of tasks
                            System.out.println("Tasks have been persisted successfully.");
                        })
                        .chain(ignored -> {
                            // Query the repository to get the number of persisted tasks
                            return repository.count();
                        })
                        .onItem().invoke(count -> {
                            // Log the number of tasks persisted in the repository
                            System.out.println("Number of tasks persisted in the repository: " + count);
                        })
                        .onFailure().invoke(failure -> {
                            // Log any failure during persistence
                            System.err.println("Error while persisting tasks: " + failure.getMessage());
                            failure.printStackTrace();
                        })
                        .onItem().ignore().andContinueWithNull();
            });
        });

    }
}
