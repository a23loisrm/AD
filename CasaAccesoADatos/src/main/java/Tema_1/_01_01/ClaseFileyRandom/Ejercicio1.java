package Tema_1._01_01.ClaseFileyRandom;

import java.io.File;
import java.io.IOException;

/**
 *

 Debes trabajar únicamente con métodos de la clase File.

 Realiza los siguientes pasos:

 Crea un archivo de texto llamado prueba.txt en el directorio actual de tu proyecto, sólo si no existe.
 Escribe un programa que cree un objeto File para el archivo prueba.txt y compruebe si el archivo existe.
 Si el archivo existe, muestra la ruta absoluta, nombre del archivo, tamaño, última modificación y si es un directorio.
 Si el archivo no existe, muestra un mensaje que lo indique y crea uno temporal.


 */


public class Ejercicio1 {
    public static void main(String[] args) throws IOException {
        //Creamos un archivo prueba.txt solo si no existe

        File nombreArchivo = new File("prueba.txt");

        if (!nombreArchivo.exists()){
            System.out.println("Erchivo no existe");
            nombreArchivo.createNewFile();
            System.out.println("Archivo creado");
        }else{
            System.out.println("EL archivo existe");
            System.out.println("Ruta absoluta: "+nombreArchivo.getAbsolutePath());
            System.out.println("Nombre del archivo: "+nombreArchivo.getName());
            System.out.println("Tamaño: "+nombreArchivo.length());
            System.out.println("ULtima modificaion: "+nombreArchivo.lastModified());
            System.out.println("DIrectorio?: "+nombreArchivo.isDirectory());
        }
    }
}
