package se.kth.ki.waitapp.controller.metrics;

import jakarta.inject.Inject;
import jakarta.ws.rs.Path;
import se.kth.ki.waitapp.core.interfaces.IStepsService;
import se.kth.ki.waitapp.dto.metrics.StepsDTO;

@Path("metrics/steps")
public class StepsController extends GenericMetricController<StepsDTO, IStepsService> {

    @Inject
    public StepsController(IStepsService service) {
        super(service);
    }

}
