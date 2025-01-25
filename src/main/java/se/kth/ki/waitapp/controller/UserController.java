package se.kth.ki.waitapp.controller;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.enums.SecuritySchemeType;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.openapi.annotations.security.OAuthFlow;
import org.eclipse.microprofile.openapi.annotations.security.OAuthFlows;
import org.eclipse.microprofile.openapi.annotations.security.OAuthScope;
import org.eclipse.microprofile.openapi.annotations.security.SecurityRequirement;
import org.eclipse.microprofile.openapi.annotations.security.SecurityScheme;
import org.eclipse.microprofile.openapi.annotations.security.SecuritySchemes;

import io.quarkus.security.Authenticated;
import io.smallrye.mutiny.Uni;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import se.kth.ki.waitapp.core.interfaces.IUserService;
import se.kth.ki.waitapp.dto.user.OnboardingDTO;
import se.kth.ki.waitapp.dto.user.RegisterDTO;
import se.kth.ki.waitapp.dto.user.UserDTO;

@Path("user")
@SecuritySchemes(value = {
        @SecurityScheme(securitySchemeName = "KeycloakOAuth2", type = SecuritySchemeType.OAUTH2, scheme = "Bearer", bearerFormat = "JWT", flows = @OAuthFlows(authorizationCode = @OAuthFlow(authorizationUrl = "http://localhost:9090/realms/waitapp/protocol/openid-connect/auth", tokenUrl = "http://localhost:9090/realms/waitapp/protocol/openid-connect/token", scopes = @OAuthScope(name = "openid", description = "OpenID Connect scope"))))
})
@SecurityRequirement(name = "KeycloakOAuth2")
@SecurityRequirement(name = "OAuth2")
@Authenticated
public class UserController extends GenericController<UserDTO, IUserService> {

    @Inject
    public UserController(IUserService service) {
        super(service);
    }

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

}
