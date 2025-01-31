package se.kth.ki.waitapp.core.service;

import io.quarkus.security.identity.SecurityIdentity;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import se.kth.ki.waitapp.core.interfaces.repository.IQuestionaireRepository;
import se.kth.ki.waitapp.core.interfaces.service.IQuestionaireService;
import se.kth.ki.waitapp.core.model.forms.Questionaire;
import se.kth.ki.waitapp.dto.forms.QuestionaireDTO;
import se.kth.ki.waitapp.mappers.IQuestionaireMapper;

@ApplicationScoped
public class QuestionaireService extends GenericFHIRService<Questionaire, QuestionaireDTO>
        implements IQuestionaireService {

    @Inject
    public QuestionaireService(IQuestionaireMapper mapper, IQuestionaireRepository repository,
            SecurityIdentity identity) {
        super(mapper, repository, identity);
    }
}
