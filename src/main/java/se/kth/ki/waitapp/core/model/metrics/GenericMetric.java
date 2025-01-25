package se.kth.ki.waitapp.core.model.metrics;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import se.kth.ki.waitapp.core.model.BaseModel;
import se.kth.ki.waitapp.core.model.sprint.Sprint;
import se.kth.ki.waitapp.core.model.user.User;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public abstract class GenericMetric<T> extends BaseModel {
    @Column(name = "userID", nullable = false)
    private UUID userID;

    @Column(name = "sprintID", nullable = true)
    private UUID sprintID;

    @Column(name = "timestamp", nullable = false, updatable = false)
    private LocalDateTime timestamp;

    @Column(name = "value", nullable = false)
    private T value;

    @ManyToOne
    @JoinColumn(name = "userID", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "sprintID", referencedColumnName = "id", insertable = false, updatable = false, nullable = true)
    private Sprint sprint;

    @PrePersist
    protected void onCreate() {
        if (timestamp == null) {
            timestamp = LocalDateTime.now();
        }
    }
}
