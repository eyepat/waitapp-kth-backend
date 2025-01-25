package se.kth.ki.waitapp.controller;

import jakarta.inject.Inject;
import jakarta.ws.rs.Path;
import se.kth.ki.waitapp.core.interfaces.IRAPAService;
import se.kth.ki.waitapp.dto.metrics.RAPADTO;

@Path("rapa")
public class RAPAController extends GenericMetricController<RAPADTO, IRAPAService> {

    @Inject
    public RAPAController(IRAPAService service) {
        super(service);
    }

}
