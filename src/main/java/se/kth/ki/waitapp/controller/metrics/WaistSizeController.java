package se.kth.ki.waitapp.controller.metrics;

import org.eclipse.microprofile.openapi.annotations.security.SecurityRequirement;

import io.quarkus.security.Authenticated;
import jakarta.inject.Inject;
import jakarta.ws.rs.Path;
import se.kth.ki.waitapp.core.interfaces.service.IWaistSizeService;
import se.kth.ki.waitapp.dto.metrics.WaistSizeDTO;

@Path("waistsize")
@SecurityRequirement(name = "KeycloakOAuth2")
@SecurityRequirement(name = "OAuth2")
@Authenticated
public class WaistSizeController extends GenericMetricController<WaistSizeDTO, IWaistSizeService> {

    @Inject
    public WaistSizeController(IWaistSizeService service) {
        super(service);
    }

}
