package com.codecool.DatabasePopulators;

import com.codecool.DatabaseConnector.Connector;
import com.codecool.models.Gym;
import com.codecool.models.Move;
import com.codecool.models.Pokemon;
import com.codecool.models.Trainer;

import javax.persistence.EntityManager;
import javax.persistence.Transient;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class DatabasePopulator extends HttpServlet {

    public void init() throws ServletException {

        //pikachu
        Move electroshock = new Move("thunder shock", "electric", 100);
        Move quickAttack = new Move("quick attack", "normal",  20);

        //squirtle
        Move tackle = new Move("tackle", "normal",  10);
        Move bubble = new Move("bubble", "water",  30);

        //magnemite
        Move spark = new Move("spark", "electric", 34);
        Move thunderShock = new Move("thunder shock", "electric", 21);
        Move vineWhip = new Move("vine whip", "grass", 20);

        Move ember = new Move("ember", "fire", 80);
        Move wingAttack = new Move("wing attack", "flying", 45);

        Move bite = new Move("bite", "normal", 10);
        Move fireFang = new Move("fire fang", "fire", 50);


        List<Move> pikachuMoves = Arrays.asList(electroshock, quickAttack);
        List<Move> squirtleMoves = Arrays.asList(tackle, bubble);
        List<Move>  magnemiteMoves = Arrays.asList(spark, thunderShock);
        List<Move> rattataMoves = Arrays.asList(quickAttack, tackle);
        List<Move> bulbasaurMoves = Arrays.asList(tackle, vineWhip);
        List<Move>  charizardMoves = Arrays.asList(ember, wingAttack);
        List<Move> vulpixMoves = Arrays.asList(ember, quickAttack);
        List<Move> arcananineMoves = Arrays.asList(bite, fireFang);


        Pokemon arcanine = new Pokemon("arcanine", "fire", arcananineMoves, "none", 59, "78", "10");
        Pokemon vulpix = new Pokemon("vulpix", "fire", vulpixMoves, "ninetales", 37, "121", "200");
        Pokemon charizard = new Pokemon("charizard", "fire", charizardMoves, "none", 6, "400", "500");
        Pokemon bulbasaur = new Pokemon("bulbasaur", "grass", bulbasaurMoves, "ivysaur", 1, "50", "50");
        Pokemon pikachu = new Pokemon("pikachu", "electric", pikachuMoves, "raichu", 25, "100", "300");
        Pokemon squirtle = new Pokemon("squirtle", "water", squirtleMoves, "wartortle", 7, "40", "10");
        Pokemon magnemite = new Pokemon("magnemite", "electric", magnemiteMoves, "magneton", 82, "100", "100");
        Pokemon rattata = new Pokemon("rattata", "normal", rattataMoves, "raticate", 19, "10", "20");

        // lost of trainers pokemon
        List<Pokemon> pokemonList = new ArrayList<>();
        pokemonList.add(pikachu);
        pokemonList.add(rattata);



        List<Pokemon> kamilList = new ArrayList<>();
        List<Pokemon> wojtekList = new ArrayList<>();
        List<Pokemon> pawelList = new ArrayList<>();

        kamilList.add(arcanine);
        kamilList.add(pikachu);

        wojtekList.add(charizard);
        wojtekList.add(bulbasaur);
        wojtekList.add(squirtle);

        pawelList.add(vulpix);
        pawelList.add(magnemite);
        pawelList.add(charizard);
        pawelList.add(rattata);

        // gyms beaten by trainer
        List<Gym> beatenGyms = new ArrayList<>();
        Gym fireGym = new Gym("gym2","fire","starachowice");
        Gym waterGym = new Gym("gym1","fire","alabastia");
        beatenGyms.add(waterGym);

        // new trainer
        Trainer ash = new Trainer("asj","ketchup","keczup",pokemonList, beatenGyms);
        Trainer brok = new Trainer("Brok","Brok","Brok",pokemonList, new ArrayList<Gym>());
        Trainer kamil = new Trainer("Kamil", "Bracki", "detritus1", kamilList, beatenGyms);
        Trainer wojtek = new Trainer("Wojtek", "Charuza", "WojtoszNOB", wojtekList, beatenGyms);
        Trainer pawel = new Trainer("Pawel", "Płodzień", "Zibon", pawelList, beatenGyms);


        EntityManager em = Connector.getInstance().startTransaction();
        em.persist(ember);
        em.persist(tackle);
        em.persist(bubble);
        em.persist(spark);
        em.persist(thunderShock);
        em.persist(electroshock);
        em.persist(quickAttack);
        em.persist(vineWhip);
        em.persist(wingAttack);
        em.persist(bite);
        em.persist(fireFang);


        em.persist(vulpix);
        em.persist(pikachu);
        em.persist(squirtle);
        em.persist(magnemite);
        em.persist(rattata);
        em.persist(bulbasaur);
        em.persist(charizard);
        em.persist(arcanine);

        em.persist(fireGym);
        em.persist(waterGym);


        em.persist(kamil);
        em.persist(wojtek);
        em.persist(pawel);
        em.persist(brok);
        em.persist(ash);

        Connector.getInstance().endTransaction();
    }
}
