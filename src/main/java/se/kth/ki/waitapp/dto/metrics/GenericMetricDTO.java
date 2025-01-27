package se.kth.ki.waitapp.dto.metrics;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import se.kth.ki.waitapp.dto.BaseDTO;
import se.kth.ki.waitapp.dto.IBaseDTO;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public abstract class GenericMetricDTO<T> implements IBaseDTO {
    private Long id;
    private UUID owner;
    @NotNull
    private Long userID;
    @NotNull
    private Long sprintID;
    @NotNull
    private LocalDateTime timestamp;
    private T value;
}