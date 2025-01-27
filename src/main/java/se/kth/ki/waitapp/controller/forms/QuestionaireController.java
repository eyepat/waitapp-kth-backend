package se.kth.ki.waitapp.controller.forms;

import io.quarkus.security.Authenticated;
import jakarta.inject.Inject;
import org.eclipse.microprofile.openapi.annotations.security.SecurityRequirement;
import se.kth.ki.waitapp.controller.GenericController;
import se.kth.ki.waitapp.core.interfaces.service.IFormService;
import se.kth.ki.waitapp.dto.forms.QuestionaireDTO;

@SecurityRequirement(name = "KeycloakOAuth2")
@SecurityRequirement(name = "SecurityScheme")
@Authenticated
public class QuestionaireController extends GenericController<QuestionaireDTO, IFormService> {
    @Inject
    public QuestionaireController(final IFormService formService) {
        super(formService);
    }
}
