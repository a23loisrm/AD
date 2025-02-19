package org.example;

import javax.swing.*;
import java.io.*;

public class Exercicio2 {


    public static class Persona implements Serializable{
        private String nombre;
        private int edad;

        public Persona(String nombre, int edad){
            this.nombre = nombre;
            this.edad = edad;
        }

        public String getNombre(){
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public int getEdad() {
            return edad;
        }

        public void setEdad(int edad) {
            this.edad = edad;
        }

        @Override
        public String toString() {
            return nombre+" , "+edad;
        }
    }

    public void menu(){
        ImageIcon icono = new ImageIcon(String.valueOf(JOptionPane.QUESTION_MESSAGE));
        Object menu = JOptionPane.showInputDialog(null, "Seleccione unha opción", "Menú",
                JOptionPane.INFORMATION_MESSAGE, icono , new Object[]{"op","op","op"},"Seleccionar");
        JOptionPane.showMessageDialog(null, menu,
                "Selección", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        ImageIcon icono = new ImageIcon(String.valueOf(JOptionPane.QUESTION_MESSAGE));
        Object menu = JOptionPane.showInputDialog(null, "Seleccione una opción", "Menú",
                JOptionPane.INFORMATION_MESSAGE, icono , new Object[]{"Seleccionar","Añadir Persona","Mostrar Personas","Buscar Personas", "Salir"}, "Seleccionar");

        while(menu == null || menu.equals("Seleccionar")) {  // Verifica si es null o "Seleccionar"
            if (menu == null) {  // Si el usuario presiona Cancelar
                JOptionPane.showMessageDialog(null, "Debe seleccionar la opción 'Salir' para salir.",
                        "ERROR_MESSAGE", JOptionPane.ERROR_MESSAGE);
            } else if (menu.equals("Seleccionar")) {
                JOptionPane.showMessageDialog(null, "Seleccione una opción",
                        "ERROR_MESSAGE", JOptionPane.ERROR_MESSAGE);
            }

            menu = JOptionPane.showInputDialog(null, "Seleccione una opción", "Menú",
                    JOptionPane.INFORMATION_MESSAGE, icono , new Object[]{"Seleccionar","Añadir Persona","Mostrar Personas","Buscar Personas", "Salir"}, "Seleccionar");
        }


        Persona persona = new Persona("Ramón", 25);


        //Serializacion
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("usuario.txt"))){
            out.writeObject(persona);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

       // Deserializacion
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("usuario.txt"))){
            Persona personaDeserilizada = (Persona)
                    in.readObject();
            System.out.println(personaDeserilizada.toString());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
