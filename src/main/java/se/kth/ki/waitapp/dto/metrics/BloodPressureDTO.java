package se.kth.ki.waitapp.dto.metrics;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
@NoArgsConstructor
public class BloodPressureDTO extends GenericMetricDTO<String> {
}
