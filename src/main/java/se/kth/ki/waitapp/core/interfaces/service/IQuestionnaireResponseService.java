package se.kth.ki.waitapp.core.interfaces.service;

import se.kth.ki.waitapp.core.model.forms.QuestionnaireResponse;
import se.kth.ki.waitapp.dto.forms.QuestionnaireResponseDTO;

public interface IQuestionnaireResponseService
        extends IGenericFHIRService<QuestionnaireResponse, QuestionnaireResponseDTO> {
}
