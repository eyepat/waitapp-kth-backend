package se.kth.ki.waitapp.controller.sprint;

import org.eclipse.microprofile.openapi.annotations.parameters.Parameter;
import org.eclipse.microprofile.openapi.annotations.security.SecurityRequirement;

import io.quarkus.security.Authenticated;
import io.smallrye.mutiny.Uni;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import se.kth.ki.waitapp.controller.GenericController;
import se.kth.ki.waitapp.core.interfaces.service.ISprintService;
import se.kth.ki.waitapp.dto.sprint.SprintDTO;

@Path("sprint")
@SecurityRequirement(name = "SecurityScheme")
@Authenticated
public class SprintController extends GenericController<SprintDTO, ISprintService> {

    @Inject
    public SprintController(ISprintService service) {
        super(service);
    }

    @GET
    @Path("/latest")
    @Produces(MediaType.APPLICATION_JSON)
    @Authenticated
    public Uni<Response> latest(
            @Parameter(required = false, description = "filter by active") @QueryParam("active") Boolean active) {
        if (active != null && active) {
            return service.latestActive()
                    .map(dto -> dto != null ? Response.ok(dto).build()
                            : Response.status(Response.Status.NOT_FOUND).build());
        }
        return service.latest()
                .map(dto -> dto != null ? Response.ok(dto).build()
                        : Response.status(Response.Status.NOT_FOUND).build());

    }

    @PUT
    @Path("/stop/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Authenticated
    public Uni<Response> stop(@PathParam("id") Long id) {
        return service.stop(id).map(ok -> ok ? Response.status(Response.Status.OK).build() : Response.status(Response.Status.BAD_REQUEST).build());
    }
}
