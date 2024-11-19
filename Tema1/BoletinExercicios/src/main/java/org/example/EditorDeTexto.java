package org.example;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class EditorDeTexto {
    private File arquivo;

    public EditorDeTexto(String arquivo) {
        this.arquivo = new File(arquivo);
    }

    public boolean exists(){
        return arquivo != null && arquivo.exists();
    }

    public String readFile() {
        if (!exists()) return null;
        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line).append(System.lineSeparator());
            }
            return sb.toString();
        } catch (IOException e) {
            return "Erro: " + e;
        }
    }

    public String readFileNIO(){
        if (!exists()) return null;

        Path p  = arquivo.toPath();

        try {
            return Files.readString(arquivo.toPath());
        } catch (IOException e) {
            return "Error: "+e;
        }
    }


    public void writeFromString(String contenido){
        if (!exists()) return ;
        try(BufferedWriter bw  =new BufferedWriter(new FileWriter(arquivo))) {
            bw.write(contenido);
            bw.newLine();
        } catch (IOException e) {
            System.out.println("Erro: "+e);
        }

    }

    public void writeFromStringPrintWriter(String contenido){
        if (!exists()) return;
        try(PrintWriter pw = new PrintWriter(new FileWriter(arquivo))) {
            pw.println(contenido);
        } catch (IOException e) {
            System.out.println("Erro: "+e);
        }
    }

    public void writeFromInputStream(InputStream ip){
        if (!exists()) return;
        try(BufferedReader br = new BufferedReader(new InputStreamReader(ip));
        BufferedWriter bw = new BufferedWriter(new FileWriter(arquivo))) {
        String line;
        while ((line = br.readLine()) != null) {
            bw.write(line);
            bw.newLine();
        }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void writeFromKeyword(){
        if (exists()) return;

        try (BufferedReader br = new BufferedReader(new FileReader(arquivo));
        BufferedWriter bw = new BufferedWriter(new FileWriter(arquivo))){
            String line;
            System.out.println("Editor listo (para finalizar '.')");
            while (!(line = br.readLine()).equalsIgnoreCase(".")) {
                bw.write(line);
                bw.newLine();
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public File getFile(){
        return arquivo;
    }

    public String toString(){
        return arquivo.getAbsolutePath();
    }

    public static void main(String[] args) {
        EditorDeTexto ed = new EditorDeTexto("editorDeTexto.txt");

        // Escribir en el archivo usando writeFromString
        ed.writeFromString("Este es un ejemplo de texto.");

        // Leer el archivo usando readFile
        String contenido = ed.readFile();
        System.out.println("Contenido del archivo:");
        System.out.println(contenido);

        // Escribir en el archivo usando writeFromStringPrintWriter
        ed.writeFromStringPrintWriter("Añadiendo más texto con PrintWriter.");

        // Leer el archivo usando readFileNIO
        String contenidoNIO = ed.readFileNIO();
        System.out.println("Contenido del archivo (NIO):");
        System.out.println(contenidoNIO);

        // Escribir en el archivo desde el teclado
        System.out.println("Escribe algo para añadir al archivo (finaliza con 'exit'):");
        ed.writeFromKeyword();

        // Leer el archivo nuevamente
        contenido = ed.readFile();
        System.out.println("Contenido del archivo después de escribir desde el teclado:");
        System.out.println(contenido);
    }
}
