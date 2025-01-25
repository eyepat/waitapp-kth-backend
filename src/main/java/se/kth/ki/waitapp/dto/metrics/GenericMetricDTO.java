package se.kth.ki.waitapp.dto.metrics;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import se.kth.ki.waitapp.dto.BaseDTO;

@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class GenericMetricDTO<T> extends BaseDTO {
    private Long userID;
    private Long sprintID;
    private LocalDateTime timestamp;
    private T value;
}