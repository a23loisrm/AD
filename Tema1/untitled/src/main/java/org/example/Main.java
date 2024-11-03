package org.example;

import javax.swing.*;
import java.io.File;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        JFileChooser fc = new JFileChooser("c:/");

        if(fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION){
            File f = fc.getSelectedFile();
            System.out.println(f.getAbsolutePath());
        }

    }
}