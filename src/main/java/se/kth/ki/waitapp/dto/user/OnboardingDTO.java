package se.kth.ki.waitapp.dto.user;

import java.time.LocalDate;
import java.util.UUID;

import lombok.*;
import se.kth.ki.waitapp.core.model.user.Gender;
import se.kth.ki.waitapp.dto.IOwnableDTO;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OnboardingDTO implements IOwnableDTO {
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
