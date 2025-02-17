package se.kth.ki.waitapp.mappers;

import org.mapstruct.Mapper;

import jakarta.enterprise.context.ApplicationScoped;
import se.kth.ki.waitapp.core.model.forms.QuestionnaireResponse;
import se.kth.ki.waitapp.dto.forms.QuestionnaireResponseDTO;

@Mapper(componentModel = "cdi")
@ApplicationScoped
public interface IQuestionnaireResponseMapper extends IGenericMapper<QuestionnaireResponse, QuestionnaireResponseDTO> {
}
