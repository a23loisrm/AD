package org.example.Gson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

public class ExamenAJson {
    private String materia;
    private Date fecha;
    private List<String> participantes;


    public ExamenAJson(String materia, Date fecha, List<String> participantes) {
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

    public List<String> getParticipantes() {
        return participantes;
    }

    public void setParticipantes(List<String> participantes) {
        this.participantes = participantes;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
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
/*
    public static void main(String[] args) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        List<String> lista = List.of("Concha Méndez", "Ernestina de Champourcin", "Josefina de la Torre", "Carmen Conde", "Rosa Chacel");
        Date fecha = Date.from(LocalDateTime.of(2023, 11, 12, 9, 45).atZone(ZoneId.systemDefault()).toInstant());
        ExamenAJson examen = new ExamenAJson("Acceso a datos", fecha, lista);

        String json = gson.toJson(examen);

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("accesoADatos.json"))) {
            bw.write(json);
            System.out.println(json);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

   */ }
