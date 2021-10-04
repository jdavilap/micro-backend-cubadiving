package com.cubadivingtour.controllers;

import com.cubadivingtour.entity.Cliente;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

@Path("/clientes")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ClienteController {
    @GET
    public Response obtenerListadoClientes() {
        return Response.ok(Cliente.listAll()).build();
    }

    @GET
    @Path("/{id}")
    public Response obtenerClientePorId(@PathParam("id") Long id) {

        Cliente cliente = Cliente.findById(id);

        return Response.ok(cliente).build();

    }

    @POST
    @Transactional
    public Response agregarCliente(Cliente cliente) {
        cliente.persist();
        return Response.created(UriBuilder.fromResource(ClienteController.class).path(cliente.getCorreo()).build()).entity(cliente).build();
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public Response eliminarCliente(@PathParam("id") Long id) {
        boolean eliminado = Cliente.deleteById(id);
        return Response.ok(eliminado).build();
    }
}
