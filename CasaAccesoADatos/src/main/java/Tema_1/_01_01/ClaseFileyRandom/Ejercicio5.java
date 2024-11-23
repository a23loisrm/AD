package Tema_1._01_01.ClaseFileyRandom;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Ejercicio5 {
    public static void main(String[] args) throws IOException {
        File archivo = new File("archivoEjercicio5.txt");
        
        if (archivo.exists()){
            RandomAccessFile randomAccessFile =  new RandomAccessFile("archivoEjercicio5.txt", "rw");
            for (int i = 1; i < 11; i++) {
                randomAccessFile.writeInt(i);
            }
            randomAccessFile.seek(0);
            for (int i = 1; i < 11; i++) {
                System.out.println(randomAccessFile.readInt());
            }
            randomAccessFile.close();
        }else{
            archivo.createNewFile();
            RandomAccessFile randomAccessFile =  new RandomAccessFile("archivoEjercicio5.txt", "rw");
            for (int i = 1; i < 11; i++) {
                randomAccessFile.writeInt(i);
            }
            randomAccessFile.seek(0);
            for (int i = 1; i < 11; i++) {
                System.out.println(randomAccessFile.readInt());
            }
            randomAccessFile.close();
        }
        
    }
}
