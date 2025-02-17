package se.kth.ki.waitapp.dto.recipe;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import se.kth.ki.waitapp.dto.IBaseDTO;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RecipeDTO implements IBaseDTO {
    private Long id;
    @JsonIgnore
    private UUID owner;
    private String URL;
    private String title;
    private String description;
    private String imageURL;
    private Integer cookingTime;
}
