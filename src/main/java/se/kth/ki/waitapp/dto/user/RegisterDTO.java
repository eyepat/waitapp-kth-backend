package se.kth.ki.waitapp.dto.user;

import java.time.LocalDate;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import se.kth.ki.waitapp.core.model.user.Gender;
import se.kth.ki.waitapp.dto.BaseDTO;

@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class RegisterDTO extends BaseDTO {
    @NotNull
    @Email
    private String email;
    @NotNull
    private String password;
    @NotNull
    private String fullName;
    private LocalDate birthDate;
    private Gender gender;
    private LocalDate ablationDate;
    private Integer height;
    private Double weight;
    private Integer waistSize;
    private String bloodPressure;
}