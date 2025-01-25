package se.kth.ki.waitapp.core.model;

import java.util.UUID;

import io.quarkus.hibernate.reactive.panache.PanacheEntity;
import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@MappedSuperclass
@NoArgsConstructor
@AllArgsConstructor
public abstract class BaseModel extends PanacheEntity {
    private Long id;

    @Column(name = "owner", nullable = false)
    private UUID owner;
}
