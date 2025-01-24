package se.kth.ki.waitapp.dto.sprint;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import se.kth.ki.waitapp.core.model.sprint.Level;
import se.kth.ki.waitapp.core.model.sprint.SprintType;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SprintDTO {
    private long sprintID;
    private SprintType sprintType;
    private LocalDate startDate;
    private LocalDate endDate;
    private boolean completed;
    private Level level;
    private Float score;
    private long userID;
}
