package se.kth.ki.waitapp.core.service;

import io.quarkus.security.identity.SecurityIdentity;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import se.kth.ki.waitapp.core.interfaces.repository.IRAPARepository;
import se.kth.ki.waitapp.core.interfaces.service.IRAPAService;
import se.kth.ki.waitapp.core.model.metrics.RAPA;
import se.kth.ki.waitapp.dto.metrics.RAPADTO;
import se.kth.ki.waitapp.mappers.IRAPAMapper;

@ApplicationScoped
public class RAPAService extends GenericMetricService<RAPA, RAPADTO> implements IRAPAService {

    @Inject
    public RAPAService(IRAPAMapper mapper, IRAPARepository repository, SecurityIdentity identity) {
        super(mapper, repository, identity);
    }

}
