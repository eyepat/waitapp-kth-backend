package se.kth.ki.waitapp.core.service;

import io.quarkus.security.identity.SecurityIdentity;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import se.kth.ki.waitapp.core.interfaces.repository.IQuestionaireResponseRepository;
import se.kth.ki.waitapp.core.interfaces.service.IQuestionaireResponseService;
import se.kth.ki.waitapp.core.model.forms.QuestionaireResponse;
import se.kth.ki.waitapp.dto.forms.QuestionaireResponseDTO;
import se.kth.ki.waitapp.mappers.IQuestionaireResponseMapper;

@ApplicationScoped
public class QuestionaireResponseService extends GenericFHIRService<QuestionaireResponse, QuestionaireResponseDTO>
        implements IQuestionaireResponseService {

    @Inject
    public QuestionaireResponseService(IQuestionaireResponseMapper mapper, IQuestionaireResponseRepository repository,
            SecurityIdentity identity) {
        super(mapper, repository, identity);
    }
}
