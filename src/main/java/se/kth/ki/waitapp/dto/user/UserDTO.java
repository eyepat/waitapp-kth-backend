package se.kth.ki.waitapp.dto.user;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import se.kth.ki.waitapp.core.model.user.Gender;
import se.kth.ki.waitapp.dto.BaseDTO;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDTO extends BaseDTO {
    private String email;
    private String password;
    private String fullName;
    private LocalDate birthDate;
    private Gender gender;
    private LocalDate ablationDate;
    private Boolean onboarded;
}
