package org.example.Boletin_01_03;

import javax.json.Json;
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.json.bind.JsonbConfig;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public class Examen {
    public String materia;
    public LocalDateTime fecha;
    public List<String> participantes;

    public Examen(String materia, LocalDateTime fecha, List<String> participantes){
        this.materia = materia;
        this.fecha = fecha;
        this.participantes = participantes;
    }

    public List<String> getParticipantes() {
        return participantes;
    }

    public void setParticipantes(List<String> participantes) {
        this.participantes = participantes;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Materia: ").append(materia).append("\n");
        sb.append("Fecha: ").append(fecha).append("\n");
        sb.append("Participantes:\n");
        for (String participante : participantes) {
            sb.append(participante).append("\n");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        File file = new File("accesoADatos.json");
        List<String> p = List.of("Pepe", "Nicolas", "Laura", "Lucia");
        LocalDateTime fecha = LocalDateTime.of(2023,11,12,9,45);
        Examen examen = new Examen("Acceso a datos", fecha, p);

        JsonbConfig config = new JsonbConfig().withFormatting(true);
        Jsonb jsonb = JsonbBuilder.create(config);

        //Convertir el objeto Java a JSON
        String strJson = jsonb.toJson(examen);

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))){
            bw.write(strJson);
            if (file.exists()) {
                System.out.println("JSON escrito en el archivo");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}

