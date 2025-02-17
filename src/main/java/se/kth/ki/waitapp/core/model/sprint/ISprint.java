package se.kth.ki.waitapp.core.model.sprint;

import java.time.LocalDate;

import se.kth.ki.waitapp.core.model.IBaseModel;

public interface ISprint extends IBaseModel {
    SprintType getSprintType();

    void setSprintType(SprintType sprintType);

    Level getLevel();

    void setLevel(Level level);

    LocalDate getStartDate();

    void setStartDate(LocalDate startDate);

    LocalDate getEndDate();

    void setEndDate(LocalDate endDate);
}
