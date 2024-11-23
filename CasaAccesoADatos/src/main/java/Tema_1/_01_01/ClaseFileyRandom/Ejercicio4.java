package Tema_1._01_01.ClaseFileyRandom;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Ejercicio4 {
    public static void main(String[] args) throws IOException {
        File archivo = new File("prueba.txt");

        if (archivo.exists()){
            RandomAccessFile randomAccessFile= new RandomAccessFile("prueba.txt", "rw");
            randomAccessFile.writeUTF("Hola que tal como estás");
            randomAccessFile.seek(0);
            System.out.println(randomAccessFile.readUTF());
            randomAccessFile.close();
        }else {
            archivo.createNewFile();
        }
    }
}
