package org.example;
import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.util.Date;

//TIP Al poner lo de abajo, no tenemos que poner seguido el System
import static java.lang.System.*;

//TIP Ejemplo clase FILE
public class Main {
    public static void main(String[] args) {


        //TIP EJERCICIO 2: Ahora empregaremos o JFileChooser
        JFileChooser fc = new JFileChooser("c:\\");
        fc.setFileSelectionMode(JFileChooser.FILES_ONLY);

        if(fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION){
            File archivo = fc.getSelectedFile();
            StringBuilder sb = new StringBuilder();
            sb.append("Ruta absoluta: ")
                    .append(System.lineSeparator());
            sb.append(archivo.getAbsolutePath())
                    .append(System.lineSeparator());
            sb.append("Nome arquivo: ")
                    .append(System.lineSeparator());
            sb.append(archivo.getName())
                        .append(System.lineSeparator());
            sb.append("Tamaño: ")
                    .append(archivo.length())
                    .append(" bytes")
                    .append(System.lineSeparator());
            sb.append("Data modificación: ")
                    .append(System.lineSeparator());
            sb.append(new Date(archivo.lastModified()))
                        .append(System.lineSeparator());
            sb.append(archivo.isFile() ? "É un arquivo" : "É un directorio");

            JOptionPane.showMessageDialog(null, sb.toString());
        }


        //TIP EJERCICIO 1
        /*
        File archivo = new File("prueba");

        if(archivo.exists()){
            System.out.println("Existe");
            out.println("Ruta absoluta: "+ archivo.getAbsolutePath());
            out.println("Nome arquivo: "+archivo.getName());
            out.println("Tamaño: "+archivo.length()+" bytes");
            out.println("Data modificación: "+new Date(archivo.lastModified()));
            out.println(archivo.isFile() ? "É un arquivo" : "É un directorio");
        } else {
            System.out.println("Non existe");
            try {
                if(archivo.createNewFile())
                    out.println("arquivo creado");
                else{
                    out.println("Error ao crear o archivo");
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
         */

        //TIP System.out.println(archivo.exists() ? "Existe" : "Non existe"); recordar que esto es lo mismo que el if anterior
    }
}