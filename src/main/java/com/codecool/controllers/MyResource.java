package com.codecool.controllers;

import com.codecool.DatabaseConnector.Connector;
import com.codecool.models.Pokemon;

import javax.persistence.EntityManager;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("pokemons")
public class MyResource {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Pokemon getAll() {
        EntityManager em = Connector.getInstance().startTransaction();
        Pokemon pokemon = em.find(Pokemon.class, 1);
        Connector.getInstance().endTransaction();
        return pokemon;
    }
}
