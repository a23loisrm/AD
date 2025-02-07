package org.example.controller;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.HashMap;
import java.util.Map;

public class JpaNbaManager {

    private static final String ejercicio = "NBA";

    private static Map<String, EntityManagerFactory> instance = new HashMap<>();

    public JpaNbaManager() {
    }

    private static boolean isEntityManagerFactory(String unidadDePersistencia){
        return !instance.containsKey(unidadDePersistencia) || instance.get(unidadDePersistencia) == null
                || !instance.get(unidadDePersistencia).isOpen();
    }

    public static EntityManagerFactory getEntityManagerFactory(String unidadDePersistencia){
        if (isEntityManagerFactory(unidadDePersistencia)){
            synchronized (JpaNbaManager.class){
                if (isEntityManagerFactory(unidadDePersistencia)){
                    try{
                        instance.put(unidadDePersistencia, Persistence.createEntityManagerFactory(unidadDePersistencia));
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
        return instance.get(unidadDePersistencia);
    }


    public static EntityManager getEntityManger(String unidadDePersistencia){
        return getEntityManagerFactory(unidadDePersistencia).createEntityManager();
    }

    public static void close(String unidadDePersistencia){
        if (instance.containsKey(unidadDePersistencia)){
            instance.get(unidadDePersistencia).close();
            instance.remove(unidadDePersistencia);
        }
    }
}
