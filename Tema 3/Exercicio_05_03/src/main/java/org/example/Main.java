package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-hibernate-h2");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Persona persona1 = new Persona(1, "Juan", "Perez Garcia", LocalDate.of(1990, 1, 15), Sexo.HOMBRE, EstadoCivil.SOLTERO, new byte[]{1, 2, 3});
        em.persist(persona1);

        Persona persona2 = new Persona(2, "Maria", "Lopez Fernandez", LocalDate.of(1985, 5, 30), Sexo.MUJER, EstadoCivil.CASADO, new byte[]{4, 5, 6});
        em.persist(persona2);

        em.getTransaction().commit();


        em.close();
        emf.close();
    }

}