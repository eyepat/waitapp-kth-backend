package se.kth.ki.waitapp.controller.forms;

import io.quarkus.security.Authenticated;
import jakarta.inject.Inject;
import jakarta.ws.rs.Path;

import org.eclipse.microprofile.openapi.annotations.security.SecurityRequirement;
import se.kth.ki.waitapp.controller.GenericController;
import se.kth.ki.waitapp.core.interfaces.service.IQuestionaireService;
import se.kth.ki.waitapp.dto.forms.QuestionaireDTO;

@Path("questionaire")
@SecurityRequirement(name = "KeycloakOAuth2")
@SecurityRequirement(name = "SecurityScheme")
@Authenticated
public class QuestionaireController extends GenericController<QuestionaireDTO, IQuestionaireService> {
    @Inject
    public QuestionaireController(IQuestionaireService formService) {
        super(formService);
    }
}
