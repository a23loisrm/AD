package org.example;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import static java.lang.System.*;





public class Exercicio4 {
    public static void main(String[] args) {


        //Creamos o arquivo solo se non existe
        String arquivo = "prueba.txt";
        File archivo = new File(arquivo);

        // comprobamos se existe o arquivo, en caso de que non exista creámolo
        if(!archivo.exists()){
            try {
                //creamos el archivo
                archivo.createNewFile();
                out.println("Arquivo prueba.txt creado");

            } catch (IOException e) {
                out.println("Error ao crear o arquivo: "+e.getMessage());
                return;
            }
        } else {
            out.println("O arquivo xa está creado");
        }

        try{
            RandomAccessFile raf = new RandomAccessFile(arquivo, "rw"); // con rw, facemos lectura e escritura
            String mensaxe = "Hello World!";
            //Escribimos a mensaxe
            raf.writeUTF(mensaxe);
            raf.seek(0); //Desde a posición inicial
            //leemos o arquivo
            out.println(raf.readUTF());
        } catch (IOException e){
            out.println("Error ao acceder ao arquivo: "+e.getMessage());
        }
    }
}
