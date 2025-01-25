package se.kth.ki.waitapp.core.model;

import io.quarkus.hibernate.reactive.panache.PanacheEntity;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;

@Data
@MappedSuperclass
public abstract class BaseModel extends PanacheEntity {
}
