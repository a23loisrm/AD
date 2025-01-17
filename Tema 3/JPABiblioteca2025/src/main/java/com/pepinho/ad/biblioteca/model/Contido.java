package com.pepinho.ad.biblioteca.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.io.Serializable;
import java.util.Objects;

/**
 * @autor pepecalo
 * CREATE TABLE PUBLIC.Contido (
 * 	idContido INTEGER NOT NULL AUTO_INCREMENT,
 * 	idBook INTEGER NOT NULL,
 * 	contido CHARACTER LARGE OBJECT,
 * 	CONSTRAINT Contido_PK PRIMARY KEY (idContido),
 * 	CONSTRAINT FK_ID_BOOK FOREIGN KEY (idBook) REFERENCES PUBLIC.Book(idBook) ON DELETE CASCADE ON UPDATE CASCADE
 * );
 * CREATE UNIQUE INDEX PRIMARY_KEY_9 ON PUBLIC.Contido (idContido);
 */

@Entity
public class Contido implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idContido;
    private String contido;
    private Book book;

    public Contido() {
    }

    public Contido(Long idBook, String contido) {
        this.contido = contido;
    }

    public Contido(Long idContido, Long idBook) {
        this.idContido = idContido;
    }

    public Contido(Long idContido, Long idBook, String contido) {
        this.idContido = idContido;
        this.contido = contido;
    }

    public Long getIdContido() {
        return idContido;
    }

    public void setIdContido(Long idContido) {
        this.idContido = idContido;
    }

    public Long getIdBook() {
        return book.getIdBook();
    }

    public void setIdBook(Long idBook) {
        this.book.setIdBook(idBook);
    }

    public String getContido() {
        return contido;
    }

    public void setContido(String contido) {
        this.contido = contido;
    }

    @Override
    public int hashCode() {
        return 97 * 7 + Objects.hashCode(this.idContido);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Contido other)) return false;
        return Objects.equals(this.idContido, other.idContido);
    }

    @Override
    public String toString() {
        return "Contido{" +
                "idContido=" + idContido +
                ", contido='" + contido + '\'' +
                '}';
    }
}
