package se.kth.ki.waitapp.dto.metrics;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GenericMetricDTO<T> {
    private Long userID;

    private Long sprintID;

    private LocalDateTime timeStamp;

    private T value;
}