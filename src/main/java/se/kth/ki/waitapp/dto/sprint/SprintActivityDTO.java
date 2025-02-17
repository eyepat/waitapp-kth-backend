package se.kth.ki.waitapp.dto.sprint;

import java.time.LocalDate;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import se.kth.ki.waitapp.dto.IOwnableDTO;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SprintActivityDTO implements IOwnableDTO {
    private Long id;
    private UUID owner;
    private TaskDTO task;
    private Boolean completed;
    private LocalDate assignedDate;
}
