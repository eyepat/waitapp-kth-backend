package se.kth.ki.waitapp.core.interfaces;

import io.smallrye.mutiny.Uni;
import se.kth.ki.waitapp.core.model.user.User;
import se.kth.ki.waitapp.dto.user.OnboardingDTO;
import se.kth.ki.waitapp.dto.user.UserDTO;

public interface IUserService extends IGenericService<User, UserDTO> {
    Uni<UserDTO> onboard(OnboardingDTO dto);
}
