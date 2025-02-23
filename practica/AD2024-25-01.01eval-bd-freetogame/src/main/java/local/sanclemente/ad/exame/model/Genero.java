package local.sanclemente.ad.exame.model;

import java.util.Objects;

/**
 * CREATE TABLE PUBLIC.Genero (
 * idGenero INTEGER NOT NULL AUTO_INCREMENT,
 * nombre CHARACTER VARYING(128) NOT NULL,
 * CONSTRAINT GENERO_PK PRIMARY KEY (idGenero)
 * );
 * CREATE UNIQUE INDEX PRIMARY_KEY_7 ON PUBLIC.Genero (idGenero);
 * CREATE UNIQUE INDEX idGeneroPK ON PUBLIC.Genero (idGenero);
 */

public class Genero {

    private Integer idGenero;

    private String nombre;

    public Genero() {
    }

    public Genero(Integer idGenero) {
        this.idGenero = idGenero;
    }

    public Genero(Integer idGenero, String nombre) {
        this.idGenero = idGenero;
        this.nombre = nombre;
    }

    public Genero(String nombre) {
        this.nombre = nombre;
    }

    public Integer getIdGenero() {
        return this.idGenero;
    }

    public void setIdGenero(Integer idGenero) {
        this.idGenero = idGenero;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        if (nombre.length() > 128) {
            throw new IllegalArgumentException("El nombre del género no puede superar los 128 caracteres");
        }
        this.nombre = nombre;
    }


    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Genero genero)) return false;
        return genero.nombre.equalsIgnoreCase(nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre);
    }

    @Override
    public String toString() {
        return " [" + idGenero + "] " + nombre;
    }
}
