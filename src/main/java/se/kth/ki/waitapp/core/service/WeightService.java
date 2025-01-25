package se.kth.ki.waitapp.core.service;

import io.quarkus.security.identity.SecurityIdentity;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import se.kth.ki.waitapp.core.interfaces.repository.IWeightRepository;
import se.kth.ki.waitapp.core.interfaces.service.IWeightService;
import se.kth.ki.waitapp.core.model.metrics.Weight;
import se.kth.ki.waitapp.dto.metrics.WeightDTO;
import se.kth.ki.waitapp.mappers.IWeightMapper;

@ApplicationScoped
public class WeightService extends GenericMetricService<Weight, WeightDTO> implements IWeightService {

    @Inject
    public WeightService(IWeightMapper mapper, IWeightRepository repository, SecurityIdentity identity) {
        super(mapper, repository, identity);
    }

}
