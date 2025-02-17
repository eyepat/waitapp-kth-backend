package se.kth.ki.waitapp.core.service;

import io.quarkus.security.identity.SecurityIdentity;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import se.kth.ki.waitapp.core.interfaces.repository.ISprintActivityRepository;
import se.kth.ki.waitapp.core.interfaces.service.ISprintActivityService;
import se.kth.ki.waitapp.core.model.sprint.SprintActivity;
import se.kth.ki.waitapp.dto.sprint.SprintActivityDTO;
import se.kth.ki.waitapp.mappers.ISprintActivityMapper;

@ApplicationScoped
public class SprintActivityService extends GenericService<SprintActivity, SprintActivityDTO>
        implements ISprintActivityService {

    @Inject
    public SprintActivityService(ISprintActivityMapper mapper, ISprintActivityRepository repository,
            SecurityIdentity identity) {
        super(mapper, repository, identity);
    }
}
