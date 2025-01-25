package se.kth.ki.waitapp.core.model.metrics;

import jakarta.persistence.Entity;
import lombok.Builder;
import lombok.Data;

@Data
@Entity
@Builder
public class WaistSize extends GenericMetric<Integer> {
}
