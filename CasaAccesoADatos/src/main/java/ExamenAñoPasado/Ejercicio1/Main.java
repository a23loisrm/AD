package ExamenAñoPasado.Ejercicio1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

import static ExamenAñoPasado.Ejercicio1.AppArchivosJava.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Pedimos la ruta al directorio
        System.out.print("Introduce la ruta al directorio: ");
        String ruta = scanner.nextLine();
        Path pathDirectorio = Paths.get(ruta);

        try {
            // Comprobamos que es un directorio
            if (!Files.isDirectory(pathDirectorio)) {
                throw new IllegalArgumentException("La ruta proporcionada no es un directorio.");
            }

            // Listamos todos los subdirectorios
            List<Path> subdirectorios = listDirectories(pathDirectorio);

            // Procesamos cada subdirectorio
            for (Path subdirectorio : subdirectorios) {
                // Encontramos todos los archivos .java en el subdirectorio
                List<Path> archivosJava = findByFileExtension(subdirectorio, ".java");

                // Creamos el archivo .java con el nombre del directorio
                String nombreArchivo = subdirectorio.getFileName().toString() + ".java";
                createFile(pathDirectorio, archivosJava, nombreArchivo);

                System.out.println("Archivo " + nombreArchivo + " creado con éxito.");
            }

        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}
