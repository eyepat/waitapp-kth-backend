package se.kth.ki.waitapp.mappers;

import org.mapstruct.Mapper;

import jakarta.enterprise.context.ApplicationScoped;
import se.kth.ki.waitapp.core.model.sprint.SprintActivity;
import se.kth.ki.waitapp.dto.sprint.SprintActivityDTO;

@Mapper(componentModel = "cdi")
@ApplicationScoped
public interface ISprintActivityMapper extends IGenericMapper<SprintActivity, SprintActivityDTO> {
}
