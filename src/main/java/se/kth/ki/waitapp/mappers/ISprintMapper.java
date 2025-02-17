package se.kth.ki.waitapp.mappers;

import jakarta.enterprise.context.ApplicationScoped;
import org.mapstruct.Mapper;

import se.kth.ki.waitapp.core.model.sprint.Sprint;
import se.kth.ki.waitapp.dto.sprint.SprintCreateDTO;
import se.kth.ki.waitapp.dto.sprint.SprintDTO;

@Mapper(componentModel = "cdi")
@ApplicationScoped
public interface ISprintMapper extends IGenericMapper<Sprint, SprintDTO> {
    Sprint fromCreateDTO(SprintCreateDTO createDTO);

    SprintCreateDTO toSprintCreateDTO(Sprint entity);
}
