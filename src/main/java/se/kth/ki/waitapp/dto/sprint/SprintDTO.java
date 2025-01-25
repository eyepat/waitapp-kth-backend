package se.kth.ki.waitapp.dto.sprint;

import java.time.LocalDate;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import se.kth.ki.waitapp.core.model.sprint.Level;
import se.kth.ki.waitapp.core.model.sprint.SprintType;
import se.kth.ki.waitapp.dto.BaseDTO;

@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SprintDTO extends BaseDTO {
    private SprintType sprintType;
    private LocalDate startDate;
    private LocalDate endDate;
    private Boolean completed;
    private Level level;
    private Float score;
    private UUID userID;
}
