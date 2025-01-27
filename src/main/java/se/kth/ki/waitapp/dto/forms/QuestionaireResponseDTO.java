package se.kth.ki.waitapp.dto.forms;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hl7.fhir.instance.model.api.IBaseResource;
import se.kth.ki.waitapp.dto.IBaseFHIRDTO;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class QuestionaireResponseDTO implements IBaseFHIRDTO {
    private Long id;
    private UUID owner;
    private org.hl7.fhir.r4.model.QuestionnaireResponse FHIR;

    @Override
    public void setFHIR(IBaseResource fhir) {
        this.FHIR = (org.hl7.fhir.r4.model.QuestionnaireResponse) fhir;
    }
}
