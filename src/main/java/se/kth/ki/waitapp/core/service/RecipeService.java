package se.kth.ki.waitapp.core.service;

import io.quarkus.security.identity.SecurityIdentity;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import se.kth.ki.waitapp.core.interfaces.repository.IRecipeRepository;
import se.kth.ki.waitapp.core.interfaces.service.IRecipeService;
import se.kth.ki.waitapp.core.model.recipe.Recipe;
import se.kth.ki.waitapp.dto.recipe.RecipeDTO;
import se.kth.ki.waitapp.mappers.IRecipeMapper;

@ApplicationScoped
public class RecipeService extends GenericService<Recipe, RecipeDTO> implements IRecipeService {

    @Inject
    public RecipeService(IRecipeMapper mapper, IRecipeRepository repository, SecurityIdentity identity) {
        super(mapper, repository, identity);
    }

}
