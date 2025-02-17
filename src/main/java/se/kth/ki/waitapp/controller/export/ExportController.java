package se.kth.ki.waitapp.controller.export;

import org.eclipse.microprofile.openapi.annotations.security.SecurityRequirement;

import io.quarkus.security.Authenticated;
import io.quarkus.security.identity.SecurityIdentity;
import io.smallrye.mutiny.Uni;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.StreamingOutput;
import se.kth.ki.waitapp.core.service.ExporterService;

@SecurityRequirement(name = "SecurityScheme")
@Authenticated
@Path("export")
@Produces(MediaType.APPLICATION_OCTET_STREAM)
public class ExportController {

    @Inject
    ExporterService exporterService;

    @Inject
    SecurityIdentity identity;

    @GET
    @Produces({ "application/json", "application/csv" })
    public Uni<Response> exportData(@QueryParam("format") String format) {

        if (identity == null || identity.isAnonymous()) {
            return Uni.createFrom().item(Response.status(Response.Status.FORBIDDEN)
                    .entity("You are not authorized to access this data.")
                    .build());
        }

        return exporterService.exportData(format)
                .onItem().transformToUni(byteData -> {
                    StreamingOutput stream = outputStream -> {
                        outputStream.write(byteData);
                        outputStream.flush();
                    };

                    return Uni.createFrom().item(Response.ok(stream)
                            .header("Content-Disposition",
                                    "attachment; filename=\"export." + (format != null ? format : "json") + "\"")
                            .build());
                });
    }
}
