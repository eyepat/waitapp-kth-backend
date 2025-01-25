package se.kth.ki.waitapp.controller.metrics;

import org.eclipse.microprofile.openapi.annotations.security.SecurityRequirement;

import io.quarkus.security.Authenticated;
import jakarta.inject.Inject;
import jakarta.ws.rs.Path;
import se.kth.ki.waitapp.core.interfaces.service.IBloodPressureService;
import se.kth.ki.waitapp.dto.metrics.BloodPressureDTO;

@Path("metrics/bloodpressure")
@SecurityRequirement(name = "KeycloakOAuth2")
@SecurityRequirement(name = "OAuth2")
@Authenticated
public class BloodPressureController extends GenericMetricController<BloodPressureDTO, IBloodPressureService> {

    @Inject
    public BloodPressureController(IBloodPressureService service) {
        super(service);
    }

}
