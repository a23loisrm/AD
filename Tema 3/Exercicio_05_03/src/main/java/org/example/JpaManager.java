package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.HashMap;
import java.util.Map;

public class JpaManager {

    public static final String EJERCICIO = "ejercicio_05_03";

    private static Map<String, EntityManagerFactory> instances = new HashMap<>();

    private JpaManager(){

    }

    private static boolean isEntityManagerFactoryClosed(String unidadPersistencia){
        return !instances.containsKey(unidadPersistencia) || instances.get(unidadPersistencia) == null ||
                !instances.get(unidadPersistencia).isOpen();
    }


    public static EntityManagerFactory getEntityManagerFactory(String unidadPersistencia){
        if (isEntityManagerFactoryClosed(unidadPersistencia)){
            synchronized (JpaManager.class){
                if (isEntityManagerFactoryClosed(unidadPersistencia)){
                    try{
                        instances.put(unidadPersistencia, Persistence.createEntityManagerFactory(unidadPersistencia));
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
        return instances.get(unidadPersistencia);
    }

    public static EntityManager getEntityManager(String persistenceUnitName){
        return getEntityManagerFactory(persistenceUnitName).createEntityManager();
    }

    public static void close(String persistenceUnitName){
        if (instances.containsKey(persistenceUnitName)){
            instances.get(persistenceUnitName).close();
            instances.remove(persistenceUnitName);
        }
    }
}