package se.kth.ki.waitapp.core.service;

import io.quarkus.security.identity.SecurityIdentity;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import se.kth.ki.waitapp.core.interfaces.repository.IWaistSizeRepository;
import se.kth.ki.waitapp.core.interfaces.service.IWaistSizeService;
import se.kth.ki.waitapp.core.model.metrics.WaistSize;
import se.kth.ki.waitapp.dto.metrics.WaistSizeDTO;
import se.kth.ki.waitapp.mappers.IWaistSizeMapper;

@ApplicationScoped
public class WaistSizeService extends GenericMetricService<WaistSize, WaistSizeDTO> implements IWaistSizeService {

    @Inject
    public WaistSizeService(IWaistSizeMapper mapper, IWaistSizeRepository repository, SecurityIdentity identity) {
        super(mapper, repository, identity);
    }

}
