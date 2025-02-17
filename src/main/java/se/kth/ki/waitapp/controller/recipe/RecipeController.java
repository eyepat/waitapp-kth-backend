package se.kth.ki.waitapp.controller.recipe;

import org.eclipse.microprofile.openapi.annotations.security.SecurityRequirement;

import io.quarkus.security.Authenticated;
import jakarta.inject.Inject;
import jakarta.ws.rs.Path;
import se.kth.ki.waitapp.controller.GenericController;
import se.kth.ki.waitapp.core.interfaces.service.IRecipeService;
import se.kth.ki.waitapp.dto.recipe.RecipeDTO;

@Path("recipe")
@SecurityRequirement(name = "SecurityScheme")
@Authenticated
public class RecipeController extends GenericController<RecipeDTO, IRecipeService> {

    @Inject
    public RecipeController(IRecipeService service) {
        super(service);
    }

}
