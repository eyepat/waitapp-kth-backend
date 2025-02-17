package se.kth.ki.waitapp.controller.sprint;

import org.eclipse.microprofile.openapi.annotations.security.SecurityRequirement;

import io.quarkus.security.Authenticated;
import jakarta.inject.Inject;
import jakarta.ws.rs.Path;
import se.kth.ki.waitapp.controller.GenericController;
import se.kth.ki.waitapp.core.interfaces.service.ITaskService;
import se.kth.ki.waitapp.dto.sprint.TaskDTO;

@Path("task")
@SecurityRequirement(name = "SecurityScheme")
@Authenticated
public class TaskController extends GenericController<TaskDTO, ITaskService> {

    @Inject
    public TaskController(ITaskService service) {
        super(service);
    }
}
