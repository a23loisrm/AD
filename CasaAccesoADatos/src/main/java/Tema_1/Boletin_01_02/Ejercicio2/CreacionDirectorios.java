package Tema_1.Boletin_01_02.Ejercicio2;


/**
 * Escribir un programa en Java que, empleando las clases de Java NIO 2 Path y
 * File, cree un directorio (con toda la tura) y un archivo vacío dentro de ese directorio.
 */

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CreacionDirectorios {

    public static void main(String[] args) {
        Path directorio = Paths.get("/media/a23loisrm/a23loisrm_documentos/AccesoADatos/AD/CasaAccesoADatos");

        // Define la ruta del archivo vacío dentro del directorio
        Path archivo = directorio.resolve("archivoVacio.txt");

        try {
            Files.createDirectories(directorio);
            System.out.println("Directorio creado en: " + directorio);

            Files.createFile(archivo);
            System.out.println("Archivo vacío creado en: " + archivo);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
