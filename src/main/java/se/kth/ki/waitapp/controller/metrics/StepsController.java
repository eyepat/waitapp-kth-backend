package se.kth.ki.waitapp.controller.metrics;

import org.eclipse.microprofile.openapi.annotations.security.SecurityRequirement;

import io.quarkus.security.Authenticated;
import jakarta.inject.Inject;
import jakarta.ws.rs.Path;
import se.kth.ki.waitapp.core.interfaces.service.IStepsService;
import se.kth.ki.waitapp.dto.metrics.StepsDTO;

@Path("metrics/steps")
@SecurityRequirement(name = "SecurityScheme")
@Authenticated
public class StepsController extends GenericMetricController<StepsDTO, IStepsService> {

    @Inject
    public StepsController(IStepsService service) {
        super(service);
    }

}
