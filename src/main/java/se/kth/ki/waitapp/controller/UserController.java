package se.kth.ki.waitapp.controller;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;
import org.eclipse.microprofile.openapi.annotations.security.SecurityRequirement;

import io.quarkus.security.Authenticated;
import io.smallrye.mutiny.Uni;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import se.kth.ki.waitapp.core.interfaces.service.IUserService;
import se.kth.ki.waitapp.dto.user.OnboardingDTO;
import se.kth.ki.waitapp.dto.user.UserDTO;
import se.kth.ki.waitapp.provider.errors.ErrorResponse;

@Path("user")
@SecurityRequirement(name = "SecurityScheme")
@Authenticated
public class UserController extends GenericController<UserDTO, IUserService> {

        @Inject
        public UserController(IUserService service) {
                super(service);
        }

        @APIResponses({
                        @APIResponse(responseCode = "201", description = "Successful", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = UserDTO.class))),
                        @APIResponse(responseCode = "400", description = "Invalid request, bad parameters", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = ErrorResponse.class))),
                        @APIResponse(responseCode = "401", description = "Unauthorized", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = ErrorResponse.class))),
                        @APIResponse(responseCode = "403", description = "Forbidden", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = ErrorResponse.class))),
                        @APIResponse(responseCode = "404", description = "Resource not found", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = ErrorResponse.class))),
                        @APIResponse(responseCode = "500", description = "Internal server error", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = ErrorResponse.class)))
        })
        @POST
        @Path("onboarding")
        @Consumes(MediaType.APPLICATION_JSON)
        @Produces(MediaType.APPLICATION_JSON)
        @Operation(summary = "Onboard a new user", description = "Creates a new user onboarding process")
        public Uni<Response> onboardUser(
                        @Valid @RequestBody(description = "User onboarding details", required = true) OnboardingDTO dto) {
                return service.onboard(dto)
                                .map(created -> Response.status(Response.Status.CREATED).entity(created).build());
        }

        @APIResponses({
                        @APIResponse(responseCode = "200", description = "The user associated with you", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = UserDTO.class))),
                        @APIResponse(responseCode = "400", description = "Invalid request, bad parameters", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = ErrorResponse.class))),
                        @APIResponse(responseCode = "401", description = "Unauthorized", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = ErrorResponse.class))),
                        @APIResponse(responseCode = "403", description = "Forbidden", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = ErrorResponse.class))),
                        @APIResponse(responseCode = "404", description = "Resource not found", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = ErrorResponse.class))),
                        @APIResponse(responseCode = "500", description = "Internal server error", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = ErrorResponse.class)))
        })
        @GET
        @Path("self")
        @Consumes(MediaType.APPLICATION_JSON)
        @Produces(MediaType.APPLICATION_JSON)
        @Operation(summary = "Get self", description = "Get the user associated with you")
        public Uni<Response> self() {
                return service.self()
                                .map(self -> Response.status(Response.Status.OK).entity(self).build());
        }

        @APIResponses({
                        @APIResponse(responseCode = "201", description = "Successful", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = UserDTO.class))),
                        @APIResponse(responseCode = "400", description = "Invalid request, bad parameters", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = ErrorResponse.class))),
                        @APIResponse(responseCode = "401", description = "Unauthorized", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = ErrorResponse.class))),
                        @APIResponse(responseCode = "403", description = "Forbidden", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = ErrorResponse.class))),
                        @APIResponse(responseCode = "404", description = "Resource not found", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = ErrorResponse.class))),
                        @APIResponse(responseCode = "500", description = "Internal server error", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = ErrorResponse.class)))
        })
        @RolesAllowed({ "admin" })
        @Override
        public Uni<Response> create(UserDTO dto) {
                return super.create(dto);
        }

}
