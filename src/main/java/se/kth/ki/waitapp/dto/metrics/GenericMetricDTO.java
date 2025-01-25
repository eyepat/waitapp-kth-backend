package se.kth.ki.waitapp.dto.metrics;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import se.kth.ki.waitapp.dto.BaseDTO;

@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public abstract class GenericMetricDTO<T> extends BaseDTO {
    @NotNull
    private Long userID;
    @NotNull
    private Long sprintID;
    @NotNull
    private LocalDateTime timestamp;
    private T value;
}