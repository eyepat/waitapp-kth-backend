package se.kth.ki.waitapp.dto.metrics;

import java.time.LocalDateTime;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import se.kth.ki.waitapp.dto.BaseDTO;

@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public abstract class GenericMetricDTO<T> extends BaseDTO {
    private UUID userID;
    private UUID sprintID;
    private LocalDateTime timestamp;
    private T value;
}