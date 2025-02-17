package se.kth.ki.waitapp.core.service;

import io.quarkus.security.identity.SecurityIdentity;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import se.kth.ki.waitapp.core.interfaces.repository.ITaskRepository;
import se.kth.ki.waitapp.core.interfaces.service.ITaskService;
import se.kth.ki.waitapp.core.model.sprint.Task;
import se.kth.ki.waitapp.dto.sprint.TaskDTO;
import se.kth.ki.waitapp.mappers.ITaskMapper;

@ApplicationScoped
public class TaskService extends GenericService<Task, TaskDTO> implements ITaskService {

    @Inject
    public TaskService(ITaskMapper mapper, ITaskRepository repository, SecurityIdentity identity) {
        super(mapper, repository, identity);
    }
}
