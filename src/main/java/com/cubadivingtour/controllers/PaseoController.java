package com.cubadivingtour.controllers;

import com.cubadivingtour.entity.Paseo;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;


@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("paseos")
public class PaseoController {

    @GET
    public Response listarPaseos() {
        return Response.ok(Paseo.listAll()).build();
    }

    @POST
    @Transactional
    public Response agregarPaseo(Paseo paseo) {
        paseo.persist();
        return Response.created(UriBuilder
                .fromResource(PaseoController.class)
                .path(paseo.getNombre())
                .build())
                .entity(paseo)
                .build();
    }
}
