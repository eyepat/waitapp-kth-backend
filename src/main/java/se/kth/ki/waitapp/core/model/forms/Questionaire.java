package se.kth.ki.waitapp.core.model.forms;

import io.quarkus.hibernate.reactive.panache.PanacheEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hl7.fhir.instance.model.api.IBaseResource;
import se.kth.ki.waitapp.core.model.IBaseFHIRModel;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class Questionaire extends PanacheEntity implements IBaseFHIRModel {

    @Id
    private Long id;
    @Column(name = "owner", nullable = false)
    private UUID owner;

    @Column(name="fhir")
    private org.hl7.fhir.r4.model.Questionnaire FHIR = new org.hl7.fhir.r4.model.Questionnaire();

    @Override
    public void setFHIR(IBaseResource resource) {
        this.FHIR = (org.hl7.fhir.r4.model.Questionnaire) resource;
    }
}
