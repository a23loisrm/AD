//package org.example;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;
/*
public class Exercicio2 {
    public static void main(String[] args) throws IOException {
        JFileChooser fc = new JFileChooser("c:\\");
        fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        if(args.length > 0){

        }

        if(fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION){
            File[] files = fc.getSelectedFiles().listFiles();
        }
        System.out.println("Introduce la ruta:");
        String dirpath = br.readLine();
        System.out.println("Introduce el nombre del directorio:");
        String dname = br.readLine();

        // creamos un objeto File a partir de la ruta y el nombre del directorio
        File f = new File(dirpath, dname);

        // si el directorio existe, mostramos su contenido
        if (f.exists()) {

            File directorio = fc.getSelectedFile();
            File[] archivos = directorio.listFiles();
            long total = 0;
            for (File archivo : archivos) {
                System.out.println(archivo.getName() + " " + archivo.length() + " " + (archivo.isDirectory() ? "Directorio" : "Archivo"));
                total += archivo.length();
            }
            System.out.println("Tamaño total: " + total);


        }
    }
}
*/