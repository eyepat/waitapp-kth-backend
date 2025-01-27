package se.kth.ki.waitapp.mappers;

import org.mapstruct.Mapper;

import jakarta.enterprise.context.ApplicationScoped;
import se.kth.ki.waitapp.core.model.forms.QuestionaireResponse;
import se.kth.ki.waitapp.dto.forms.QuestionaireResponseDTO;

@Mapper(componentModel = "cdi")
@ApplicationScoped
public interface IQuestionaireResponseMapper extends IGenericMapper<QuestionaireResponse, QuestionaireResponseDTO> {
}
