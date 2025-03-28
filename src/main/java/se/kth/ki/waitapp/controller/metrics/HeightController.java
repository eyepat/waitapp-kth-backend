package se.kth.ki.waitapp.controller.metrics;

import org.eclipse.microprofile.openapi.annotations.security.SecurityRequirement;

import io.quarkus.security.Authenticated;
import jakarta.inject.Inject;
import jakarta.ws.rs.Path;
import se.kth.ki.waitapp.core.interfaces.service.IHeightService;
import se.kth.ki.waitapp.dto.metrics.HeightDTO;

@Path("metrics/height")
@SecurityRequirement(name = "SecurityScheme")
@Authenticated
public class HeightController extends GenericMetricController<HeightDTO, IHeightService> {

    @Inject
    public HeightController(IHeightService service) {
        super(service);
    }

}
