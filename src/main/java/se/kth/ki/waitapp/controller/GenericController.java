package se.kth.ki.waitapp.controller;

import java.util.List;

import org.eclipse.microprofile.jwt.JsonWebToken;
import org.eclipse.microprofile.openapi.annotations.enums.SecuritySchemeType;
import org.eclipse.microprofile.openapi.annotations.security.OAuthFlow;
import org.eclipse.microprofile.openapi.annotations.security.OAuthFlows;
import org.eclipse.microprofile.openapi.annotations.security.OAuthScope;
import org.eclipse.microprofile.openapi.annotations.security.SecurityRequirement;
import org.eclipse.microprofile.openapi.annotations.security.SecurityScheme;
import org.eclipse.microprofile.openapi.annotations.security.SecuritySchemes;

import io.quarkus.security.Authenticated;
import io.quarkus.security.identity.SecurityIdentity;
import io.smallrye.mutiny.Uni;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import se.kth.ki.waitapp.core.interfaces.service.IGenericService;
import se.kth.ki.waitapp.dto.BaseDTO;

@SecuritySchemes(value = {
        @SecurityScheme(securitySchemeName = "KeycloakOAuth2", type = SecuritySchemeType.OAUTH2, scheme = "Bearer", bearerFormat = "JWT", flows = @OAuthFlows(authorizationCode = @OAuthFlow(authorizationUrl = "http://localhost:9090/realms/waitapp/protocol/openid-connect/auth", tokenUrl = "http://localhost:9090/realms/waitapp/protocol/openid-connect/token", scopes = @OAuthScope(name = "openid", description = "OpenID Connect scope"))))
})
@SecurityRequirement(name = "KeycloakOAuth2")
@SecurityRequirement(name = "OAuth2")
@Authenticated
public abstract class GenericController<TDTO extends BaseDTO, TSERVICE extends IGenericService<?, TDTO>> {
    protected TSERVICE service;

    @Inject
    SecurityIdentity identity;

    @Inject
    JsonWebToken jwt;

    public GenericController(TSERVICE service) {
        this.service = service;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Authenticated
    public Uni<List<TDTO>> getAll() {
        return service.findAll();
    }

    @GET
    @Path("/byId/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Authenticated
    public Uni<Response> getById(@PathParam("id") Long id) {
        return service.findById(id)
                .map(dto -> dto != null ? Response.ok(dto).build()
                        : Response.status(Response.Status.NOT_FOUND).build());
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Authenticated
    public Uni<Response> create(@Valid TDTO dto) {
        return service.create(dto)
                .map(created -> Response.status(Response.Status.CREATED).entity(created).build());
    }

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

    @DELETE
    @Path("/{id}")
    @Authenticated
    public Uni<Response> delete(@PathParam("id") Long id) {
        return service.delete(id)
                .map(deleted -> deleted ? Response.noContent().build()
                        : Response.status(Response.Status.NOT_FOUND).build());
    }
}
