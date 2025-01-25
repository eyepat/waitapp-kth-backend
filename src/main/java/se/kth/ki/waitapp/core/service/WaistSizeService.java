package se.kth.ki.waitapp.core.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import se.kth.ki.waitapp.core.interfaces.IWaistSizeService;
import se.kth.ki.waitapp.core.model.metrics.WaistSize;
import se.kth.ki.waitapp.dto.metrics.WaistSizeDTO;
import se.kth.ki.waitapp.mappers.IWaistSizeMapper;

@ApplicationScoped
public class WaistSizeService extends GenericMetricService<WaistSize, WaistSizeDTO> implements IWaistSizeService {

    @Inject
    public WaistSizeService(IWaistSizeMapper mapper) {
        super(mapper);
    }

}
