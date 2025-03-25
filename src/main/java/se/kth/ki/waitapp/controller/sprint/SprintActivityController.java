package se.kth.ki.waitapp.controller.sprint;

import org.eclipse.microprofile.openapi.annotations.security.SecurityRequirement;

import io.quarkus.security.Authenticated;
import io.smallrye.mutiny.Uni;
import jakarta.inject.Inject;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import se.kth.ki.waitapp.controller.GenericController;
import se.kth.ki.waitapp.core.interfaces.service.ISprintActivityService;
import se.kth.ki.waitapp.dto.sprint.SprintActivityDTO;

@Path("sprintActivity")
@SecurityRequirement(name = "SecurityScheme")
@Authenticated
public class SprintActivityController extends GenericController<SprintActivityDTO, ISprintActivityService> {

    @Inject
    public SprintActivityController(ISprintActivityService service) {
        super(service);
    }

    @PUT
    @Path("/done/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Authenticated
    public Uni<Response> markCompleted(@PathParam("id") Long id, @QueryParam("value") Boolean value) {
        return service.markCompleted(id, value != null ? value : true).map(ok -> ok ? Response.status(Response.Status.OK).build() : Response.status(Response.Status.BAD_REQUEST).build());
    }
    
}
