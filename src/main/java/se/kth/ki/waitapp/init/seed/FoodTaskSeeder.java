package se.kth.ki.waitapp.init.seed;

import java.util.List;

import org.hibernate.reactive.mutiny.Mutiny;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import se.kth.ki.waitapp.core.interfaces.repository.ITaskRepository;
import se.kth.ki.waitapp.core.model.sprint.Level;
import se.kth.ki.waitapp.core.model.sprint.SprintType;
import se.kth.ki.waitapp.core.model.sprint.Task;
import se.kth.ki.waitapp.core.model.sprint.TaskVariant;

@ApplicationScoped
public class FoodTaskSeeder extends GenericSeeder<Task> {

    @Inject
    public FoodTaskSeeder(ITaskRepository repository, Mutiny.SessionFactory sf) {
        super(repository, sf, List.of(
                // Food related task seeding

                // LOW Level food tasks
                Task.builder()
                        .type(SprintType.FOOD)
                        .level(Level.LOW)
                        .variant(TaskVariant.ACTIVE)
                        .sprintNr(0)
                        .dateOffset(1)
                        .title("Ät lagom (1 min läsning)")
                        .description(
                                "Tänk på portionsstorleken och lägg inte upp för mycket mat på tallriken. Tips är att använda en mindre tallrik när du tar mat.")
                        .videoURL("")
                        .build()

                , Task.builder()
                        .type(SprintType.FOOD)
                        .level(Level.LOW)
                        .variant(TaskVariant.ACTIVE)
                        .sprintNr(0)
                        .dateOffset(3)
                        .title("Ät regelbundet (1 min läsning)")
                        .description(
                                "Genom att äta regelbundet undviker du att bli alltför hungrig när du väl sitter till bords. Försök att inte låta det gå mer än 3-4 timmar mellan måltiderna.")
                        .videoURL("")
                        .build()

                , Task.builder()
                        .type(SprintType.FOOD)
                        .level(Level.LOW)
                        .variant(TaskVariant.ACTIVE)
                        .sprintNr(0)
                        .dateOffset(5)
                        .title("Goda vanor 1 min läsning")
                        .description(
                                "Det är det du gör varje dag som påverkar din hälsa mest, inte det du gör någon gång ibland.")
                        .videoURL("")
                        .build()

        ));

        // TODO: Add medium and high level tasks laters
    }

}
