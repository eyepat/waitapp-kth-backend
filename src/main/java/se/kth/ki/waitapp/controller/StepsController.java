package se.kth.ki.waitapp.controller;

import jakarta.inject.Inject;
import jakarta.ws.rs.Path;
import se.kth.ki.waitapp.core.interfaces.IStepsService;
import se.kth.ki.waitapp.dto.metrics.StepsDTO;

@Path("steps")
public class StepsController extends GenericMetricController<StepsDTO, IStepsService> {

    @Inject
    public StepsController(IStepsService service) {
        super(service);
    }

}
