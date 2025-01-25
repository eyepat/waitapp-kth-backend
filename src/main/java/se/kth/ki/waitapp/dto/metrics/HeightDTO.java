package se.kth.ki.waitapp.dto.metrics;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@Builder
@NoArgsConstructor
public class HeightDTO extends GenericMetricDTO<Integer> {
}
