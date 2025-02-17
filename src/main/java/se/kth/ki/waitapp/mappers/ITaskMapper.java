package se.kth.ki.waitapp.mappers;

import org.mapstruct.Mapper;

import jakarta.enterprise.context.ApplicationScoped;
import se.kth.ki.waitapp.core.model.sprint.Task;
import se.kth.ki.waitapp.dto.sprint.TaskDTO;

@Mapper(componentModel = "cdi")
@ApplicationScoped
public interface ITaskMapper extends IGenericMapper<Task, TaskDTO> {
}
