package se.kth.ki.waitapp.core.model.sprint;

import java.time.LocalDate;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.PrePersist;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import se.kth.ki.waitapp.core.model.BaseModel;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Sprint extends BaseModel {

    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private SprintType sprintType;

    @Column(length = 11)
    private LocalDate startDate;

    @Column(length = 11)
    private LocalDate endDate;

    @Column(nullable = false)
    private Boolean completed;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Level level;

    @Column(name = "score")
    private Float score;

    @Column(name = "userID")
    private Long userID;

    @PrePersist
    protected void onCreate() {
        if (startDate == null) {
            startDate = LocalDate.now();
        }
    }
}
