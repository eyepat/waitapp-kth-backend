package se.kth.ki.waitapp.controller.system;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/healthz")
public class HealthCheckController {
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Response hello() {
        return Response.ok("Healthy :)").build();
    }
}