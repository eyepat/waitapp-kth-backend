package se.kth.ki.waitapp.dto.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import se.kth.ki.waitapp.dto.BaseDTO;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoginDTO extends BaseDTO {
    private String email;
    private String password;
}
