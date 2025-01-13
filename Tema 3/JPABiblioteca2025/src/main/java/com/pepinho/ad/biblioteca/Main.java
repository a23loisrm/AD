package com.pepinho.ad.biblioteca;

import com.pepinho.ad.biblioteca.model.BibliotecaJpaManager;
import com.pepinho.ad.biblioteca.model.Book;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

public class Main {


    public static void main(String[] args) {
        EntityManagerFactory emf = BibliotecaJpaManager.getEntityManagerFactory(BibliotecaJpaManager.BIBLIOTECA_H2);

        EntityManager em = emf.createEntityManager();

        var lista = em.createQuery("Select b from Book b").getResultList();

        var libro = em.find(Book.class, 1L);

        System.out.println(libro);

        System.out.println("Funciona");
    }


}
