package se.kth.ki.waitapp.controller;

import org.eclipse.microprofile.openapi.annotations.security.SecurityRequirement;

import io.quarkus.security.Authenticated;
import jakarta.inject.Inject;
import jakarta.ws.rs.Path;
import se.kth.ki.waitapp.core.interfaces.ISprintService;
import se.kth.ki.waitapp.dto.sprint.SprintDTO;

@Path("sprint")
@SecurityRequirement(name = "KeycloakOAuth2")
@Authenticated
public class SprintController extends GenericController<SprintDTO, ISprintService> {

    @Inject
    public SprintController(ISprintService service) {
        super(service);
    }

}
