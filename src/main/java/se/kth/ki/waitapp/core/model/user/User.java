package se.kth.ki.waitapp.core.model.user;

import java.time.LocalDate;
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
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "user_t")
public class User extends PanacheEntity implements IBaseModel {
    @Id
    private Long id;
    @Column(name = "owner", nullable = false)
    private UUID owner;

    @Column(name = "email", nullable = false, unique = true, length = 1024)
    private String email;

    @Column(name = "fullName", nullable = false, length = 1024)
    private String fullName;

    @Column(name = "birthDate", nullable = true, length = 11)
    private LocalDate birthDate;

    @Column(name = "gender", nullable = true)
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(name = "ablationDate", nullable = true, length = 11)
    private LocalDate ablationDate;

    @Column(name = "onboarded")
    private Boolean onboarded;

    @PrePersist
    protected void onCreate() {
        if (onboarded == null) {
            onboarded = false;
        }
    }
}
