package se.kth.ki.waitapp.mappers;

import org.mapstruct.Mapper;

import se.kth.ki.waitapp.core.model.user.User;
import se.kth.ki.waitapp.dto.user.UserDTO;

@Mapper(componentModel = "cdi")
public interface IUserMapper extends IGenericMapper<User, UserDTO> {
}
