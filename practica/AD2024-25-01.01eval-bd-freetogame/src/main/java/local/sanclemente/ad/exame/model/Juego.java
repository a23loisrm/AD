package local.sanclemente.ad.exame.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * CREATE TABLE PUBLIC.Juego (
 * idJuego INTEGER NOT NULL,
 * idGenero INTEGER NOT NULL,
 * idPlataforma INTEGER NOT NULL,
 * titulo CHARACTER VARYING(255) NOT NULL,
 * miniatura CHARACTER VARYING(256),
 * estado CHARACTER VARYING(64),
 * descripcionCorta CHARACTER VARYING(512),
 * descripcion CHARACTER VARYING(2000),
 * url CHARACTER VARYING(256),
 * editor CHARACTER VARYING(64),
 * desarrollador CHARACTER VARYING(64),
 * fecha DATE,
 * CONSTRAINT JUEGO_PK PRIMARY KEY (idJuego),
 * CONSTRAINT idGeneroFK PRIMARY KEY (idGenero,idGenero),
 * CONSTRAINT idPlataformaFK PRIMARY KEY (idPlataforma,idPlataforma)
 * );
 * CREATE UNIQUE INDEX PRIMARY_KEY_3 ON PUBLIC.Juego (idJuego);
 * CREATE INDEX idGeneroIdx ON PUBLIC.Juego (idGenero);
 * CREATE UNIQUE INDEX idJuego ON PUBLIC.Juego (idJuego);
 * CREATE INDEX idPlataformaIdx ON PUBLIC.Juego (idPlataforma);
 */
public class Juego {

    private int idJuego;
    private Genero genero;
    private Plataforma plataforma;
    private String titulo;
    private String miniatura;
    private String estado;
    private String descripcionCorta;
    private String descripcion;
    private String url;
    private String editor;
    private String desarrollador;
    private LocalDate fecha;
    private List<Imagen> imagenes;
    private RequisitosSistema requisitosSistema;

    public Juego() {
        imagenes = new ArrayList<>();
    }

    public Juego(int idJuego, Genero genero, Plataforma plataforma, String titulo, String miniatura, String estado, String descripcionCorta, String descripcion, String url, String editor, String desarrollador, LocalDate fecha) {
        this.idJuego = idJuego;
        this.genero = genero;
        this.plataforma = plataforma;
        this.titulo = titulo;
        this.miniatura = miniatura;
        this.estado = estado;
        this.descripcionCorta = descripcionCorta;
        this.descripcion = descripcion;
        this.url = url;
        this.editor = editor;
        this.desarrollador = desarrollador;
        this.fecha = fecha;
        imagenes = new ArrayList<>();
    }

    public Juego(Genero genero, Plataforma plataforma, String titulo, String miniatura, String estado, String descripcionCorta, String descripcion, String url, String editor, String desarrollador, LocalDate fecha, List<Imagen> imaxes) {
        this.genero = genero;
        this.plataforma = plataforma;
        this.titulo = titulo;
        this.miniatura = miniatura;
        this.estado = estado;
        this.descripcionCorta = descripcionCorta;
        this.descripcion = descripcion;
        this.url = url;
        this.editor = editor;
        this.desarrollador = desarrollador;
        this.fecha = fecha;
        this.imagenes = imaxes;
    }

    public Juego(int idJuego, Genero genero, Plataforma plataforma, String titulo, String miniatura, String estado, String descripcionCorta, String descripcion, String url, String editor, String desarrollador, LocalDate fecha, List<Imagen> imagenes, RequisitosSistema requisitosSistema) {
        this.idJuego = idJuego;
        this.genero = genero;
        this.plataforma = plataforma;
        this.titulo = titulo;
        this.miniatura = miniatura;
        this.estado = estado;
        this.descripcionCorta = descripcionCorta;
        this.descripcion = descripcion;
        this.url = url;
        this.editor = editor;
        this.desarrollador = desarrollador;
        this.fecha = fecha;
        this.imagenes = imagenes;
        this.requisitosSistema = requisitosSistema;
    }

    public int getIdJuego() {
        return this.idJuego;
    }

    public void setIdJuego(int idJuego) {
        this.idJuego = idJuego;
    }

    public Integer getIdGenero() {
        return (genero != null) ? this.genero.getIdGenero() : null;
    }

    public Genero getGenero() {
        return this.genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public Integer getIdPlataforma() {
        return (plataforma != null) ? this.plataforma.getIdPlataforma() : null;
    }

    public Plataforma getPlataforma() {
        return this.plataforma;
    }

    public void setPlataforma(Plataforma plataforma) {
        this.plataforma = plataforma;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public void setTitulo(String titulo) {
        if (titulo.length() > 255) {
            throw new IllegalArgumentException("El título del juego no puede superar los 255 caracteres");
        }
        this.titulo = titulo;
    }

    public String getMiniatura() {
        return this.miniatura;
    }

    public void setMiniatura(String miniatura) {
        if (miniatura.length() > 256) {
            throw new IllegalArgumentException("La miniatura del juego no puede superar los 256 caracteres");
        }
        this.miniatura = miniatura;
    }

    public String getEstado() {
        return this.estado;
    }

    public void setEstado(String estado) {
        if (estado.length() > 64) {
            throw new IllegalArgumentException("El estado del juego no puede superar los 64 caracteres");
        }
        this.estado = estado;
    }

    public String getDescripcionCorta() {
        return this.descripcionCorta;
    }

    public void setDescripcionCorta(String descripcionCorta) {
        if (descripcionCorta.length() > 512) {
            throw new IllegalArgumentException("La descripción corta del juego no puede superar los 512 caracteres");
        }
        this.descripcionCorta = descripcionCorta;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        if (descripcion.length() > 2000) {
            throw new IllegalArgumentException("La descripción del juego no puede superar los 2000 caracteres");
        }
        this.descripcion = descripcion;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        if (url.length() > 256) {
            throw new IllegalArgumentException("La url del juego no puede superar los 256 caracteres");
        }
        this.url = url;
    }

    public String getEditor() {
        return this.editor;
    }

    public void setEditor(String editor) {
        if (editor.length() > 64) {
            throw new IllegalArgumentException("El editor del juego no puede superar los 64 caracteres");
        }
        this.editor = editor;
    }

    public String getDesarrollador() {
        return this.desarrollador;
    }

    public void setDesarrollador(String desarrollador) {
        if (desarrollador.length() > 64) {
            throw new IllegalArgumentException("El desarrollador del juego no puede superar los 64 caracteres");
        }
        this.desarrollador = desarrollador;
    }

    public LocalDate getFecha() {
        return this.fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }


    public List<Imagen> getImagenes() {
        return this.imagenes;
    }

    public void setImagenes(List<Imagen> imagenes) {
        this.imagenes = imagenes;
    }


    public void addImagen(Imagen imagen) {
        if (imagen != null) {
            imagen.setJuego(this);
            this.imagenes.add(imagen);
        }
    }

    public void removeImagen(Imagen imagen) {
        if (imagenes != null)
            imagenes.remove(imagen);
    }

    public void clearImagenes() {
        if (imagenes != null)
            imagenes.clear();
    }

    public RequisitosSistema getRequisitosSistema() {
        return requisitosSistema;
    }

    public void setRequisitosSistema(RequisitosSistema requisitosSistema) {
        if(requisitosSistema == null) {
           if(this.requisitosSistema != null) {
               this.requisitosSistema.setJuego(null);
           }
        } else {
            requisitosSistema.setJuego(this);
        }
        this.requisitosSistema = requisitosSistema;
    }

    public String getImagenesByString() {
        StringBuilder sb = new StringBuilder(System.lineSeparator());
        for (Imagen imagen : imagenes) {
            sb.append("   ").append(imagen.getUrl()).append(System.lineSeparator());
        }
        return sb.toString();
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        return (o instanceof Juego juego) && idJuego == juego.idJuego;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idJuego);
    }

    @Override
    public String toString() {
        // En formato tabla, con un elemento por línea y con separación de 15 caracteres:
        return "*************************************************" + System.lineSeparator() +
                " idJuego: " + getIdJuego() + System.lineSeparator() +
                " Genero: " + genero +  System.lineSeparator() +
                " Plataforma: " + plataforma + System.lineSeparator() +
                " Título: '" + getTitulo() + "'" + System.lineSeparator() +
                " Miniatura; " + getMiniatura() + System.lineSeparator() +
                " Estado: " + getEstado() +  System.lineSeparator() +
                " Descripción corta: '" + getDescripcionCorta() + "'" + System.lineSeparator() +
                " Descripción: '" + getDescripcion().substring(0,16) + "...'" + System.lineSeparator() +
                " URL: " + getUrl() + "'" + System.lineSeparator() +
                " Editor: '" + getEditor() + "'" + System.lineSeparator() +
                " Desarrollador: " + getDesarrollador() + System.lineSeparator() +
                " Fecha: '" + getFecha() + "'" + System.lineSeparator() +
                " Imágenes: " + getImagenesByString() + System.lineSeparator() +
                " Requisitos del sistema: '" + ((requisitosSistema!=null) ? requisitosSistema : '-' + "'") + System.lineSeparator() +
                "*************************************************";
    }
}
