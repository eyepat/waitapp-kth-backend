package se.kth.ki.waitapp.dto.user;

import java.time.LocalDate;
import java.util.UUID;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.SuperBuilder;
import se.kth.ki.waitapp.core.model.user.Gender;
import se.kth.ki.waitapp.dto.BaseDTO;
import se.kth.ki.waitapp.dto.IBaseDTO;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDTO implements IBaseDTO {
    private Long id;
    private UUID owner;
    @NotNull
    @Email
    private String email;
    @NotNull
    private String fullName;
    @NotNull
    private LocalDate birthDate;
    private Gender gender;
    private LocalDate ablationDate;
    private Boolean onboarded;
}
