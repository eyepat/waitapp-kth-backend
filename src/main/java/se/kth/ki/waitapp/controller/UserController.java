package se.kth.ki.waitapp.controller;

import org.eclipse.microprofile.openapi.annotations.enums.SecuritySchemeType;
import org.eclipse.microprofile.openapi.annotations.security.OAuthFlow;
import org.eclipse.microprofile.openapi.annotations.security.OAuthFlows;
import org.eclipse.microprofile.openapi.annotations.security.OAuthScope;
import org.eclipse.microprofile.openapi.annotations.security.SecurityRequirement;
import org.eclipse.microprofile.openapi.annotations.security.SecurityScheme;
import org.eclipse.microprofile.openapi.annotations.security.SecuritySchemes;

import io.quarkus.security.Authenticated;
import jakarta.inject.Inject;
import jakarta.ws.rs.Path;
import se.kth.ki.waitapp.core.interfaces.IUserService;
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

}
