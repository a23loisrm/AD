package org.example;

import java.io.*;

public class Bufferes {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(("kk")));
        bw.write("El mundo es una kk");
        bw.flush(); //Liberamos la memoria, si no no nos escribe lo de arriba


        //Con esto leemos las lineas que teclaeamso por teclado
        Reader  r = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(r);
        String linea;
        while(!(linea = br.readLine()).equalsIgnoreCase("_EXIT_")){
            System.out.println("linha = " + linea);
        }
    }
}
