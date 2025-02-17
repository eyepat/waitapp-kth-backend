package se.kth.ki.waitapp.controller.forms;

import io.quarkus.security.Authenticated;
import jakarta.inject.Inject;
import jakarta.ws.rs.Path;

import org.eclipse.microprofile.openapi.annotations.security.SecurityRequirement;
import se.kth.ki.waitapp.controller.GenericController;
import se.kth.ki.waitapp.core.interfaces.service.IQuestionnaireService;
import se.kth.ki.waitapp.dto.forms.QuestionnaireDTO;

@Path("questionnaire")
@SecurityRequirement(name = "SecurityScheme")
@Authenticated
public class QuestionnaireController extends GenericController<QuestionnaireDTO, IQuestionnaireService> {
    @Inject
    public QuestionnaireController(IQuestionnaireService formService) {
        super(formService);
    }
}
