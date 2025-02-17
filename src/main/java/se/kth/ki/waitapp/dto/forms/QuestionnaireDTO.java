package se.kth.ki.waitapp.dto.forms;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hl7.fhir.instance.model.api.IBaseResource;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import jakarta.json.bind.annotation.JsonbTypeAdapter;
import se.kth.ki.waitapp.config.serialization.FhirResourceJsonbAdapter;
import se.kth.ki.waitapp.dto.IBaseFHIRDTO;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class QuestionnaireDTO implements IBaseFHIRDTO {
    private Long id;
    @JsonbTypeAdapter(FhirResourceJsonbAdapter.class)
    private org.hl7.fhir.r4.model.Questionnaire FHIR;

    @Override
    public void setFHIR(IBaseResource fhir) {
        this.FHIR = (org.hl7.fhir.r4.model.Questionnaire) fhir;
    }
}
