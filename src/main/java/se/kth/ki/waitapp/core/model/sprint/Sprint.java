package se.kth.ki.waitapp.core.model.sprint;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import se.kth.ki.waitapp.core.model.BaseModel;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Sprint extends BaseModel {
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
}
