package com.codecool.controllers;

import com.codecool.DatabaseConnector.Connector;
import com.codecool.models.Pokemon;
import javax.persistence.EntityManager;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;


@Path("pokemons")
public class PokemonController {


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Pokemon> getAll() {
        EntityManager em = Connector.getInstance().startTransaction();
        List<Pokemon> pokemons = em.createNamedQuery("Pokemon.findAllPokemons").getResultList();
        Connector.getInstance().endTransaction();
        return pokemons;
    }


    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Pokemon getPokemonById(@PathParam("id") Integer id) {
        EntityManager em = Connector.getInstance().startTransaction();
        Pokemon pokemon = em.find(Pokemon.class, id);
        Connector.getInstance().endTransaction();
        return pokemon;
    }












}
