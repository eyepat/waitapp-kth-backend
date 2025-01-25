package se.kth.ki.waitapp.core.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import se.kth.ki.waitapp.core.interfaces.IUserService;
import se.kth.ki.waitapp.core.model.user.User;
import se.kth.ki.waitapp.dto.user.UserDTO;
import se.kth.ki.waitapp.mappers.IUserMapper;

@ApplicationScoped
public class UserService extends GenericService<User, UserDTO> implements IUserService {

    @Inject
    public UserService(IUserMapper mapper) {
        super(mapper);
    }

}
