package se.kth.ki.waitapp.controller.forms;

import org.eclipse.microprofile.openapi.annotations.security.SecurityRequirement;

import io.quarkus.security.Authenticated;
import jakarta.ws.rs.Path;
import se.kth.ki.waitapp.controller.GenericController;
import se.kth.ki.waitapp.core.interfaces.service.IQuestionnaireResponseService;
import se.kth.ki.waitapp.dto.forms.QuestionnaireResponseDTO;

@Path("questionnaireResponse")
@SecurityRequirement(name = "SecurityScheme")
@Authenticated
public class QuestionnaireResponseController
        extends GenericController<QuestionnaireResponseDTO, IQuestionnaireResponseService> {

    public QuestionnaireResponseController(IQuestionnaireResponseService service) {
        super(service);
    }

}
