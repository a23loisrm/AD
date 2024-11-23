package Tema_1._01_01.ClaseFileyRandom;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class Ejercicio6 {

    public static void main(String[] args) throws IOException {
        File archivo = new File("archivoEjercicio6.bin");

        if (archivo.exists()){
            RandomAccessFile randomAccessFile =  new RandomAccessFile("archivoEjercicio6.bin", "rw");
            for (int i = 1; i < 11; i++) {
                randomAccessFile.writeInt(i);
            }
            randomAccessFile.seek(0);
            for (int i = 1; i < 11; i++) {
                System.out.print(randomAccessFile.readInt());
            }

            // Solicitar al usuario un nuevo número para el tercer número
            Scanner sc = new Scanner(System.in);
            System.out.print("Ingrese un nuevo número para reemplazar el tercer número: ");
            int nuevoNumero = sc.nextInt();

            // Modificar el tercer número (posición 2 en base 0, cada entero ocupa 4 bytes)
            randomAccessFile.seek(2 * 4);
            randomAccessFile.writeInt(nuevoNumero);

            // Leer los números después de la modificación
            System.out.println("Números después de la modificación:");
            randomAccessFile.seek(0);
            for (int i = 0; i < 10; i++) {
                System.out.println(randomAccessFile.readInt());
            }
            randomAccessFile.close();
        }else{
            archivo.createNewFile();
        }

    }
}
