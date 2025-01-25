package se.kth.ki.waitapp.core.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import se.kth.ki.waitapp.core.interfaces.IBloodPressureService;
import se.kth.ki.waitapp.core.model.metrics.BloodPressure;
import se.kth.ki.waitapp.dto.metrics.BloodPressureDTO;
import se.kth.ki.waitapp.mappers.IBloodPressureMapper;

@ApplicationScoped
public class BloodPressureService extends GenericMetricService<BloodPressure, BloodPressureDTO>
        implements IBloodPressureService {

    @Inject
    public BloodPressureService(IBloodPressureMapper mapper) {
        super(mapper);
    }

}
