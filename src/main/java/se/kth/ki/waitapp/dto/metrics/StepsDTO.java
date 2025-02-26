package se.kth.ki.waitapp.dto.metrics;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StepsDTO implements IGenericMetricDTO<Integer> {
    private Long id;
    private UUID owner;
    @NotNull
    private Long userID;
    @NotNull
    private Long sprintID;
    @NotNull
    private LocalDateTime timestamp;
    private Integer value;
}
