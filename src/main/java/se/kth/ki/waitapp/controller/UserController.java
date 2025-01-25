package se.kth.ki.waitapp.controller;

import org.eclipse.microprofile.openapi.annotations.security.SecurityRequirement;

import io.quarkus.security.Authenticated;
import jakarta.inject.Inject;
import jakarta.ws.rs.Path;
import se.kth.ki.waitapp.core.interfaces.IUserService;
import se.kth.ki.waitapp.dto.user.UserDTO;

@Path("user")
@SecurityRequirement(name = "KeycloakOAuth2")
@Authenticated
public class UserController extends GenericController<UserDTO, IUserService> {

    @Inject
    public UserController(IUserService service) {
        super(service);
    }

}
