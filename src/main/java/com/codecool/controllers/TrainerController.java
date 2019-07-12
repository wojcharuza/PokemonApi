package com.codecool.controllers;


import com.codecool.DatabaseConnector.Connector;
import com.codecool.DatabasePopulators.DatabasePopulator;
import com.codecool.models.Pokemon;
import com.codecool.models.Trainer;
import org.hibernate.Hibernate;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Random;

@Path("trainers")
public class TrainerController {




    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Trainer> getAll()  {
        EntityManager em = Connector.getInstance().startTransaction();
        List<Trainer> trainers = em.createNamedQuery("Trainer.findAllTrainers").getResultList();
        for (Trainer t: trainers) {
            Hibernate.initialize(t.getPokemons());
            Hibernate.initialize(t.getGymsBeaten());

        }
        Connector.getInstance().endTransaction();
        return trainers;
    }


    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Trainer getPokemonById(@PathParam("id") Integer id) {
        EntityManager em = Connector.getInstance().startTransaction();
        Trainer trainer = em.find(Trainer.class, id);
        Hibernate.initialize(trainer.getPokemons());
        Hibernate.initialize(trainer.getGymsBeaten());
        Connector.getInstance().endTransaction();
        return trainer;
    }


    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createTrainer(Trainer trainer) {
        EntityManager em = Connector.getInstance().startTransaction();
        Hibernate.initialize(trainer.getPokemons());
        Hibernate.initialize(trainer.getGymsBeaten());
        em.persist(trainer);
        Connector.getInstance().endTransaction();
        String response = "trainer added";
        return Response.ok().entity(response).build();
    }


    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateTrainer(@PathParam("id") Integer id, Trainer trainer){
        EntityManager em = Connector.getInstance().startTransaction();
        Trainer oldTrainer = em.find(Trainer.class, id);
        oldTrainer.setFirstName(trainer.getFirstName());
        oldTrainer.setLastName(trainer.getLastName());
        oldTrainer.setNickName(trainer.getNickName());
        Connector.getInstance().endTransaction();
        String response = "trainer updated";
        return Response.ok().entity(response).build();
    }


    @DELETE
    @Path("{id}")
    public Response deleteTrainer(@PathParam("id") int id) {
        EntityManager em = Connector.getInstance().startTransaction();
        Trainer trainer = em.find(Trainer.class, id);
        em.remove(trainer);
        Connector.getInstance().endTransaction();
        String response = "trainer deleted";
        return Response.ok().entity(response).build();
    }


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response catchPokemon(@QueryParam("pokemonID") int pokemonID, @QueryParam("trainerID") int trainerID) {
        Random random = new Random();
        String response = "";
        int randomNumber = random.nextInt(10)+1;

        if (randomNumber > 5){
            EntityManager em = Connector.getInstance().startTransaction();
            Pokemon catchedPokemon = em.find(Pokemon.class, pokemonID);
            Trainer trainer = em.find(Trainer.class, trainerID);

            List<Pokemon> pokemons = trainer.getPokemons();
            pokemons.add(catchedPokemon);
            trainer.setPokemons(pokemons);

            Connector.getInstance().endTransaction();
            response = "pokemon caught";
        } else {
            response = "pokemon escaped";

        }
        return Response.ok().entity(response).build();
    }
}
