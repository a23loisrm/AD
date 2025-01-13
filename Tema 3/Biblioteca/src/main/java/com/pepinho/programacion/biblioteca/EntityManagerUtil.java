package com.pepinho.programacion.biblioteca;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerUtil {
    private static final EntityManagerFactory ENTITY_MANAGER_FACTORY =
            Persistence.createEntityManagerFactory("biblioteca");

    private static final String UNIDAD_PERSISTENCIA = "biblioteca";

    private static EntityManagerUtil bibliotecaJpaManager;

    public static EntityManagerFactory ENTITY_MANAGER_FACTORY



    public static EntityManager getEntityManager(){
        return ENTITY_MANAGER_FACTORY.createEntityManager();
    }

    public static void shutdown(){
        ENTITY_MANAGER_FACTORY.close();
    }
}
