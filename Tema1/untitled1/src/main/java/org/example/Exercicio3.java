package org.example;
import java.util.Scanner;

import static java.lang.System.*;

public class Exercicio3 {
    public static void main(String[] args) {
        out.println("1. Crear directorio");
        out.println("2. Listar archivos y subdirectorios de un directorio");
        out.println("3. Eliminar archivo o directorio");
        out.println("4. Mover o renombrar archivo o directorio");
        out.println("0. Salir");

        Scanner sc = new Scanner(System.in);
        int seleccion = sc.nextInt();

    }
}
