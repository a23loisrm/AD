package org.example;

import javax.swing.*;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;

public class Exercicio5 {
    public static void main(String[] args){

        try {
            // Pedimos la URL con un cuadro de diálogo
            String urlString = JOptionPane.showInputDialog("Introduce la URL:");
            URL url = new URL(urlString);

            // Establecer conexión HTTP
            HttpURLConnection httpConnection = (HttpURLConnection) url.openConnection();
            httpConnection.setRequestMethod("GET");

            // Obtener el tipo de extensión y tamaño
            String contentType = httpConnection.getContentType();
            int contentLength = httpConnection.getContentLength();

            // Mostrar tipo de contenido y tamaño
            System.out.println("Extensión del archivo: " + contentType);
            System.out.println("Tamaño del contenido: " + contentLength + " bytes");

            // Leer el contenido de la URL
            try (InputStream is = httpConnection.getInputStream();
                 InputStreamReader isr = new InputStreamReader(is);
                 BufferedReader br = new BufferedReader(isr)) {
                String line;
                StringBuilder content = new StringBuilder();
                while ((line = br.readLine()) != null) {
                    content.append(line);
                }
                httpConnection.disconnect();

                // Mostrar el contenido por la pantalla
                System.out.println("Contenido de la URL: ");
                System.out.println(content);

                // Guardar el contenido en el archivo
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY); // Seleccionar solo directorios
                int valorSel = fileChooser.showSaveDialog(null);

                if (valorSel == JFileChooser.APPROVE_OPTION) {
                    File directorio = fileChooser.getSelectedFile();

                    // Pedir al usuario que introduzca un nombre para el archivo
                    String fileName = JOptionPane.showInputDialog("Introduce el nombre del archivo (sin extensión):");

                    // Agregar la extensión basada en el Content-Type
                    String extension = ".html";
                    File file = new File(directorio.getAbsolutePath() + File.separator + fileName + extension);

                    try {
                        // Guardar el contenido en el archivo seleccionado
                        Files.writeString(file.toPath(), content, StandardOpenOption.CREATE);
                        JOptionPane.showMessageDialog(null, "Archivo guardado en: " + file.getAbsolutePath());
                    } catch (IOException e) {
                        JOptionPane.showMessageDialog(null, "Error al guardar el archivo: " + e.getMessage());
                    }
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
