package se.kth.ki.waitapp.mappers;

import org.mapstruct.Mapper;

import jakarta.enterprise.context.ApplicationScoped;
import se.kth.ki.waitapp.core.model.recipe.Recipe;
import se.kth.ki.waitapp.dto.recipe.RecipeDTO;

@Mapper(componentModel = "cdi")
@ApplicationScoped
public interface IRecipeMapper extends IGenericMapper<Recipe, RecipeDTO> {
}
