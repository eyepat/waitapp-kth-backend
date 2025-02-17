package se.kth.ki.waitapp.dto.recipe;

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
    private String URL;
    private String title;
    private String description;
    private String imageURL;
    private Integer cookingTime;
}
