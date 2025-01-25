package se.kth.ki.waitapp.controller;

import jakarta.inject.Inject;
import jakarta.ws.rs.Path;
import se.kth.ki.waitapp.core.interfaces.IHeightService;
import se.kth.ki.waitapp.dto.metrics.HeightDTO;

@Path("height")
public class HeightController extends GenericMetricController<HeightDTO, IHeightService> {

    @Inject
    public HeightController(IHeightService service) {
        super(service);
    }

}
