package se.kth.ki.waitapp.core.model.sprint;

import java.time.LocalDate;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Sprint extends PanacheEntity {
    @Id
    @Column(name = "sprintID", nullable = false)
    private long sprintID;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private SprintType sprintType;

    @Column(length = 11)
    private LocalDate startDate;

    @Column(length = 11)
    private LocalDate endDate;

    @Column(nullable = false)
    private boolean completed;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Level level;

    @Column(name = "score")
    private Float score;

    @Column(name = "userID")
    private long userID;
}
