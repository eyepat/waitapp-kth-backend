package se.kth.ki.waitapp.controller.metrics;

import org.eclipse.microprofile.openapi.annotations.security.SecurityRequirement;

import io.quarkus.security.Authenticated;
import jakarta.inject.Inject;
import jakarta.ws.rs.Path;
import se.kth.ki.waitapp.core.interfaces.service.IWeightService;
import se.kth.ki.waitapp.dto.metrics.WeightDTO;

@Path("metrics/weight")
@SecurityRequirement(name = "SecurityScheme")
@Authenticated
public class WeightController extends GenericMetricController<WeightDTO, IWeightService> {

    @Inject
    public WeightController(IWeightService service) {
        super(service);
    }
}
