package se.kth.ki.waitapp.init.seed;

import java.util.List;

import org.hibernate.reactive.mutiny.Mutiny;

import io.quarkus.runtime.StartupEvent;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.event.Observes;
import lombok.NoArgsConstructor;
import se.kth.ki.waitapp.core.interfaces.repository.IGenericRepository;
import se.kth.ki.waitapp.core.model.IBaseModel;

@NoArgsConstructor
public abstract class GenericSeeder<T extends IBaseModel> {
    private IGenericRepository<T> repository;

    private Mutiny.SessionFactory sf;

    private List<T> seedData;

    public GenericSeeder(IGenericRepository<T> repository, Mutiny.SessionFactory sf, List<T> seedData) {
        this.repository = repository;
        this.sf = sf;
        this.seedData = seedData;
    }

    public void onStart(@Observes StartupEvent ev) {
        sf.withSession(s -> repository.count())
                .onItem().transformToUni(count -> {
                    if (count == 0) {
                        // If count is 0, seed the data
                        return seed(seedData);
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

    private Uni<Void> seed(List<T> data) {
        return sf.withSession(s -> {
            return repository.getSession().withContext((session, context) -> {
                return repository.persist(data.stream())
                        .onItem().invoke(ignored -> {
                            // Log the successful persistence of tasks
                            System.out.println("Data has been persisted successfully.");
                        })
                        .chain(ignored -> {
                            // Query the repository to get the number of persisted tasks
                            return repository.count();
                        })
                        .onItem().invoke(count -> {
                            // Log the number of entities persisted in the repository
                            System.out.println("Number of entities persisted in the repository: " + count);
                        })
                        .onFailure().invoke(failure -> {
                            // Log any failure during persistence
                            System.err.println("Error while persisting entities: " + failure.getMessage());
                            failure.printStackTrace();
                        })
                        .onItem().ignore().andContinueWithNull();
            });
        });
    }
}
