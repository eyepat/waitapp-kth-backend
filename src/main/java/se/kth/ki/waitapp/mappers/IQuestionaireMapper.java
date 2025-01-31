package se.kth.ki.waitapp.mappers;

import jakarta.enterprise.context.ApplicationScoped;
import org.mapstruct.Mapper;
import se.kth.ki.waitapp.core.model.forms.Questionaire;
import se.kth.ki.waitapp.dto.forms.QuestionaireDTO;

@Mapper(componentModel = "cdi")
@ApplicationScoped
public interface IQuestionaireMapper extends IGenericMapper<Questionaire, QuestionaireDTO> {
}
