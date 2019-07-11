package com.codecool.DatabasePopulators;

import com.codecool.DatabaseConnector.Connector;
import com.codecool.models.Move;
import com.codecool.models.Pokemon;
import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import java.util.Arrays;
import java.util.List;


@SuppressWarnings("serial")
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
        Move thunderShock = new Move("thunderShock", "electric", 21);



        List<Move> pikachuMoves = Arrays.asList(electroshock, quickAttack);
        List<Move> squirtleMoves = Arrays.asList(tackle, bubble);
        List<Move>  magnemiteMoves = Arrays.asList(spark, thunderShock);
        List<Move> rattataMoves = Arrays.asList(quickAttack, tackle);

        Pokemon pikachu = new Pokemon("pikachu", "electric", pikachuMoves, "raichu", 25, "100", "300");
        Pokemon squirtle = new Pokemon("squirtle", "water", squirtleMoves, "wartortle", 7, "40", "10");
        Pokemon magnemite = new Pokemon("magnemite", "electric", magnemiteMoves, "magneton", 82, "100", "100");
        Pokemon rattata = new Pokemon("rattata", "normal", rattataMoves, "raticate", 19, "10", "20");



        EntityManager em = Connector.getInstance().startTransaction();
        em.persist(pikachu);
        em.persist(squirtle);
        em.persist(magnemite);
        em.persist(rattata);
        Connector.getInstance().endTransaction();
    }
}
