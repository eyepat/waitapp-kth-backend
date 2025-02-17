package se.kth.ki.waitapp.dto.sprint;

import java.time.LocalDate;

import se.kth.ki.waitapp.core.model.sprint.Level;
import se.kth.ki.waitapp.core.model.sprint.SprintType;
import se.kth.ki.waitapp.dto.IOwnableDTO;

public interface ISprintDTO extends IOwnableDTO {
    SprintType getSprintType();

    void setSprintType(SprintType sprintType);

    Level getLevel();

    void setLevel(Level level);

    LocalDate getStartDate();

    void setStartDate(LocalDate startDate);

    LocalDate getEndDate();

    void setEndDate(LocalDate endDate);
}
