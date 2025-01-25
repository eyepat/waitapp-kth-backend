package se.kth.ki.waitapp.controller.metrics;

import io.quarkus.security.Authenticated;
import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import se.kth.ki.waitapp.controller.GenericController;
import se.kth.ki.waitapp.core.interfaces.IGenericMetricService;
import se.kth.ki.waitapp.dto.BaseDTO;

public abstract class GenericMetricController<TDTO extends BaseDTO, TSERVICE extends IGenericMetricService<?, TDTO>>
                extends GenericController<TDTO, TSERVICE> {

        public GenericMetricController(TSERVICE service) {
                super(service);
        }

        @GET
        @Path("/latest")
        @Produces(MediaType.APPLICATION_JSON)
        @Authenticated
        public Uni<Response> latest() {
                return service.latest()
                                .map(dto -> dto != null ? Response.ok(dto).build()
                                                : Response.status(Response.Status.NOT_FOUND).build());

        }

}
