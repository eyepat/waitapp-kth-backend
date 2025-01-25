package se.kth.ki.waitapp.core.model.metrics;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import se.kth.ki.waitapp.core.model.BaseModel;
import se.kth.ki.waitapp.core.model.sprint.Sprint;
import se.kth.ki.waitapp.core.model.user.User;

@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class GenericMetric<T> extends BaseModel {
    @Column(name = "userID", nullable = false)
    private Long userID;

    @Column(name = "sprintID", nullable = true)
    private Long sprintID;

    @Column(name = "timestamp", nullable = false, updatable = false)
    private LocalDateTime timeStamp;

    @Column(name = "value", nullable = false)
    private T value;

    @ManyToOne
    @JoinColumn(name = "userID", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "sprintID", referencedColumnName = "id", insertable = false, updatable = false, nullable = true)
    private Sprint sprint;
}
