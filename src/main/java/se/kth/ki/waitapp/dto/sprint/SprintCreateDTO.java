package se.kth.ki.waitapp.dto.sprint;

import java.time.LocalDate;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.validation.constraints.NotNull;
import lombok.*;
import se.kth.ki.waitapp.core.model.sprint.Level;
import se.kth.ki.waitapp.core.model.sprint.SprintType;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SprintCreateDTO implements ISprintDTO {
    @JsonIgnore
    private Long id;
    @JsonIgnore
    private UUID owner;
    @NotNull
    private SprintType sprintType;
    @NotNull
    private LocalDate startDate;
    private LocalDate endDate;
    @NotNull
    private Level level;
    @NotNull
    private Long userID;
}
