package se.kth.ki.waitapp.controller;

import jakarta.inject.Inject;
import jakarta.ws.rs.Path;
import se.kth.ki.waitapp.core.interfaces.IBloodPressureService;
import se.kth.ki.waitapp.dto.metrics.BloodPressureDTO;

@Path("bloodpressure")
public class BloodPressureController extends GenericMetricController<BloodPressureDTO, IBloodPressureService> {

    @Inject
    public BloodPressureController(IBloodPressureService service) {
        super(service);
    }

}
