package se.kth.ki.waitapp.config.serialization;

import org.hl7.fhir.instance.model.api.IBaseResource;
import ca.uhn.fhir.context.FhirContext;
import jakarta.inject.Inject;
import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.bind.adapter.JsonbAdapter;
import java.io.StringReader;

public class FhirResourceJsonbAdapter implements JsonbAdapter<IBaseResource, JsonObject> {

    @Inject
    FhirContext fhirContext;

    @Override
    public JsonObject adaptToJson(IBaseResource resource) throws Exception {
        if (resource == null) {
            return null;
        }

        // Use HAPI FHIR's context to serialize the FHIR resource into a JSON string
        String jsonString = fhirContext.newJsonParser().encodeResourceToString(resource);

        // Convert the JSON string into a JsonObject for structured representation
        return Json.createReader(new StringReader(jsonString)).readObject();
    }

    @Override
    public IBaseResource adaptFromJson(JsonObject json) throws Exception {
        if (json == null) {
            return null;
        }

        String jsonString = json.toString();
        return fhirContext.newJsonParser().parseResource(jsonString);
    }
}
