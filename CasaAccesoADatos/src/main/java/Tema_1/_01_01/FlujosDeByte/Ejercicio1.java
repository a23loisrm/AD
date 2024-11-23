package Tema_1._01_01.FlujosDeByte;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *

 Modifica el programa CopiaArchivos para que copie el archivo otto.txt en un archivo nohaycole.txt en la carpeta src/main/resources de tu proyecto.

 Además, haz que el cierre de archivos se realice por medio de try-with-resources.

 */

import java.nio.file.Paths;

public class Ejercicio1 {
    public static void main(String[] args) {
        // Definimos las rutas del archivo de entrada y salida
        String inputPath = "otto.txt";  // Supone que está en la raíz del proyecto
        String outputPath = Paths.get("src", "main", "resources", "nohaycole.txt").toString();

        // Uso de try-with-resources para asegurar el cierre automático de los flujos
        try (FileInputStream in = new FileInputStream(inputPath);
             FileOutputStream out = new FileOutputStream(outputPath)) {

            int c;
            // Bucle para leer y escribir cada byte del archivo
            while ((c = in.read()) != -1) {
                out.write(c);
            }

            System.out.println("Archivo copiado exitosamente en: " + outputPath);

        } catch (IOException e) {
            System.out.println("Ocurrió un error durante la copia del archivo: " + e.getMessage());
        }
    }
}

