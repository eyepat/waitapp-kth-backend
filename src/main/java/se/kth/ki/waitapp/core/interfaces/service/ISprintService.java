package se.kth.ki.waitapp.core.interfaces.service;

import java.util.Optional;

import io.smallrye.mutiny.Uni;
import se.kth.ki.waitapp.core.model.sprint.Sprint;
import se.kth.ki.waitapp.dto.sprint.SprintDTO;

public interface ISprintService extends IGenericService<Sprint, SprintDTO> {
    Uni<Optional<SprintDTO>> latest();

    Uni<Optional<SprintDTO>> latestActive();

    Uni<Boolean> stop(Long id);
}
