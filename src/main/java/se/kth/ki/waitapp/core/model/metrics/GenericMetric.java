package se.kth.ki.waitapp.core.model.metrics;

import java.time.LocalDateTime;
import java.util.UUID;

import io.quarkus.hibernate.reactive.panache.PanacheEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import se.kth.ki.waitapp.core.model.sprint.Sprint;
import se.kth.ki.waitapp.core.model.user.User;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public abstract class GenericMetric<T> extends PanacheEntity implements IGenericMetric<T> {

    private Long id;

    @Column(name = "owner", nullable = false)
    private UUID owner;

    @Column(name = "userID", nullable = false)
    private Long userID;

    @Column(name = "sprintID", nullable = true)
    private Long sprintID;

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
