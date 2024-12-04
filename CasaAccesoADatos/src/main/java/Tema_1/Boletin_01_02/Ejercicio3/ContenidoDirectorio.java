package Tema_1.Boletin_01_02.Ejercicio3;

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


    public static void main(String[] args) {
        Path diretorio = Paths.get("/media/a23loisrm/a23loisrm_documentos/AccesoADatos/AD/CasaAccesoADatos/src/main/java/Tema_1/Boletin_01_02/Ejercicio3");

        try {
            listarContenido(diretorio);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
