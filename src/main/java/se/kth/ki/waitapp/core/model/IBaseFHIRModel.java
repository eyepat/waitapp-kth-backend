package se.kth.ki.waitapp.core.model;

import org.hl7.fhir.instance.model.api.IBaseResource;

public interface IBaseFHIRModel extends IBaseModel {
    IBaseResource getFHIR();
    void setFHIR(IBaseResource resource);
}
