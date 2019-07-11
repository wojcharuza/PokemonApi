package com.codecool.controllers;

import com.codecool.models.Pokemon;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

public class PokemonController {

    @GET
    @Path("pokemon")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Pokemon> getPokemons() {
        return null;
    }

}
