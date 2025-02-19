package org.example;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;


/*
Crea una entidad Documento que tenga un campo de texto grande (CLOB) para el contenido del documento y un campo de bytes grande (BLOB)
para la imagen del documento. Haz pruebas con tres gestores de bases de datos: H2, SQLite y PostgreSQL y comprueba el
resultado creando la tabla en cada uno de ellos, con y sin declaración de tipo de LOB.


@Entity
public class Documento {
    @Id
    private long id;
    @Lob
    private String contenido;
    @Lob
    private byte[] imagen;
    // ...
}
 */

@Entity
public class Documento {

    @Id
    private long id;
    @Lob
    private String contenido;
    @Lob
    private byte[] imagen;

    public Documento() {
    }

    public Documento(long id, String contenido, byte[] imagen) {
        this.id = id;
        this.contenido = contenido;
        this.imagen = imagen;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public byte[] getImagen() {
        return imagen;
    }

    public void setImagen(byte[] imagen) {
        this.imagen = imagen;
    }

    @Override
    public String toString() {
        return "Documento{" + "id=" + id + ", contenido=" + contenido + ", imagen=" + imagen + '}';
    }
}
