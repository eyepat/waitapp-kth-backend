package se.kth.ki.waitapp.dto.metrics;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StepsDTO extends GenericMetricDTO<Integer> {
}
