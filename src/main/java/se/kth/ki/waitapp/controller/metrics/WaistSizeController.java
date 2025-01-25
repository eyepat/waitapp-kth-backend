package se.kth.ki.waitapp.controller.metrics;

import jakarta.inject.Inject;
import jakarta.ws.rs.Path;
import se.kth.ki.waitapp.core.interfaces.IWaistSizeService;
import se.kth.ki.waitapp.dto.metrics.WaistSizeDTO;

@Path("waistsize")
public class WaistSizeController extends GenericMetricController<WaistSizeDTO, IWaistSizeService> {

    @Inject
    public WaistSizeController(IWaistSizeService service) {
        super(service);
    }

}
