package org.example;

import java.io.*;

public class EstatisticaFileRandom {
    private File arquivo;
    private int linhas;
    private int letras;
    private int espazos;

    public EstatisticaFileRandom(String nomeArquivo) {
        this.arquivo = new File(nomeArquivo);
    }

    public void estatisticas() {
        if(existe()){
            try (RandomAccessFile rf = new RandomAccessFile(arquivo, "r")) {
                String lineas;
                while ((lineas = rf.readLine()) !=  null){
                    linhas ++;
                    for(char c: lineas.toCharArray()){
                        if (Character.isLetter(c)){
                            letras++;
                        } else if (Character.isWhitespace(c)) {
                            espazos++;
                        }
                    }
                }
            } catch (IOException e) {
                System.out.println("Erro: "+e.getMessage());
            }
        } else {
            System.out.println("Arquivo non encontrado.");
        }
    }

    public boolean existe() {
        return arquivo.exists();
    }

    public void ultimaModificacion() {
        System.out.println("Ultima modificacion: " + arquivo.lastModified());
    }


    public String getRuta() {
        return arquivo.getAbsolutePath();
    }

    public int getLinhas() {
        return linhas;
    }

    public int getLetras() {
        return letras;
    }
    public int getEspazos() {
        return espazos;
    }
/*
    public static void main(String[] args) {
        EstatisticaFileRandom ef = new EstatisticaFileRandom("pom.xml");
        ef.estatisticas();
        System.out.println("Ruta: " + ef.getRuta());
        System.out.println("Linhas: " + ef.getLinhas());
        System.out.println("Letras: " + ef.getLetras());
        System.out.println("Espazos: " + ef.getEspazos());
        ef.ultimaModificacion();
    }
 */
}
