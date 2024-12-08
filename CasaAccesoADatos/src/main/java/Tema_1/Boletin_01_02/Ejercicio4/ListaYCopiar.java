package Tema_1.Boletin_01_02.Ejercicio4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;
import java.util.stream.Stream;

/**
 * Escribid un programa en Java que, empleando las clases de Java NIO 2, liste los
 * contenidos copiando cada archivo a una ruta destino. Pidiendo la extensión del archivo
 * a copiar. Resuelve previamente el fichero origen.
 */


public class ListaYCopiar {



    public static void listarContenido(Path origen) throws IOException {
        try(Stream<Path> s = Files.list(origen)){
            s.filter(Files::isRegularFile) //Verificar que es un archivo regualr
                    .forEach(path -> System.out.println("- "+path.getFileName()));

        }
    }

    public static void copiarArchivo(Path origen, Path destino, String extension) throws IOException {
        try (Stream<Path> stream = Files.list(origen)) {
            stream.filter(Files::isRegularFile) // Filtra archivos regulares
                    .filter(path -> path.toString().endsWith(extension)) // Filtra por extensión
                    .forEach(path -> {
                        try {
                            Path destinoFinal = destino.resolve(path.getFileName());
                            Files.copy(path, destinoFinal, StandardCopyOption.REPLACE_EXISTING);
                            System.out.println("Copiado: " + path.getFileName());
                        } catch (IOException e) {
                            System.err.println("Error al copiar " + path.getFileName() + ": " + e.getMessage());
                        }
                    });
        }
    }

    public static void main(String[] args) throws IOException {
        Path rutaOrigen = Paths.get("C:\\Users\\loisr\\Documents\\AD\\CasaAccesoADatos\\src\\main\\java\\Tema_1\\Boletin_01_02\\Ejercicio3");
        Path rutaDestino = Paths.get("C:\\Users\\loisr\\Documents\\AD\\CasaAccesoADatos\\src\\main\\java\\Tema_1\\Boletin_01_02\\RutaDestino");

        listarContenido(rutaOrigen);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce la extensión a copiar: ");
        String extension = scanner.nextLine();
        copiarArchivo(rutaOrigen, rutaDestino, extension);
    }
}
