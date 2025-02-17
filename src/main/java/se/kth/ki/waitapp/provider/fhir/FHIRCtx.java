package se.kth.ki.waitapp.provider.fhir;

import ca.uhn.fhir.context.FhirContext;
import jakarta.enterprise.inject.Produces;
import jakarta.ws.rs.ext.Provider;

@Provider
public class FHIRCtx {
    @Produces
    public FhirContext ctx() {
        return FhirContext.forR4();
    }
}
