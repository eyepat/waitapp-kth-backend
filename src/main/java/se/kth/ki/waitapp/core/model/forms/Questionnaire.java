package se.kth.ki.waitapp.core.model.forms;

import io.quarkus.hibernate.reactive.panache.PanacheEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hl7.fhir.instance.model.api.IBaseResource;
import se.kth.ki.waitapp.core.model.IBaseFHIRModel;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class Questionnaire extends PanacheEntity implements IBaseFHIRModel {

    private Long id;

    @Column(name = "fhir")
    private org.hl7.fhir.r4.model.Questionnaire FHIR;

    @Override
    public void setFHIR(IBaseResource resource) {
        this.FHIR = (org.hl7.fhir.r4.model.Questionnaire) resource;
    }
}
