import java.io.*;
import java.util.Scanner;


public class EstatisticaFile {

    private File arquivo;
    private int linhas;
    private int letras;
    private int espazos;

    public EstatisticaFile(String nomeArquivo) {
        this.arquivo = new File(nomeArquivo);
    }

    public void estatisticas() {
        if(existe()){
            try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
                String lineas;
                while ((lineas = br.readLine()) !=  null){
                    linhas ++;
                    for(char c: lineas.toCharArray()){
                        if (Character.isLetter(c)){
                            letras++;
                        } else if (Character.isWhitespace(c)) {
                            espazos++;
                        }
                    }
                }
                br.close();
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




    public static void main(String[] args) {
        EstatisticaFile ef = new EstatisticaFile("EstatisticaFile");
        ef.estatisticas();
        System.out.println("Ruta: " + ef.getRuta());
        System.out.println("Linhas: " + ef.getLinhas());
        System.out.println("Letras: " + ef.getLetras());
        System.out.println("Espazos: " + ef.getEspazos());
        ef.ultimaModificacion();
    }
}