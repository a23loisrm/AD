package Tema_1.Boletin_01_03.Ejercicio9;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Examen {
    public String materia;
    public LocalDateTime fecha;
    public List<String> participantes;

    public Examen() {
    }

    public Examen(String materia, LocalDateTime fecha, List<String> participantes) {
        this.materia = materia;
        this.fecha = fecha;
        this.participantes = participantes;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public List<String> getParticipantes() {
        return participantes;
    }

    public void setParticipantes(List<String> participantes) {
        this.participantes = participantes;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Materia: ").append(materia).append("\n");
        sb.append("Fecha: ").append(fecha).append("\n");
        sb.append("Participantes: ").append(participantes).append("\n");
        return sb.toString();
    }
}
