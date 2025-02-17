package se.kth.ki.waitapp.core.service;

import io.quarkus.security.identity.SecurityIdentity;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;

import org.apache.commons.lang3.NotImplementedException;

import se.kth.ki.waitapp.core.interfaces.service.IBloodPressureService;
import se.kth.ki.waitapp.core.interfaces.service.IExporterService;
import se.kth.ki.waitapp.core.interfaces.service.IHeightService;
import se.kth.ki.waitapp.core.interfaces.service.IQuestionnaireResponseService;
import se.kth.ki.waitapp.core.interfaces.service.IRAPAService;
import se.kth.ki.waitapp.core.interfaces.service.ISprintService;
import se.kth.ki.waitapp.core.interfaces.service.IUserService;
import se.kth.ki.waitapp.core.interfaces.service.IWaistSizeService;
import se.kth.ki.waitapp.core.interfaces.service.IWeightService;

import java.util.HashMap;
import java.util.Map;

@ApplicationScoped
public class ExporterService implements IExporterService {

    @Inject
    SecurityIdentity identity;

    @Inject
    IUserService userService;

    @Inject
    ISprintService sprintService;

    @Inject
    IBloodPressureService bloodPressureService;

    @Inject
    IHeightService heightService;

    @Inject
    IQuestionnaireResponseService questionnaireResponseService;

    @Inject
    IRAPAService rapaService;

    @Inject
    IWaistSizeService waistSizeService;

    @Inject
    IWeightService weightService;

    @Override
    public Uni<byte[]> exportData(String format) {
        if (format == null || format.isEmpty()) {
            format = "json";
        }

        final String finalformat = format;

        Uni<Map<String, Object>> dataUni = getData();

        return dataUni.onItem().transformToUni(list -> {
            switch (finalformat.toLowerCase()) {
                case "json":
                    return exportToJson(list);
                case "csv":
                    return exportToCsv(list);
                default:
                    throw new IllegalArgumentException("Unsupported format: " + finalformat);
            }
        });
    }

    private Uni<Map<String, Object>> getData() {
        return Uni.combine().all().unis(
                userService.findAll(),
                sprintService.findAll(),
                bloodPressureService.findAll(),
                heightService.findAll(),
                questionnaireResponseService.findAll(),
                rapaService.findAll(),
                waistSizeService.findAll(),
                weightService.findAll()).asTuple().map(tuple -> {
                    Map<String, Object> dataMap = new HashMap<>();
                    dataMap.put("users", tuple.getItem1()); // User data
                    dataMap.put("sprints", tuple.getItem2()); // Sprint data
                    dataMap.put("bloodPressure", tuple.getItem3()); // BloodPressure data
                    dataMap.put("heights", tuple.getItem4()); // Height data
                    dataMap.put("questionnaireResponses", tuple.getItem5()); // Questionnaire responses
                    dataMap.put("rapaData", tuple.getItem6()); // RAPA data
                    dataMap.put("waistSizes", tuple.getItem7()); // Waist size data
                    dataMap.put("weights", tuple.getItem8()); // Weight data

                    return dataMap;
                });
    }

    private Uni<byte[]> exportToJson(Object data) {
        Jsonb jsonb = JsonbBuilder.create();
        byte[] byteData = jsonb.toJson(data).getBytes();
        return Uni.createFrom().item(byteData);
    }

    private Uni<byte[]> exportToCsv(Object data) {
        throw new NotImplementedException("CSV export is not implemented.");
    }
}
