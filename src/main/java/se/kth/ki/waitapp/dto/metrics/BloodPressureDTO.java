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
@AllArgsConstructor
@NoArgsConstructor
public class BloodPressureDTO implements IGenericMetricDTO<String> {
    private Long id;
    private UUID owner;
    @NotNull
    private Long userID;
    @NotNull
    private Long sprintID;
    @NotNull
    private LocalDateTime timestamp;
    private String value;
}
