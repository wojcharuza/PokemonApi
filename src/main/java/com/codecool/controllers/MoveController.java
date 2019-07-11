package com.codecool.controllers;

import com.codecool.DatabaseConnector.Connector;
import com.codecool.models.Move;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/moves")
public class MoveController {

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Move getMoveById(@PathParam("id") int id) {
        EntityManager em = Connector.getInstance().startTransaction();
        Move move = em.find(Move.class, id);
        Connector.getInstance().endTransaction();
        return move;
    }

    @GET
    @Path("/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public Move getMoveByName(@PathParam("name") String name) {
        EntityManager em = Connector.getInstance().startTransaction();
        Query query = em.createQuery("from Move where name = :name");
        query.setParameter("name", name);
        Move move = (Move) query.getSingleResult();
        Connector.getInstance().endTransaction();
        return move;



    }

}
