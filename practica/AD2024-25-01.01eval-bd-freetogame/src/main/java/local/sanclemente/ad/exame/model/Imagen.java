package local.sanclemente.ad.exame.model;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * CREATE TABLE PUBLIC.Imagen (
 * idImagen INTEGER NOT NULL AUTO_INCREMENT,
 * idJuego INTEGER NOT NULL,
 * url CHARACTER VARYING(512) NOT NULL,
 * imagen BINARY LARGE OBJECT,
 * CONSTRAINT idImagenPK PRIMARY KEY (idImagen),
 * CONSTRAINT idJuegoFK PRIMARY KEY (idJuego,idJuego)
 * );
 * CREATE UNIQUE INDEX PRIMARY_KEY_8 ON PUBLIC.Imagen (idImagen);
 * CREATE UNIQUE INDEX idImagenPKIdx ON PUBLIC.Imagen (idImagen);
 * CREATE INDEX idJuegoFK_INDEX_8 ON PUBLIC.Imagen (idJuego);
 * <p>
 * <p>
 * -- PUBLIC.Imagen foreign keys
 * <p>
 * ALTER TABLE PUBLIC.Imagen ADD CONSTRAINT idJuegoFK FOREI
 */

public class Imagen {

    private Long idImagen;

    private Juego juego;

    private String url;

    private byte[] imagen;

    public Imagen() {
    }

    public Imagen(Long idImagen, String url) {
        this.idImagen = idImagen;
        this.url = url;
    }

    public Imagen(Long idImagen, Juego juego, String url) {
        this.idImagen = idImagen;
        this.juego = juego;
        this.url = url;
    }

    public Imagen(Long idImagen, Juego juego, String url, byte[] imagen) {
        this.idImagen = idImagen;
        this.juego = juego;
        this.url = url;
        this.imagen = imagen;
    }

    public Imagen(Long idImagen, String url, byte[] imagen) {
        this.idImagen = idImagen;
        this.url = url;
        this.imagen = imagen;
    }

    public Imagen(Juego juego, String url, byte[] imagen) {
        this.juego = juego;
        this.url = url;
        this.imagen = imagen;
    }

    public Long getIdImagen() {
        return this.idImagen;
    }

    public void setIdImagen(Long idImagen) {
        this.idImagen = idImagen;
    }

    public Integer getIdJuego() {
        return (juego != null) ? this.juego.getIdJuego() : null;
    }

    public Juego getJuego() {
        return this.juego;
    }

    public void setJuego(Juego juego) {
        this.juego = juego;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        if (url.length() > 512) {
            throw new IllegalArgumentException("La url de la imagen no puede superar los 512 caracteres");
        }
        this.url = url;
        try (InputStream inputStream = new URI(url).toURL().openStream();
             ByteArrayOutputStream bos = new ByteArrayOutputStream();){
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                // Escribo en el buffer
                bos.write(buffer, 0, bytesRead);
            }
            // Convierto el buffer a un array de bytes
            this.imagen = bos.toByteArray();

        } catch (IOException e) {
            System.out.println("Error al leer la imagen = " + e.getMessage());
        } catch (URISyntaxException e) {
            System.out.println(" Error URL: " + e.getMessage());
        }

    }

    public byte[] getImagen() {
        return this.imagen;
    }

    public void setImagen(byte[] imagen) {
        this.imagen = imagen;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        return (o instanceof Imagen imagen) && idImagen == imagen.idImagen;
    }

    @Override
    public int hashCode() {
        return Long.hashCode(idImagen);
    }

    @Override
    public String toString() {
        return "{" +
                " ['" + getIdImagen() + "']" +
                ", juego = '" + getJuego().getTitulo() + "'" +
                ": '" + getUrl() + "'" +
                "}";
    }
}
