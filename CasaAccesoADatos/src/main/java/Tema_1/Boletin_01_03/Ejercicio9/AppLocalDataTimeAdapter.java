package Tema_1.Boletin_01_03.Ejercicio9;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.Arrays;

public class AppLocalDataTimeAdapter {
    public static void main(String[] args) throws IOException {
        // Crear un objeto Examen
        Examen examen = new Examen(
                "Acceso a Datos",
                LocalDateTime.of(2023, 11, 12, 9, 45),
                Arrays.asList("Gabriela Mistral", "Alfonsina Storni", "Sylvia Plath", "Anne Sexton", "Rosario Castellanos")
        );

        Gson gson = new GsonBuilder()
                .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapter())
                .setPrettyPrinting()
                .create();

        Path path = Paths.get("accesoADatosEjercicio9.json");

        String gsonContenido = gson.toJson(examen);
        Files.write(path, gsonContenido.getBytes());
        System.out.println("Archivo JSON creado:\n" + gsonContenido);

        String leerJson = Files.readString(path);
        Examen examenLeer = gson.fromJson(leerJson, Examen.class);
        System.out.println("Objeto recuperado del archivo JSON:");
        System.out.println(examenLeer);

    }

}
