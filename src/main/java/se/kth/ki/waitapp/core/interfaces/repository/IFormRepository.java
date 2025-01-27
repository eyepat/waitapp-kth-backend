package se.kth.ki.waitapp.core.interfaces.repository;

import se.kth.ki.waitapp.core.model.forms.Questionaire;
import se.kth.ki.waitapp.dto.forms.QuestionaireDTO;

public interface IFormRepository extends IGenericFHIRRepository<Questionaire, QuestionaireDTO> {
}
