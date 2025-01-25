package se.kth.ki.waitapp.controller;

import jakarta.inject.Inject;
import jakarta.ws.rs.Path;
import se.kth.ki.waitapp.core.interfaces.IUserService;
import se.kth.ki.waitapp.dto.user.UserDTO;

@Path("user")
public class UserController extends GenericController<UserDTO, IUserService> {

    @Inject
    public UserController(IUserService service) {
        super(service);
    }

}
