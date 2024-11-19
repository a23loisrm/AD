package org.example;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class Exercicio3 {

    public static void main(String[] args) {
        JFileChooser guardar = new JFileChooser();
        guardar.showSaveDialog(null);
        guardar.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        File ruta = guardar.getCurrentDirectory();
        try (Stream<Path> s = Files.list(Path.of(String.valueOf(ruta)))) {
            s.filter(p -> p.toString().endsWith(".java"))
                    .forEach(System.out::println);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
