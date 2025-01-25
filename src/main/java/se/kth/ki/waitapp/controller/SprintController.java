package se.kth.ki.waitapp.controller;

import jakarta.inject.Inject;
import jakarta.ws.rs.Path;
import se.kth.ki.waitapp.core.interfaces.ISprintService;
import se.kth.ki.waitapp.dto.sprint.SprintDTO;

@Path("sprint")
public class SprintController extends GenericController<SprintDTO, ISprintService> {

    @Inject
    public SprintController(ISprintService service) {
        super(service);
    }

}
