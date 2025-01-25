package se.kth.ki.waitapp.dto.sprint;

import java.time.LocalDate;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import se.kth.ki.waitapp.core.model.sprint.Level;
import se.kth.ki.waitapp.core.model.sprint.SprintType;
import se.kth.ki.waitapp.dto.BaseDTO;

@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class SprintDTO extends BaseDTO {
    @NotNull
    private SprintType sprintType;
    private LocalDate startDate;
    private LocalDate endDate;
    private Boolean completed;
    private Level level;
    private Float score;
    @NotNull
    private Long userID;
}
