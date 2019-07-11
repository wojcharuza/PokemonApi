package com.codecool.controllers;

import com.codecool.DatabaseConnector.Connector;
import com.codecool.models.Trainer;

import javax.persistence.EntityManager;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("gyms")
public class GymController {


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Trainer> getAll()  {
        EntityManager em = Connector.getInstance().startTransaction();
        List<Trainer> trainers = em.createNamedQuery("Gym.findAllGyms").getResultList();
        Connector.getInstance().endTransaction();
        return trainers;
    }
}
