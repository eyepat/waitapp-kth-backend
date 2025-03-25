package se.kth.ki.waitapp.core.interfaces.service;

import java.util.List;
import java.util.UUID;

import io.smallrye.mutiny.Uni;
import se.kth.ki.waitapp.core.model.sprint.Level;
import se.kth.ki.waitapp.core.model.sprint.SprintActivity;
import se.kth.ki.waitapp.core.model.sprint.SprintType;
import se.kth.ki.waitapp.dto.sprint.SprintActivityDTO;

public interface ISprintActivityService extends IGenericService<SprintActivity, SprintActivityDTO> {
    Uni<List<SprintActivity>> getSprintActivitiesForUser(UUID userID, Level sprintLevel, SprintType sprintType,
            int amount);

    Uni<Boolean> markCompleted(Long id, Boolean value);
}
