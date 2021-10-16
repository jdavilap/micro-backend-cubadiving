package com.cubadivingtour.controllers;


import com.cubadivingtour.entity.Cliente;
import com.cubadivingtour.entity.Paseo;
import com.cubadivingtour.entity.Reserva;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;

@Path("reservas")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ReservaController {
    @GET
    public Response listarReservas() {
        return Response.ok(Reserva.listAll()).build();
    }
    @GET
    @Path("/{id}")
    public Response listarReservaPorId(@PathParam("id") Long id) {
        Reserva reserva = Reserva.findById(id);
        if (reserva.isPersistent()) {
            return Response.ok(reserva).build();
        } else {
            return Response.status(404).build();
        }
    }

    @POST
    @Path("/idcliente/{idcliente}/paseo/{idpaseo}")
    @Transactional
    public Response crearReserva(Reserva reserva, @PathParam("idcliente") Long idcliente, @PathParam("idpaseo") Long idpaseo) {
        int random_int = (int) Math.floor(Math.random() * (1000 - 0 + 1) + 0);
        reserva.setCodReserva("CU" + random_int);
        Cliente cliente = Cliente.findById(idcliente);
        reserva.setCliente(cliente);
        Paseo paseo = Paseo.findById(idpaseo);
        reserva.setPaseo(paseo);
        reserva.persist();
        return Response.created(URI.create("/reservas/" + Long.toString(reserva.id))).entity(reserva).build();
    }
}
