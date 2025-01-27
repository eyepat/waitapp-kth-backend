package se.kth.ki.waitapp.core.interfaces.service;

import se.kth.ki.waitapp.core.model.forms.QuestionaireResponse;
import se.kth.ki.waitapp.dto.forms.QuestionaireResponseDTO;

public interface IQuestionaireResponseService
        extends IGenericFHIRService<QuestionaireResponse, QuestionaireResponseDTO> {
}
