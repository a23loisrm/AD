package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.HashMap;
import java.util.Map;

public class DocumentoJpaManager {
    public static final String DOCUMENTO_H2 = "DocumentoH2";

    private static final Map<String, EntityManagerFactory> instances =new HashMap<>();

    public DocumentoJpaManager(){

    }

    private static boolean isEntityManagerFactoryClosed(String unidadPersistencia){
        return !instances.containsKey(unidadPersistencia) ||instances.get(unidadPersistencia) == null ||
                !instances.get(unidadPersistencia).isOpen();
    }

    public static EntityManagerFactory getEntityManagerFactory(String unidadPersistencia){
        if (isEntityManagerFactoryClosed(unidadPersistencia)){
            synchronized (DocumentoJpaManager.class){
                if (isEntityManagerFactoryClosed(unidadPersistencia)){
                    try{
                        instances.put(unidadPersistencia, Persistence.createEntityManagerFactory(unidadPersistencia));

                    }catch (Exception e){
                        System.out.println("Erro ó crear a unidade de persistencia " + unidadPersistencia +
                                ": " + e.getMessage());
                    }
                }
            }
        }
        return instances.get(unidadPersistencia);
    }

    public static EntityManager getEntityManager(String peristencia){
        return getEntityManagerFactory(peristencia).createEntityManager();
    }

    public static void close(String persistencia){
        if (instances.containsKey(persistencia)){
            instances.get(persistencia).close();
            instances.remove(persistencia);
        }
    }
}
