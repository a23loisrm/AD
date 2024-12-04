package Tema_1.Boletin_01_02.Ejercicio1;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/**
 * Realiza los siguientes programas Java empleando las clases Path, Paths y Files
 * de Java NIO:
 * a) Escribe un programa Java que compruebe si una ruta de archivo es absoluta o
 * relativa y si existe.
 * b) Escribe un programa Java que copie un archivo en otro, sustituyéndolo si existe, y
 * lo mueva un archivo de una ubicación en otra, empleando Files.
 * c) Crea un programa Java que recoja una ruta de archivo como entrada del usuario
 * (con JFileChooser) y muestre el nombre del archivo y su extensión en una ventana
 * emergente (JOptionPane). Crea un Path y recupera la posición a partir del nombre
 * del archivo (emplea el método lastIndexOf).
 */


public class Comprobar {

    public static void comprobarRuta(Path ruta) throws IOException {
        if (Files.exists(ruta)){
            //Determinar que la ruta es absoluta o relativa
            if (ruta.isAbsolute()){
                System.out.println("El archivo "+ruta.getFileName()+" existe y la ruta es absoluta.");
            } else {
                System.out.println("El archivo "+ruta.getFileName()+" existe y la ruta es relativa.");
            }
        }else{
            System.out.println("El archivo "+ruta.getFileName()+" no existe");
            Files.createFile(ruta);
        }
    }

    public static void copiarArchivo(Path origen, Path destino){
        try {
            Files.copy(origen, destino, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Archivo copiado de " + origen + " a " + destino);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void moverArchivo(Path origen, Path destino){
        try {
            Files.move(origen, destino, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Archivo movido de " + origen + " a " + destino);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public static void main(String[] args) throws IOException {
        Path rutaRelativa = Paths.get("rutaRelativa.txt");
        Path rutaAbsoluta = Paths.get("/media/a23loisrm/a23loisrm_documentos/AccesoADatos/AD/CasaAccesoADatos/rutaAbsoluta.txt");

        Path origen = Files.createFile(Paths.get("origen.txt"));
        Path destinoCopia = Files.createFile(Paths.get("copia.txt"));
        Path destinoMover = Files.createFile(Paths.get("moverDestino.txt"));

        
        comprobarRuta(rutaAbsoluta);
        comprobarRuta(rutaRelativa);

        // Copiar archivo
        copiarArchivo(origen, destinoCopia);
        // Mover archivo
        moverArchivo(origen, destinoMover);

    }
}
