package se.kth.ki.waitapp.core.model.user;

import java.time.LocalDate;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import se.kth.ki.waitapp.core.model.BaseModel;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "user_t")
public class User extends BaseModel {

    private Long id;
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
