package se.kth.ki.waitapp.core.model.sprint;

import io.quarkus.hibernate.reactive.panache.PanacheEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrePersist;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import se.kth.ki.waitapp.core.model.IBaseModel;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Task extends PanacheEntity implements IBaseModel {

    private Long id;

    @Column(nullable = false)
    private String title;

    private String description;

    private String videoURL;

    @Column(nullable = false)
    private SprintType type;

    @Column(nullable = false)
    private Level level;

    @Column(nullable = false)
    private TaskVariant variant;

    @Column(nullable = false)
    private Boolean active;

    @PrePersist
    protected void onCreate() {
        if (active == null) {
            active = true;
        }
    }
}
