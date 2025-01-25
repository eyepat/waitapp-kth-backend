package se.kth.ki.waitapp.dto.metrics;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
public class BloodPressureDTO extends GenericMetricDTO<String> {
}
