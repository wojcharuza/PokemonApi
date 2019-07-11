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

        Move electroshock = new Move("electroshock", "electric", 100);
        Move waterfall = new Move("waterfall", "water", 30);
        Move normal = new Move("normal", "normal", 10);

        List<Move> pikachuMoves = Arrays.asList(electroshock, normal);
        List<Move> squirtleMoves = Arrays.asList(waterfall, normal);

        Pokemon pikachu = new Pokemon("pikachu", "electric", pikachuMoves, "raichu", 25, "100", "300");
        Pokemon squirtle = new Pokemon("squirtle", "water", squirtleMoves, "niepamietam", 4, "40", "10");

        EntityManager em = Connector.getInstance().startTransaction();
        em.persist(pikachu);
        em.persist(squirtle);
        Connector.getInstance().endTransaction();
    }
}
