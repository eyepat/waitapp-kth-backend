package se.kth.ki.waitapp.controller.forms;

import org.eclipse.microprofile.openapi.annotations.security.SecurityRequirement;

import io.quarkus.security.Authenticated;
import jakarta.ws.rs.Path;
import se.kth.ki.waitapp.controller.GenericController;
import se.kth.ki.waitapp.core.interfaces.service.IQuestionaireResponseService;
import se.kth.ki.waitapp.dto.forms.QuestionaireResponseDTO;

@Path("questionaireResponse")
@SecurityRequirement(name = "SecurityScheme")
@Authenticated
public class QuestionaireResponseController
        extends GenericController<QuestionaireResponseDTO, IQuestionaireResponseService> {

    public QuestionaireResponseController(IQuestionaireResponseService service) {
        super(service);
    }

}
