package se.kth.ki.waitapp.dto.metrics;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.validation.constraints.NotNull;
import se.kth.ki.waitapp.dto.IOwnableDTO;

public interface IGenericMetricDTO<T> extends IOwnableDTO {
    Long getId();

    void setId(Long id);

    UUID getOwner();

    Long getUserID();

    void setUserID(Long userID);

    @NotNull
    Long getSprintID();

    void setSprintID(Long sprintID);

    @NotNull
    LocalDateTime getTimestamp();

    void setTimestamp(LocalDateTime dateTime);

    T getValue();

    void setValue(T value);
}