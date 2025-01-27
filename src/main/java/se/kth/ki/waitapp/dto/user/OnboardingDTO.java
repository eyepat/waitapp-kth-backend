package se.kth.ki.waitapp.dto.user;

import java.time.LocalDate;
import java.util.UUID;

import lombok.*;
import lombok.experimental.SuperBuilder;
import se.kth.ki.waitapp.core.model.user.Gender;
import se.kth.ki.waitapp.dto.BaseDTO;
import se.kth.ki.waitapp.dto.IBaseDTO;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OnboardingDTO implements IBaseDTO {
    private Long id;
    private UUID owner;
    private String email;
    private String fullName;
    private LocalDate BirthDate;
    private Gender gender;
    private LocalDate ablationDate;
    private Integer height;
    private Double weight;
    private Integer waistSize;
    private String bloodPressure;
}
