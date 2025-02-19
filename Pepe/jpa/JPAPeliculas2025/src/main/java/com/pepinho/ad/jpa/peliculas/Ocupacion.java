package com.pepinho.ad.jpa.peliculas;

public class Ocupacion {

    private String ocupacion;
    private Integer orde;

    public Ocupacion() {
    }

    public Ocupacion(String ocupacion, Integer orde) {
        this.ocupacion = ocupacion;
        this.orde = orde;
    }

    public String getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }

    public Integer getOrde() {
        return orde;
    }

    public void setOrde(Integer orde) {
        this.orde = orde;
    }

    @Override
    public String toString() {
        return "[" + ocupacion + "] (" + orde + ')';
    }
}
