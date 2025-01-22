package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        EntityManagerFactory emf = DocumentoJpaManager.getEntityManagerFactory(DocumentoJpaManager.DOCUMENTO_H2);
        EntityManager em = emf.createEntityManager();

    }
}