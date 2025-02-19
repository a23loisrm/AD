package com.pepinho.ad.jpa.peliculas;

public class Pelicula {
    private Long idPelicula;
    private String musica;
    private String orixinal;
    private String ingles;
    private String castelan;
    private String xenero;
    private Short anoInicio;
    private Short anoFin;
    private String pais;
    private Short duracion;
    private String outrasDuracions;
    private String cor;
    private String son;
    private String video;
    private String texto;
    private byte[] poster;
    private String revisado;

    public Pelicula() {
    }

    public Pelicula(Long idPelicula, String musica, String orixinal, String ingles, String castelan, String xenero, Short anoInicio, Short anoFin, String pais, Short duracion, String outrasDuracions, String cor, String son, String video, String texto, byte[] poster, String revisado) {
        this.idPelicula = idPelicula;
        this.musica = musica;
        this.orixinal = orixinal;
        this.ingles = ingles;
        this.castelan = castelan;
        this.xenero = xenero;
        this.anoInicio = anoInicio;
        this.anoFin = anoFin;
        this.pais = pais;
        this.duracion = duracion;
        this.outrasDuracions = outrasDuracions;
        this.cor = cor;
        this.son = son;
        this.video = video;
        this.texto = texto;
        this.poster = poster;
        this.revisado = revisado;
    }

    public Long getIdPelicula() {
        return idPelicula;
    }

    public void setIdPelicula(Long idPelicula) {
        this.idPelicula = idPelicula;
    }

    public String getMusica() {
        return musica;
    }

    public void setMusica(String musica) {
        this.musica = musica;
    }

    public String getOrixinal() {
        return orixinal;
    }

    public void setOrixinal(String orixinal) {
        this.orixinal = orixinal;
    }

    public String getIngles() {
        return ingles;
    }

    public void setIngles(String ingles) {
        this.ingles = ingles;
    }

    public String getCastelan() {
        return castelan;
    }

    public void setCastelan(String castelan) {
        this.castelan = castelan;
    }

    public String getXenero() {
        return xenero;
    }

    public void setXenero(String xenero) {
        this.xenero = xenero;
    }

    public Short getAnoInicio() {
        return anoInicio;
    }

    public void setAnoInicio(Short anoInicio) {
        this.anoInicio = anoInicio;
    }

    public Short getAnoFin() {
        return anoFin;
    }

    public void setAnoFin(Short anoFin) {
        this.anoFin = anoFin;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public Short getDuracion() {
        return duracion;
    }

    public void setDuracion(Short duracion) {
        this.duracion = duracion;
    }

    public String getOutrasDuracions() {
        return outrasDuracions;
    }

    public void setOutrasDuracions(String outrasDuracions) {
        this.outrasDuracions = outrasDuracions;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getSon() {
        return son;
    }

    public void setSon(String son) {
        this.son = son;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public byte[] getPoster() {
        return poster;
    }

    public void setPoster(byte[] poster) {
        this.poster = poster;
    }

    public String getRevisado() {
        return revisado;
    }

    public void setRevisado(String revisado) {
        this.revisado = revisado;
    }

    @Override
    public String toString() {
        return  "[" + idPelicula +
                "] " + castelan +
                ", ('" + orixinal + ')' +
                " (" + xenero +
                " de " + anoFin + "), '" + pais + '\'' +
                " " + duracion +
                " minutos. " + System.lineSeparator();
    }
}
