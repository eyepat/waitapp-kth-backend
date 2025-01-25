package se.kth.ki.waitapp.controller;

import java.util.List;

import io.smallrye.mutiny.Uni;
import io.smallrye.openapi.model.BaseModel;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import se.kth.ki.waitapp.core.interfaces.IGenericService;
import se.kth.ki.waitapp.dto.BaseDTO;

public abstract class GenericController<TDTO extends BaseDTO, TSERVICE extends IGenericService<?, TDTO>> {
    protected TSERVICE service;

    public GenericController(TSERVICE service) {
        this.service = service;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Uni<List<TDTO>> getAll() {
        return service.findAll();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Uni<Response> getById(@PathParam("id") Long id) {
        return service.findById(id)
                .map(dto -> dto != null ? Response.ok(dto).build()
                        : Response.status(Response.Status.NOT_FOUND).build());
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Uni<Response> create(TDTO dto) {
        return service.create(dto)
                .map(created -> Response.status(Response.Status.CREATED).entity(created).build());
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Uni<Response> update(@PathParam("id") Long id, TDTO dto) {
        return service.update(id, dto)
                .map(updated -> updated != null ? Response.ok(updated).build()
                        : Response.status(Response.Status.NOT_FOUND).build());
    }

    @DELETE
    @Path("/{id}")
    public Uni<Response> delete(@PathParam("id") Long id) {
        return service.delete(id)
                .map(deleted -> deleted ? Response.noContent().build()
                        : Response.status(Response.Status.NOT_FOUND).build());
    }
}
