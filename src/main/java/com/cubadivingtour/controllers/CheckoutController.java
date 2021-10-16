package com.cubadivingtour.controllers;


import com.cubadivingtour.entity.Payment;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Charge;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.Map;

@Path("checkout")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CheckoutController {

    @ConfigProperty(name = "stripe.secret")
    String key;

    @POST
    @Transactional
    public Response createPayment(Payment payment) {

        payment.persist();

        Stripe.apiKey = key;

        Map<String, Object> params = new HashMap<>();
        params.put("amount", payment.getAmount());
        params.put("currency", payment.getCurrency());
        params.put("source", payment.getToken());
        params.put("description", payment.getDescription());


        try {
            Charge charge = Charge.create(params);
        } catch (StripeException e) {
            e.printStackTrace();
        }

        return Response.ok(payment).build();

    }

}
