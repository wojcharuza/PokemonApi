package com.codecool;

import com.codecool.models.Move;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;


@SuppressWarnings("serial")
public class DatabasePopulator extends HttpServlet {

    public void init() throws ServletException {
        System.out.println("server started");
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaexamplePU");
        EntityManager em = emf.createEntityManager();
        Move move = new Move("electroshock", "prunt", 100);
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(move);
        transaction.commit();
        em.clear();
        em.close();
        emf.close();
    }


}
