package se.kth.ki.waitapp.core.model.metrics;

import java.time.LocalDateTime;

import se.kth.ki.waitapp.core.model.IOwnableModel;

public interface IGenericMetric<T> extends IOwnableModel {
    T getValue();

    void setValue(T value);

    Long getUserID();

    void setUserID(Long userID);

    Long getSprintID();

    void setSprintID(Long sprintID);

    LocalDateTime getTimestamp();

    void setTimestamp(LocalDateTime dateTime);
}
