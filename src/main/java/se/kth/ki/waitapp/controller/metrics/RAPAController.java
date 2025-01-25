package se.kth.ki.waitapp.controller.metrics;

import org.eclipse.microprofile.openapi.annotations.security.SecurityRequirement;

import io.quarkus.security.Authenticated;
import jakarta.inject.Inject;
import jakarta.ws.rs.Path;
import se.kth.ki.waitapp.core.interfaces.service.IRAPAService;
import se.kth.ki.waitapp.dto.metrics.RAPADTO;

@Path("metrics/rapa")
@SecurityRequirement(name = "KeycloakOAuth2")
@SecurityRequirement(name = "OAuth2")
@Authenticated
public class RAPAController extends GenericMetricController<RAPADTO, IRAPAService> {

    @Inject
    public RAPAController(IRAPAService service) {
        super(service);
    }

}
