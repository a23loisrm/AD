package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import org.example.entities.Pelicula;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Pelicula pelicula = new Pelicula("Titanic", (short) 1997);
        Pelicula pelicula2 = new Pelicula("Avatar", (short) 2009);
        Pelicula pelicula3 = new Pelicula("Terminator", (short) 1984);



        //var emf = Persistence.createEntityManagerFactory("jpa-hibernate-h2");//El nombre es el que se encuentra en el archivo persistence.xml
        //EntityManager em = emf.createEntityManager();
        EntityManager em = EntityManagerUtil.getEntityManager();


        em.getTransaction().begin(); //Iniciamos la transacción
        em.persist(pelicula); //Guardamos el objeto en la base de datos
        em.persist(pelicula2); //Guardamos el objeto en la base de datos
        em.persist(pelicula3); //Guardamos el objeto en la base de datos
        em.getTransaction().commit(); //Confirmamos la transacción

        EntityManagerUtil.shutdown();




    }
}