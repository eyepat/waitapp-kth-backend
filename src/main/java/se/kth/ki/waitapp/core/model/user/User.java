package se.kth.ki.waitapp.core.model.user;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import se.kth.ki.waitapp.core.model.BaseModel;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "user_t")
public class User extends BaseModel {
    @Column(name = "email", nullable = false, unique = true, length = 1024)
    private String email;

    @Column(name = "password", nullable = false, length = 1024)
    private String password;

    @Column(name = "fullName", nullable = false, length = 1024)
    private String fullName;

    @Column(name = "birthDate", nullable = true, length = 11)
    private LocalDate birthDate;

    @Column(name = "gender", nullable = true)
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(name = "ablationDate", nullable = true, length = 11)
    private LocalDate ablationDate;

}
