package se.kth.ki.waitapp.core.service;

import org.eclipse.microprofile.jwt.JsonWebToken;
import org.hibernate.reactive.mutiny.Mutiny;

import io.quarkus.test.junit.QuarkusTest;

import se.kth.ki.waitapp.core.model.recipe.Recipe;
import se.kth.ki.waitapp.dto.recipe.RecipeDTO;
import se.kth.ki.waitapp.mappers.IRecipeMapperImpl;
import se.kth.ki.waitapp.repository.RecipeRepository;

@QuarkusTest
public class RecipeServiceTest extends GenericServiceTest<Recipe, RecipeDTO, RecipeService, IRecipeMapperImpl, RecipeRepository> {

    public RecipeServiceTest() {
        super(
            Recipe.class, 
            RecipeDTO.class,
            RecipeRepository.class,
            IRecipeMapperImpl.class
        );
    }

    @Override
    protected RecipeService createService(Mutiny.SessionFactory sessionFactory, JsonWebToken jwt) {
        var r = new RecipeService(mapper, repository, identity);
        r.sf = sessionFactory;
        r.jwt = jwt;
        return r;
    }
    
}
