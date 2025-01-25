package se.kth.ki.waitapp.core.service;

import io.quarkus.security.identity.SecurityIdentity;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import se.kth.ki.waitapp.core.interfaces.repository.IStepsRepository;
import se.kth.ki.waitapp.core.interfaces.service.IStepsService;
import se.kth.ki.waitapp.core.model.metrics.Steps;
import se.kth.ki.waitapp.dto.metrics.StepsDTO;
import se.kth.ki.waitapp.mappers.IStepsMapper;

@ApplicationScoped
public class StepsService extends GenericMetricService<Steps, StepsDTO> implements IStepsService {

    @Inject
    public StepsService(IStepsMapper mapper, IStepsRepository repository, SecurityIdentity identity) {
        super(mapper, repository, identity);
    }

}
