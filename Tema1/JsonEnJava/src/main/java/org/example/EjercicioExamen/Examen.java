package org.example.EjercicioExamen;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.time.LocalDateTime;
import java.util.List;

public class Examen {
    public String materia;
    public LocalDateTime fecha;
    public List<String> participantes;

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
        return "Examen{" +
                "materia='" + materia + '\'' +
                ", fecha=" + fecha +
                ", participantes=" + participantes +
                '}';
    }

    public static void main(String[] args) {
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();

        Examen examen = new Examen("Matemáticas", LocalDateTime.now(), List.of("Juan", "Pedro", "María"));
        String json = gson.toJson(examen);
        System.out.println(json);
    }
}
