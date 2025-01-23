package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        EntityManagerFactory emf = JpaManager.getEntityManagerFactory(JpaManager.EJERCICIO);
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Persona persona = new Persona(0, "Juan", "Perez", LocalDate.of(1990, 1, 1), Sexo.HOMBRE, EstadoCivil.SOLTERO, null);
        em.persist(persona);

        em.getTransaction().commit();


        em.close();
        emf.close();
    }

}