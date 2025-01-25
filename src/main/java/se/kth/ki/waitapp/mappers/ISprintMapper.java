package se.kth.ki.waitapp.mappers;

import org.mapstruct.Mapper;

import se.kth.ki.waitapp.core.model.sprint.Sprint;
import se.kth.ki.waitapp.dto.sprint.SprintDTO;

@Mapper(componentModel = "cdi")
public interface ISprintMapper extends IGenericMapper<Sprint, SprintDTO> {
}
