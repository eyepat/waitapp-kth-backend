package se.kth.ki.waitapp.controller;

import java.util.Optional;

import org.eclipse.microprofile.jwt.JsonWebToken;
import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;
import org.eclipse.microprofile.openapi.annotations.security.SecurityRequirement;

import io.quarkus.security.Authenticated;
import io.quarkus.security.identity.SecurityIdentity;
import io.smallrye.mutiny.Uni;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import se.kth.ki.waitapp.core.interfaces.service.IGenericService;
import se.kth.ki.waitapp.dto.IBaseDTO;
import se.kth.ki.waitapp.provider.errors.ErrorResponse;

@SecurityRequirement(name = "SecurityScheme")
@Authenticated
public abstract class GenericController<TDTO extends IBaseDTO, TSERVICE extends IGenericService<?, TDTO>> {
        protected TSERVICE service;
        protected Class<TDTO> resourceClass;

        @Inject
        SecurityIdentity identity;

        @Inject
        JsonWebToken jwt;

        public GenericController(TSERVICE service) {
                this.service = service;
        }

        @APIResponses({
                        @APIResponse(responseCode = "200", description = "Successfully returns all the resources requested", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = IBaseDTO.class, type = SchemaType.ARRAY))),
                        @APIResponse(responseCode = "400", description = "Invalid request, bad parameters", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = ErrorResponse.class))),
                        @APIResponse(responseCode = "401", description = "Unauthorized", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = ErrorResponse.class))),
                        @APIResponse(responseCode = "403", description = "Forbidden", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = ErrorResponse.class))),
                        @APIResponse(responseCode = "404", description = "Resource not found", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = ErrorResponse.class))),
                        @APIResponse(responseCode = "500", description = "Internal server error", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = ErrorResponse.class)))
        })
        @GET
        @Produces(MediaType.APPLICATION_JSON)
        @Authenticated
        public Uni<Response> getAll() {
                return service.findAll().map(dto -> dto != null ? Response.ok(dto).build()
                                : Response.status(Response.Status.NOT_FOUND).build());
        }

        @APIResponses({
                        @APIResponse(responseCode = "200", description = "Successfully returns paginated resources", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = IBaseDTO.class, type = SchemaType.ARRAY))),
                        @APIResponse(responseCode = "400", description = "Invalid request, bad parameters", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = ErrorResponse.class))),
                        @APIResponse(responseCode = "401", description = "Unauthorized", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = ErrorResponse.class))),
                        @APIResponse(responseCode = "403", description = "Forbidden", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = ErrorResponse.class))),
                        @APIResponse(responseCode = "404", description = "Resource not found", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = ErrorResponse.class))),
                        @APIResponse(responseCode = "500", description = "Internal server error", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = ErrorResponse.class)))
        })
        @GET
        @Path("/paginated")
        @Produces(MediaType.APPLICATION_JSON)
        @Authenticated
        public Uni<Response> getPaginated(
                        @QueryParam("page") @DefaultValue("0") int page,
                        @QueryParam("size") @DefaultValue("10") int size,
                        @QueryParam("search") Optional<String> searchQuery) {

                return service.findPaginated(page, size, searchQuery)
                                .map(dtoList -> Response.ok(dtoList).build());
        }

        @APIResponses({
                        @APIResponse(responseCode = "200", description = "Successfully returns the resource by the given id", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = IBaseDTO.class))),
                        @APIResponse(responseCode = "400", description = "Invalid request, bad parameters", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = ErrorResponse.class))),
                        @APIResponse(responseCode = "401", description = "Unauthorized", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = ErrorResponse.class))),
                        @APIResponse(responseCode = "403", description = "Forbidden", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = ErrorResponse.class))),
                        @APIResponse(responseCode = "404", description = "Resource not found", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = ErrorResponse.class))),
                        @APIResponse(responseCode = "500", description = "Internal server error", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = ErrorResponse.class)))
        })
        @GET
        @Path("/byId/{id}")
        @Produces(MediaType.APPLICATION_JSON)
        @Authenticated
        public Uni<Response> getById(@PathParam("id") Long id) {
                return service.findById(id)
                                .map(dto -> dto != null ? Response.ok(dto).build()
                                                : Response.status(Response.Status.NOT_FOUND).build());
        }

        @APIResponses({
                        @APIResponse(responseCode = "201", description = "Successfully created", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = IBaseDTO.class))),
                        @APIResponse(responseCode = "400", description = "Invalid request, bad parameters", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = ErrorResponse.class))),
                        @APIResponse(responseCode = "401", description = "Unauthorized", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = ErrorResponse.class))),
                        @APIResponse(responseCode = "403", description = "Forbidden", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = ErrorResponse.class))),
                        @APIResponse(responseCode = "404", description = "Resource not found", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = ErrorResponse.class))),
                        @APIResponse(responseCode = "500", description = "Internal server error", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = ErrorResponse.class)))
        })
        @POST
        @Consumes(MediaType.APPLICATION_JSON)
        @Produces(MediaType.APPLICATION_JSON)
        @Authenticated
        public Uni<Response> create(@Valid TDTO dto) {
                return service.create(dto)
                                .map(created -> Response.status(Response.Status.CREATED).entity(created).build());
        }

        @APIResponses({
                        @APIResponse(responseCode = "200", description = "Successfully updated resource with given id", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = IBaseDTO.class))),
                        @APIResponse(responseCode = "400", description = "Invalid request, bad parameters", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = ErrorResponse.class))),
                        @APIResponse(responseCode = "401", description = "Unauthorized", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = ErrorResponse.class))),
                        @APIResponse(responseCode = "403", description = "Forbidden", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = ErrorResponse.class))),
                        @APIResponse(responseCode = "404", description = "Resource not found", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = ErrorResponse.class))),
                        @APIResponse(responseCode = "500", description = "Internal server error", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = ErrorResponse.class)))
        })
        @PUT
        @Path("/{id}")
        @Consumes(MediaType.APPLICATION_JSON)
        @Produces(MediaType.APPLICATION_JSON)
        @Authenticated
        public Uni<Response> update(@PathParam("id") Long id, @Valid TDTO dto) {
                return service.update(id, dto)
                                .map(updated -> updated != null ? Response.ok(updated).build()
                                                : Response.status(Response.Status.NOT_FOUND).build());
        }

        @APIResponses({
                        @APIResponse(responseCode = "204", description = "Successfully deleted resource with given id"),
                        @APIResponse(responseCode = "400", description = "Invalid request, bad parameters", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = ErrorResponse.class))),
                        @APIResponse(responseCode = "401", description = "Unauthorized", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = ErrorResponse.class))),
                        @APIResponse(responseCode = "403", description = "Forbidden", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = ErrorResponse.class))),
                        @APIResponse(responseCode = "404", description = "Resource not found", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = ErrorResponse.class))),
                        @APIResponse(responseCode = "500", description = "Internal server error", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = ErrorResponse.class)))
        })
        @DELETE
        @Path("/{id}")
        @Authenticated
        public Uni<Response> delete(@PathParam("id") Long id) {
                return service.delete(id)
                                .map(deleted -> deleted ? Response.noContent().build()
                                                : Response.status(Response.Status.NOT_FOUND).build());
        }
}
