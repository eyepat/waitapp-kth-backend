package se.kth.ki.waitapp.core.model.sprint;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import io.quarkus.hibernate.reactive.panache.PanacheEntity;
import jakarta.persistence.*;
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
public class Sprint extends PanacheEntity implements IBaseModel {

    private Long id;

    @Column(name = "owner", nullable = false)
    private UUID owner;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private SprintType sprintType;

    @Column(length = 11)
    private LocalDate startDate;

    @Column(length = 11)
    private LocalDate endDate;

    @Column(nullable = false)
    private Boolean completed;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Level level;

    @Column(name = "score")
    private Float score;

    @Column(name = "userID")
    private Long userID;

    @OneToMany(mappedBy = "sprint", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<SprintActivity> activities;

    @PrePersist
    protected void onCreate() {
        if (startDate == null) {
            startDate = LocalDate.now();
        }
        if (endDate == null) {
            endDate = startDate.plusDays(10);
        }
        if (completed == null) {
            completed = false;
        }
    }

}
