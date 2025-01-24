package se.kth.ki.waitapp.core.model.metrics;

import java.time.LocalDateTime;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import se.kth.ki.waitapp.core.model.sprint.Sprint;
import se.kth.ki.waitapp.core.model.user.User;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class GenericMetric<T> extends PanacheEntity {
    @Id
    @Column(name = "userID", nullable = false)
    private Long userID;

    @Column(name = "sprintID", nullable = true)
    private Long sprintID;

    @Id
    @Column(name = "timeStamp", nullable = false, updatable = false)
    private LocalDateTime timeStamp;

    @Column(name = "value", nullable = false)
    private T value;

    @ManyToOne
    @JoinColumn(name = "userID", referencedColumnName = "ID", nullable = false, insertable = false, updatable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "sprintID", referencedColumnName = "ID", insertable = false, updatable = false, nullable = true)
    private Sprint sprint;
}
