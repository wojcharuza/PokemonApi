package com.codecool.controllers;


import com.codecool.DatabaseConnector.Connector;
import com.codecool.DatabasePopulators.DatabasePopulator;
import com.codecool.models.Pokemon;
import com.codecool.models.Trainer;
import org.hibernate.Hibernate;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("trainers")
public class TrainerController {




    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Trainer> getAll()  {
        EntityManager em = Connector.getInstance().startTransaction();
        List<Trainer> trainers = em.createNamedQuery("Trainer.findAllTrainers").getResultList();
        for (Trainer t: trainers) {
            Hibernate.initialize(t.getPokemons());

        }
        Connector.getInstance().endTransaction();
        return trainers;
    }


}
