package org.example;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

public class Clasificacion implements Serializable {
    private Set<Equipo> equipos;
    private String competicion;

    public Clasificacion() {
        this.equipos = new TreeSet<>();
    }

    public Clasificacion(String competicion) {
        this.equipos = new TreeSet<>();
        this.competicion = competicion;
    }

    public Set<Equipo> getEquipos() {
        return equipos;
    }

    public String getCompeticion() {
        return competicion;
    }

    public void setCompeticion(String competicion) {
        this.competicion = competicion;
    }

    public void addEquipo(Equipo equipo) {
        equipos.add(equipo);
    }

    public void removeEquipo(Equipo equipo) {
        equipos.remove(equipo);
    }

    @Override
    public boolean equals(Object o) {
        return this == o || ((o instanceof Clasificacion that) && Objects.equals(competicion, that.competicion));
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(competicion);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Competición: ").append(competicion).append("\n");
        for (Equipo equipo : equipos) {
            sb.append("Equipo: ").append(equipo.getNombre()).append("\n")
                    .append("Partidos: ").append(equipo.getPartidos()).append("\n")
                    .append("Victorias: ").append(equipo.getVictorias()).append("\n")
                    .append("Derrotas: ").append(equipo.getDerrotas()).append("\n")
                    .append("Puntos a favor: ").append(equipo.getPuntosAfavor()).append("\n")
                    .append("Puntos en contra: ").append(equipo.getPuntosEnContra()).append("\n")
                    .append("\n");
        }
        return sb.toString();
    }
}