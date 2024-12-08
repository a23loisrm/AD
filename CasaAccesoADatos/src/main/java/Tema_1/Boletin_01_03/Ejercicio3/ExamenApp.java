package Tema_1.Boletin_01_03.Ejercicio3;

import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ExamenApp {
    public static void main(String[] args) throws IOException {

        // Crear un objeto Examen
        Examen examen = new Examen(
                "Acceso a Datos",
                LocalDateTime.of(2023, 11, 12, 9, 45),
                Arrays.asList("Gabriela Mistral", "Alfonsina Storni", "Sylvia Plath", "Anne Sexton", "Rosario Castellanos")
        );

        // Serializar el examen a JSON y guardarlo en un archivo
        Jsonb jsonb = JsonbBuilder.create();
        Path rutaGuardar = Paths.get("src/main/resources/accesoADatos.json");

        String jsonContenido = jsonb.toJson(examen);
        Files.write(rutaGuardar, jsonContenido.getBytes());
        System.out.println("Archivo JSON creado:\n" + jsonContenido);


        //Leer el archivo json y deseraializarlo
        String leerJson = Files.readString(rutaGuardar);
        Examen examenLeer = jsonb.fromJson(leerJson, Examen.class);
        System.out.println("Objeto recuperado del archivo JSON:");
        System.out.println(examenLeer);

    }
}
