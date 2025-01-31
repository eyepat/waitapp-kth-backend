package se.kth.ki.waitapp.provider.errors;

import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.MediaType;
import jakarta.json.bind.JsonbException;
import jakarta.validation.ConstraintViolationException;

@Provider
public class BadRequestExceptionMapper implements ExceptionMapper<Throwable> {

    @Override
    public Response toResponse(Throwable exception) {
        if (exception instanceof JsonbException) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity(new ErrorResponse("Invalid JSON format", exception.getMessage()))
                    .type(MediaType.APPLICATION_JSON)
                    .build();
        } else if (exception instanceof ConstraintViolationException) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity(new ErrorResponse("Validation failed", exception.getMessage()))
                    .type(MediaType.APPLICATION_JSON)
                    .build();
        }
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                .entity(new ErrorResponse("Unexpected error", exception.getMessage()))
                .type(MediaType.APPLICATION_JSON)
                .build();
    }
}