package se.kth.ki.waitapp.core.service;

import io.quarkus.security.identity.SecurityIdentity;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import se.kth.ki.waitapp.core.interfaces.repository.IQuestionnaireRepository;
import se.kth.ki.waitapp.core.interfaces.service.IQuestionnaireService;
import se.kth.ki.waitapp.core.model.forms.Questionnaire;
import se.kth.ki.waitapp.dto.forms.QuestionnaireDTO;
import se.kth.ki.waitapp.mappers.IQuestionnaireMapper;

@ApplicationScoped
public class QuestionnaireService extends GenericFHIRService<Questionnaire, QuestionnaireDTO>
        implements IQuestionnaireService {

    @Inject
    public QuestionnaireService(IQuestionnaireMapper mapper, IQuestionnaireRepository repository,
            SecurityIdentity identity) {
        super(mapper, repository, identity);
    }
}
