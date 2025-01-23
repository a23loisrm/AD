package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.HashMap;
import java.util.Map;

public class JpaManager {

    public static final String BIBLIOTECA = "ejercicio_05_06";

    private static Map<String, EntityManagerFactory> instances = new HashMap<>();

    private JpaManager(){

    }

    private static boolean isEntityManagerFactoryClosed(String unidadPersistencia){
        return !instances.containsKey(unidadPersistencia) ||instances.get(unidadPersistencia) == null ||
                !instances.get(unidadPersistencia).isOpen();
    }

    private static EntityManagerFactory getEntityManagerFactory(String unidadPersistencia){
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

    public static EntityManager getEntityManager(String unidadPersistencia){
        return getEntityManagerFactory(unidadPersistencia).createEntityManager();
    }

    public void close(String unidadPersistencia){
        if (instances.containsKey(unidadPersistencia)){
            instances.get(unidadPersistencia);
            instances.remove(unidadPersistencia);
        }
    }

}
