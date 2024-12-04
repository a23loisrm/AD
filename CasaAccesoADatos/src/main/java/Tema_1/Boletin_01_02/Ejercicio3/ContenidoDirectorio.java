package Tema_1.Boletin_01_02.Ejercicio3;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 *a) Escribid un programa en Java que, empleando las clases de Java NIO 2, liste los
 * archivos de un directorio por medio del método list(). Debe mostrar sólo los
 * archivos fuente Java, no los directorios que contiene. Recuerda el uso de filtros en
 * Stream y de forEach.
 * b) Haz el mismo ejercicio con el método list() de File y compara el tiempo de
 * ejecución en cada caso.
 */

public class ContenidoDirectorio {

    public static void listarContenido(Path directorio) throws IOException {
        try(Stream<Path> s = Files.list(directorio)){
            s.filter(Files::isRegularFile) //Verificar que es un archivo regualr
                    .filter(path -> path.toString().endsWith(".java"))
                    .forEach(System.out::println);

        }
    }

    public static void listarContenidoList(File directorio) throws IOException {
        File[] archivos = directorio.listFiles(file -> file.isFile() && file.getName().endsWith(".java"));
        if (archivos != null) {
            for (File archivo : archivos) {
                System.out.println(archivo.getAbsolutePath());
            }
        }
    }


    public static void main(String[] args) {
        Path diretorio = Paths.get("C:\\Users\\loisr\\Documents\\AD\\CasaAccesoADatos\\src\\main\\java\\Tema_1\\Boletin_01_02\\Ejercicio3");
        File fileDirectorio = diretorio.toFile();

        try {
            long inicioPath = System.nanoTime();
            listarContenido(diretorio);
            long finPath = System.nanoTime();
            System.out.println("Tiempo con Path: " + (finPath - inicioPath) + " nanosegundos");


            long inicioFile = System.nanoTime();
            listarContenidoList(fileDirectorio);
            long finFile = System.nanoTime();
            System.out.println("Tiempo con File: " + (finFile - inicioFile) + " nanosegundos");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
