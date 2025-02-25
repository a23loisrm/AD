package local.sanclemente.ad.exame.model;

public class RequisitosSistema {

    private Integer idJuego;
    private String sistemaOperativo;
    private String procesador;

    private String memoria;

    private String graficos;

    private String almacenamiento;

    private Juego juego;

    public RequisitosSistema() {
    }

    public RequisitosSistema(String sistemaOperativo, String procesador, String memoria, String graficos, String almacenamiento) {
        this.sistemaOperativo = sistemaOperativo;
        this.procesador = procesador;
        this.memoria = memoria;
        this.graficos = graficos;
        this.almacenamiento = almacenamiento;
    }

    public RequisitosSistema(Integer idJuego, String sistemaOperativo, String procesador, String memoria, String graficos, String almacenamiento) {
        this.idJuego = idJuego;
        this.sistemaOperativo = sistemaOperativo;
        this.procesador = procesador;
        this.memoria = memoria;
        this.graficos = graficos;
        this.almacenamiento = almacenamiento;
    }

    public String getSistemaOperativo() {
        return sistemaOperativo;
    }

    public void setSistemaOperativo(String sistemaOperativo) {
        this.sistemaOperativo = sistemaOperativo;
    }

    public String getProcesador() {
        return procesador;
    }

    public void setProcesador(String procesador) {
        this.procesador = procesador;
    }

    public String getMemoria() {
        return memoria;
    }

    public void setMemoria(String memoria) {
        this.memoria = memoria;
    }

    public String getGraficos() {
        return graficos;
    }

    public void setGraficos(String graficos) {
        this.graficos = graficos;
    }

    public String getAlmacenamiento() {
        return almacenamiento;
    }

    public void setAlmacenamiento(String almacenamiento) {
        this.almacenamiento = almacenamiento;
    }

    public Integer getIdJuego() {
        return idJuego;
    }

    public void setIdJuego(Integer idJuego) {
        this.idJuego = idJuego;
    }

    public Juego getJuego() {
        return juego;
    }

    public void setJuego(Juego juego) {
        this.juego = juego;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RequisitosSistema)) return false;
        RequisitosSistema requisitosSistema = (RequisitosSistema) o;
        return sistemaOperativo.equals(requisitosSistema.sistemaOperativo) &&
                procesador.equals(requisitosSistema.procesador) &&
                memoria.equals(requisitosSistema.memoria) &&
                graficos.equals(requisitosSistema.graficos) &&
                almacenamiento.equals(requisitosSistema.almacenamiento);
    }

    @Override
    public int hashCode() {
        return sistemaOperativo.hashCode() + procesador.hashCode() + memoria.hashCode() + graficos.hashCode() + almacenamiento.hashCode();
    }

    @Override
    public String toString() {
        return String.format("[%d] %s %s %s %s", idJuego, procesador, memoria, graficos, almacenamiento);
    }

}
