package se.kth.ki.waitapp.core.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import se.kth.ki.waitapp.core.interfaces.IHeightService;
import se.kth.ki.waitapp.core.model.metrics.Height;
import se.kth.ki.waitapp.dto.metrics.HeightDTO;
import se.kth.ki.waitapp.mappers.IHeightMapper;

@ApplicationScoped
public class HeightService extends GenericMetricService<Height, HeightDTO> implements IHeightService {

    @Inject
    public HeightService(IHeightMapper mapper) {
        super(mapper);
    }

}
