package local.sanclemente.ad.exame.model;

import java.util.Objects;

/**
 * CREATE TABLE PUBLIC.Plataforma (
 * 	idPlataforma INTEGER NOT NULL AUTO_INCREMENT,
 * 	nombre CHARACTER VARYING(128) NOT NULL,
 * 	CONSTRAINT PLATAFORMA_PK PRIMARY KEY (idPlataforma)
 * );
 * CREATE UNIQUE INDEX PRIMARY_KEY_E ON PUBLIC.Plataforma (idPlataforma);
 * CREATE UNIQUE INDEX idPlataformaPK ON PUBLIC.Plataforma (idPlataforma);
 */
public class Plataforma {

    private Integer idPlataforma;

    private String nombre;

    public Plataforma() {
    }

    public Plataforma(int idPlataforma, String nombre) {
        this.idPlataforma = idPlataforma;
        this.nombre = nombre;
    }

    public Plataforma(String nombre) {
        this.nombre = nombre;
    }

    public Plataforma(Integer idPlataforma) {
        this.idPlataforma = idPlataforma;
    }

    public Integer getIdPlataforma() {
        return this.idPlataforma;
    }

    public void setIdPlataforma(Integer idPlataforma) {
        this.idPlataforma = idPlataforma;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        if (nombre.length() > 128) {
            throw new IllegalArgumentException("El nombre de la plataforma no puede superar los 128 caracteres");
        }
        this.nombre = nombre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        return (o instanceof Plataforma plataforma) && nombre.equalsIgnoreCase(plataforma.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre);
    }

    @Override
    public String toString() {
        return String.format("[%d] %-10s", idPlataforma, nombre);
    }

}
