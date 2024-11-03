package org.example;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "dir");
            pb.directory(new File("C:/"));
            Process process = pb.start();
            BufferedReader readerC = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            System.out.println("\nDirectorio de C: ");
            while ((line = readerC.readLine()) != null) {
                System.out.println(line);
            }
            System.out.println("\n");
            System.out.println("--------------------------------------------------------------------");
            System.out.println("\n");
            System.out.println("Escriba la ruta que quieras ver: ");
            Scanner sc = new Scanner(System.in);
            String ruta = sc.nextLine();
            ProcessBuilder pb1 = new ProcessBuilder("cmd", "/c", "dir");
            pb1.directory(new File(ruta));
            Process process1 = pb1.start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(process1.getInputStream()));
            String line1;
            System.out.println("Ruta: "+ruta);
            while ((line1 = reader.readLine()) != null){
                System.out.println(line1);
            }


        } catch (IOException e) {
            System.out.println("Error: "+e);;
        }

    }
}