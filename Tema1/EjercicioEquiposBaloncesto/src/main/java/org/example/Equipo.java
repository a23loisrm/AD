package org.example;

import java.io.Serializable;
import java.util.Objects;

public class Equipo implements Comparable<Equipo>, Serializable {
    public String nombre;
    public int partidos;
    public int victorias;
    public int derrotas;
    public int puntosAfavor;
    public int puntosEnContra;
    public String cidade;


    public Equipo(String nombre){
        this.nombre = nombre;
    }

    public Equipo(String nombre, int partidos, int victorias, int derrotas, int puntosAfavor,
                  int puntosEnContra){
        this.nombre = nombre;
        this.partidos = partidos;
        this.victorias = victorias;
        this.derrotas =  derrotas;
        this.puntosAfavor = puntosAfavor;
        this.puntosEnContra = puntosEnContra;
    }

    public int getpartidosJugados(){
        return victorias + derrotas;
    }

    public int getDiferenciaDePuntos(){
        return puntosAfavor-puntosEnContra;
    }

    public int getPuntos(){
        return (victorias*2) + derrotas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPartidos() {
        return partidos;
    }

    public void setPartidos(int partidos) {
        this.partidos = partidos;
    }

    public int getDerrotas() {
        return derrotas;
    }

    public void setDerrotas(int derrotas) {
        this.derrotas = derrotas;
    }

    public int getPuntosAfavor() {
        return puntosAfavor;
    }

    public void setPuntosAfavor(int puntosAfavor) {
        this.puntosAfavor = puntosAfavor;
    }

    public int getPuntosEnContra() {
        return puntosEnContra;
    }

    public void setPuntosEnContra(int puntosEnContra) {
        this.puntosEnContra = puntosEnContra;
    }

    public int getVictorias() {
        return victorias;
    }

    public void setVictorias(int victorias) {
        this.victorias = victorias;
    }

    public String getCidade(){
        return cidade;
    }

    public void setCidade(String cidade){
        this.cidade = cidade;
    }


    @Override
    public int compareTo(Equipo equipo) {
        if (equipo == null) {
            throw new IllegalArgumentException("Non podes pasar nulos");
        }
        if (equipo.getNombre().equalsIgnoreCase(nombre)) {
            return 0;
        }
        if (equipo.getVictorias() == victorias) {
            return equipo.getDiferenciaDePuntos() - getDiferenciaDePuntos();
        }
        return equipo.getVictorias() - victorias;
//        // Ordenación por nombre:
//        return nome.compareToIgnoreCase(equipo.getNome());
    }

    @Override
    public boolean equals(Object obj) {
        return this == obj || (obj instanceof Equipo e && this.nombre.equalsIgnoreCase(e.nombre));
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.nombre);
        return hash;
    }
}
