package se.kth.ki.waitapp.core.service;

import io.quarkus.security.identity.SecurityIdentity;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import se.kth.ki.waitapp.core.interfaces.repository.IQuestionnaireResponseRepository;
import se.kth.ki.waitapp.core.interfaces.service.IQuestionnaireResponseService;
import se.kth.ki.waitapp.core.model.forms.QuestionnaireResponse;
import se.kth.ki.waitapp.dto.forms.QuestionnaireResponseDTO;
import se.kth.ki.waitapp.mappers.IQuestionnaireResponseMapper;

@ApplicationScoped
public class QuestionnaireResponseService extends GenericFHIRService<QuestionnaireResponse, QuestionnaireResponseDTO>
        implements IQuestionnaireResponseService {

    @Inject
    public QuestionnaireResponseService(IQuestionnaireResponseMapper mapper,
            IQuestionnaireResponseRepository repository,
            SecurityIdentity identity) {
        super(mapper, repository, identity);
    }
}
