package ExamenAñoPasado.Ejercicio1;

import org.jsoup.select.Collector;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class AppArchivosJava {


    public static List<Path> listDirectories(Path directorio) {
        //Primero comprobamos que la ruta sea un direcotrio
        if (!Files.isDirectory(directorio)) {
            System.out.println("La ruta " + directorio + " no es un directorio");
        }
        try (Stream<Path> lista = Files.list(directorio)) {
            return lista.filter(Files::isRegularFile).collect(Collectors.toList());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public static List<Path> findByFileExtension(Path pathDirectorio, String fileExtension) {
        try (Stream<Path> lista = Files.walk(pathDirectorio)) {
            return lista.filter(Files::isRegularFile)  // Filtramos solo archivos regulares
                    .filter(p -> p.toString().endsWith(fileExtension))  // Filtramos por extensión
                    .collect(Collectors.toList());  // Convertimos el Stream en una lista
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void createFile(Path pathDirectorio, List<Path> archivos, String nombreArchivo) {
        Path destino = pathDirectorio.resolve(nombreArchivo);

        try (BufferedWriter bw = Files.newBufferedWriter(destino, StandardOpenOption.CREATE)) {
            // Recorremos cada archivo y copiamos su contenido al archivo destino
            for (Path archivo : archivos) {
                try (BufferedReader reader = Files.newBufferedReader(archivo)) {
                    String linea;
                    while ((linea = reader.readLine()) != null) {
                        bw.write(linea);
                        bw.newLine();  // Escribimos una nueva línea después de cada línea del archivo
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
