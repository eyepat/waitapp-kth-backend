package se.kth.ki.waitapp.mappers;

import jakarta.enterprise.context.ApplicationScoped;
import org.mapstruct.Mapper;
import se.kth.ki.waitapp.core.model.forms.Questionnaire;
import se.kth.ki.waitapp.dto.forms.QuestionnaireDTO;

@Mapper(componentModel = "cdi")
@ApplicationScoped
public interface IQuestionnaireMapper extends IGenericMapper<Questionnaire, QuestionnaireDTO> {
}
