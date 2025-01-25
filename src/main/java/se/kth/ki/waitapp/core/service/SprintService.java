package se.kth.ki.waitapp.core.service;

import io.quarkus.security.identity.SecurityIdentity;
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

}
