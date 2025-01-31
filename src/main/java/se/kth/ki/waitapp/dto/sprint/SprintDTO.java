package se.kth.ki.waitapp.dto.sprint;

import java.time.LocalDate;
import java.util.UUID;

import jakarta.validation.constraints.NotNull;
import lombok.*;
import se.kth.ki.waitapp.core.model.sprint.Level;
import se.kth.ki.waitapp.core.model.sprint.SprintType;
import se.kth.ki.waitapp.dto.IBaseDTO;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SprintDTO implements IBaseDTO {
    private Long id;
    private UUID owner;
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
