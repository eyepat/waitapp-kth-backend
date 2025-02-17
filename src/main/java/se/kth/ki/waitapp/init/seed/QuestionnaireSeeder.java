package se.kth.ki.waitapp.init.seed;

import java.util.List;
import java.util.Map;

import org.hibernate.reactive.mutiny.Mutiny;
import org.hl7.fhir.r4.model.Coding;
import org.hl7.fhir.r4.model.Questionnaire;
import org.hl7.fhir.r4.model.Questionnaire.QuestionnaireItemComponent;
import org.hl7.fhir.r4.model.Questionnaire.QuestionnaireItemAnswerOptionComponent;
import org.hl7.fhir.r4.model.Enumerations.PublicationStatus;
import org.hl7.fhir.r4.model.CodeType;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import se.kth.ki.waitapp.core.interfaces.repository.IQuestionnaireRepository;

@ApplicationScoped
public class QuestionnaireSeeder extends GenericSeeder<se.kth.ki.waitapp.core.model.forms.Questionnaire> {

    @Inject
    public QuestionnaireSeeder(IQuestionnaireRepository repository, Mutiny.SessionFactory sf) {
        super(repository, sf, List.of(createRapaQuestionnaire()));
    }

    private static Questionnaire createRapaFHIRQuestionnaire() {
        Questionnaire rapa = new Questionnaire();
        rapa.setId("rapa-questionnaire");
        rapa.setStatus(PublicationStatus.ACTIVE);
        rapa.setName("RAPA");
        rapa.setTitle("Rapid Assessment of Physical Activity");
        rapa.setPublisher("KTH KI WaitApp");
        rapa.setDescription("A questionnaire to assess the physical activity level of an individual.");
        rapa.setSubjectType(List.of(new CodeType("Patient")));

        // Add RAPA questions with score mapping in both English and Swedish
        rapa.addItem(createQuestion("rapa-1",
                "I do moderate physical activities (like brisk walking) for at least 30 minutes on most days of the week.",
                "Jag utför måttlig fysisk aktivitet (som rask promenad) i minst 30 minuter de flesta dagar i veckan.",
                Map.of("yes", 1, "no", 0)));

        rapa.addItem(createQuestion("rapa-2",
                "I do vigorous physical activities (like jogging) for at least 20 minutes on three or more days per week.",
                "Jag utför intensiv fysisk aktivitet (som jogging) i minst 20 minuter tre eller fler dagar i veckan.",
                Map.of("yes", 2, "no", 0)));

        rapa.addItem(createQuestion("rapa-3",
                "Do you do activities to increase muscle strength, such as lifting weights?",
                "Tränar du för att öka muskelstyrkan, till exempel genom att lyfta vikter?",
                Map.of("yes", 2, "no", 0)));

        rapa.addItem(createQuestion("rapa-4",
                "Do you do activities to improve flexibility and balance, such as stretching or yoga?",
                "Utför du aktiviteter för att förbättra flexibilitet och balans, såsom stretching eller yoga?",
                Map.of("yes", 1, "no", 0)));

        return rapa;
    }

    private static se.kth.ki.waitapp.core.model.forms.Questionnaire createRapaQuestionnaire() {
        return se.kth.ki.waitapp.core.model.forms.Questionnaire.builder()
                .FHIR(createRapaFHIRQuestionnaire())
                .build();
    }

    private static QuestionnaireItemComponent createQuestion(String linkId, String textEn, String textSv,
            Map<String, Integer> scoreMap) {
        QuestionnaireItemComponent item = new QuestionnaireItemComponent();
        item.setLinkId(linkId);
        item.setText(textEn); // Default to English text

        // Add translations using an extension (FHIR does not natively support multiple
        // languages)
        item.addExtension("http://hl7.org/fhir/StructureDefinition/translation",
                new Coding().setSystem("urn:ietf:bcp:47").setCode("sv").setDisplay(textSv));

        item.setType(Questionnaire.QuestionnaireItemType.CHOICE);

        // Store score values in extensions (FHIR does not natively support score
        // mappings)
        for (Map.Entry<String, Integer> entry : scoreMap.entrySet()) {
            String code = entry.getKey();
            int score = entry.getValue();

            QuestionnaireItemAnswerOptionComponent option = new QuestionnaireItemAnswerOptionComponent()
                    .setValue(new Coding().setCode(code)
                            .setDisplay(code.substring(0, 1).toUpperCase() + code.substring(1)));

            // Store the score in an extension (FHIR custom field)
            option.addExtension("https://wait.app.cloud.cbh.kth.se/nonexistent/fhir/StructureDefinition/score",
                    new org.hl7.fhir.r4.model.IntegerType(score));

            item.addAnswerOption(option);
        }

        return item;
    }
}
