package se.kth.ki.waitapp.dto.user;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import se.kth.ki.waitapp.core.model.user.Gender;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDTO {
    private long userID;
    private String email;
    private String password;
    private String fullName;
    private LocalDate birthDate;
    private Gender gender;
    private LocalDate ablationDate;
}
