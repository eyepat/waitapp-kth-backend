package se.kth.ki.waitapp.dto.sprint;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import se.kth.ki.waitapp.core.model.sprint.Level;
import se.kth.ki.waitapp.core.model.sprint.SprintType;
import se.kth.ki.waitapp.core.model.sprint.TaskVariant;
import se.kth.ki.waitapp.dto.IBaseDTO;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TaskDTO implements IBaseDTO {
    private Long id;
    @NotNull
    private SprintType type;
    private Level level;
    private TaskVariant variant;
    private String title;
    private String description;
    private String videoURL;
    private Boolean active;
}
