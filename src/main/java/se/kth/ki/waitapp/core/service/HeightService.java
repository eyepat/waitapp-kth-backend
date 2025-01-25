package se.kth.ki.waitapp.core.service;

import io.quarkus.security.identity.SecurityIdentity;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import se.kth.ki.waitapp.core.interfaces.repository.IHeightRepository;
import se.kth.ki.waitapp.core.interfaces.service.IHeightService;
import se.kth.ki.waitapp.core.model.metrics.Height;
import se.kth.ki.waitapp.dto.metrics.HeightDTO;
import se.kth.ki.waitapp.mappers.IHeightMapper;

@ApplicationScoped
public class HeightService extends GenericMetricService<Height, HeightDTO> implements IHeightService {

    @Inject
    public HeightService(IHeightMapper mapper, IHeightRepository repository, SecurityIdentity identity) {
        super(mapper, repository, identity);
    }

}
