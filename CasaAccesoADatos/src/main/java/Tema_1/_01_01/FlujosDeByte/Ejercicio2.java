package Tema_1._01_01.FlujosDeByte;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *

 Crea una clase Persona con los atributos nombre y edad. Crea un programa que serialice y deserialice un objeto de tipo Persona.

 Debe tener un menú con las siguientes opciones:

 Añadir persona.
 Mostrar personas.
 Buscar persona (por número o por nombre, según consideres)
 Salir

 Puedes hacerlo desde consola o por medio de una interfaz gráfica, haciendo uso de JOptionPane para introducir los datos (JOptionPane.showInputDialog) y mostrar los resultados (JOptionPane.showMessageDialog).

 */


public class Ejercicio2 {
    public static class Persona implements Serializable {
        private String nombre;
        private int edad;

        public Persona(String nombre, int edad) {
            this.nombre = nombre;
            this.edad = edad;
        }

        public String getNombre() {
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
            return "Persona{" +
                    "nombre='" + nombre + '\'' +
                    ", edad=" + edad +
                    '}';
        }
    }
    public static void  main(String[] args) throws IOException, ClassNotFoundException {
        Scanner sc = new Scanner(System.in);
        List<Persona> listaPersonas = new ArrayList<>();
        boolean salir = false;
        while (!salir) {
            System.out.println("1. Añadir persona.");
            System.out.println("2. Mostrar personas.");
            System.out.println("3. Buscar persona (por número o por nombre, según consideres)");
            System.out.println("4. Salir");
            System.out.println("Seleccione una opción:");
            int numero = sc.nextInt();
            sc.nextLine();


            switch (numero) {
                case 1:
                    System.out.println("Nombre");
                    String nombre = sc.nextLine();
                    System.out.println("Edad");
                    int edad = sc.nextInt();
                    sc.nextLine();
                    Persona persona = new Persona(nombre, edad);
                    listaPersonas.add(persona);
                    //Serializacion
                    try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("usuario.txt"))) {
                        out.writeObject(persona);
                    }
                    System.out.println("Persona añadida y guardada exitosamente.");
                break;

                case 2:
                    // Deserializacion
                    try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("usuario.txt"))) {
                        Persona personaDeserilizada = (Persona)
                                in.readObject();
                        System.out.println(personaDeserilizada.toString());
                    }
                    System.out.println("Lista de personas:");
                    for (Persona p : listaPersonas) {
                        System.out.println(p);
                    }
                    break;

                case 3:
                    // Buscar persona por nombre
                    System.out.println("Ingrese el nombre a buscar:");
                    String nombreBuscar = sc.nextLine();
                    boolean encontrado = false;
                    for (Persona p : listaPersonas) {
                        if (p.getNombre().equalsIgnoreCase(nombreBuscar)) {
                            System.out.println("Persona encontrada: " + p);
                            encontrado = true;
                        }
                    }
                    if (!encontrado) {
                        System.out.println("No se encontró ninguna persona con ese nombre.");
                    }
                    break;

                case 4:
                    // Salir
                    salir = true;
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Opción no válida. Intente de nuevo.");

            }
        }
        sc.close();
    }
}
