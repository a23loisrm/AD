package Tema_1.Boletin_01_02.Ejercicio5;

import javax.swing.*;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/**
 * Haz un programa que descargue un archivo de Internet y lo copie en un
 * directorio concreto. Emplea ventanas de tipo JFileChooser para indicar la ruta en la
 * que guardarlo y una caja de texto para escribir la URL.
 * Este código debe operar del siguiente modo:
 * • Encapsular en flujo al archivo de internet, new URL(url).openStream(), dentro
 * de un Buffer.
 * • Guardarlo en un directorio destino empleando Path.
 * • Emplead el metodo estático copy de Files para descargar el archivo, la versión
 * que recoge un InputStream como origen y lo guarda en un Path, sustituyendo
 * el destino si existe.
 * • Cópialos con la opción REPLACE_EXISTING, que indica que si el archivo de
 * destino ya existe, se debe reemplazar.
 * Abre el archivo descargado con un BufferedInputStream, pero creando el
 * InputStream con el metodo estático de Files.
 */

public class DescargaInternet {

    public static void main(String[] args) {
        // Crear interfaz gráfica para ingresar URL
        JTextField urlField = new JTextField();
        JButton selectDirButton = new JButton("Seleccionar Directorio");

        // Ventana principal
        JPanel panel = new JPanel();
        panel.add(new JLabel("Introduce la URL del archivo:"));
        panel.add(urlField);
        panel.add(selectDirButton);

        int result = JOptionPane.showConfirmDialog(null, panel, "Descargar Archivo",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (result == JOptionPane.OK_OPTION) {
            try {
                // Leer URL ingresada
                String urlText = urlField.getText();
                URL url = new URL(urlText);

                // Abrir JFileChooser para seleccionar directorio
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                int selection = fileChooser.showSaveDialog(null);

                if (selection == JFileChooser.APPROVE_OPTION) {
                    File selectedDir = fileChooser.getSelectedFile();
                    Path destino = Paths.get(selectedDir.getAbsolutePath(), "archivo_descargado");

                    // Descargar el archivo
                    try (InputStream in = new BufferedInputStream(url.openStream())) {
                        Files.copy(in, destino, StandardCopyOption.REPLACE_EXISTING);
                        JOptionPane.showMessageDialog(null, "Archivo descargado con éxito en " + destino);
                    }
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
            }
        }
    }
}
