package se.kth.ki.waitapp.dto.user;

import java.time.LocalDate;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import se.kth.ki.waitapp.core.model.user.Gender;
import se.kth.ki.waitapp.dto.BaseDTO;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class UserDTO extends BaseDTO {
    @NotNull
    @Email
    private String email;
    private String password;
    @NotNull
    private String fullName;
    @NotNull
    private LocalDate birthDate;
    private Gender gender;
    private LocalDate ablationDate;
    private Boolean onboarded;
}
