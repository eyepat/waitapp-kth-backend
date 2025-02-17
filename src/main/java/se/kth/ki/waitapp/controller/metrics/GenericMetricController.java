package se.kth.ki.waitapp.controller.metrics;

import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;

import io.quarkus.security.Authenticated;
import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import se.kth.ki.waitapp.controller.GenericController;
import se.kth.ki.waitapp.core.interfaces.service.IGenericMetricService;
import se.kth.ki.waitapp.dto.IBaseDTO;
import se.kth.ki.waitapp.dto.IOwnableDTO;
import se.kth.ki.waitapp.provider.errors.ErrorResponse;

public abstract class GenericMetricController<TDTO extends IOwnableDTO, TSERVICE extends IGenericMetricService<?, TDTO>>
                extends GenericController<TDTO, TSERVICE> {

        public GenericMetricController(TSERVICE service) {
                super(service);
        }

        @APIResponses({
                        @APIResponse(responseCode = "200", description = "Successfully returns the latest resource by the given id", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = IBaseDTO.class))),
                        @APIResponse(responseCode = "400", description = "Invalid request, bad parameters", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = ErrorResponse.class))),
                        @APIResponse(responseCode = "401", description = "Unauthorized", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = ErrorResponse.class))),
                        @APIResponse(responseCode = "403", description = "Forbidden", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = ErrorResponse.class))),
                        @APIResponse(responseCode = "404", description = "Resource not found", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = ErrorResponse.class))),
                        @APIResponse(responseCode = "500", description = "Internal server error", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = ErrorResponse.class)))
        })
        @GET
        @Path("/latest")
        @Produces(MediaType.APPLICATION_JSON)
        @Authenticated
        public Uni<Response> latest() {
                return service.latest()
                                .map(dto -> dto != null ? Response.ok(dto).build()
                                                : Response.status(Response.Status.NOT_FOUND).build());

        }

}
