package se.kth.ki.waitapp.dto;

import org.hl7.fhir.instance.model.api.IBaseResource;

public interface IBaseFHIRDTO extends IBaseDTO {
    IBaseResource getFHIR();
    void setFHIR(IBaseResource fhir);
}
