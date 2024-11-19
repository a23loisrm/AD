package org.example;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void menu() {
        System.out.println("##################################################");
        System.out.println("#                                                #");
        System.out.println("#               a) Añadir equipo                 #");
        System.out.println("#               b) Mostrar clasificación         #");
        System.out.println("#               c) Guardar clasificación         #");
        System.out.println("#               d) Cargar clasificación          #");
        System.out.println("#               e) Salir                         #");
        System.out.println("#                                                #");
        System.out.println("##################################################");
    }

    public static void main(String[] args) {
        String ruta = "L:\\AccesoADatos\\Tema1\\EjercicioEquiposBaloncesto\\src\\main\\resources\\";
        List<Clasificacion> clasificaciones = new ArrayList<>();
        ClasificacionFileDAO clasificacionDAO = new ClasificacionFileDAO(ruta);
        Scanner sc = new Scanner(System.in);
        boolean exit = false;
        boolean inicio = false;

        while (!exit) {
            menu();
            System.out.println("\nSeleccione una opción: ");
            String opcion = sc.nextLine().toLowerCase();
            switch (opcion) {
                case "a":
                    // Añadir equipo
                    System.out.println("Introduzca los siguientes datos: ");

                    System.out.print("Nombre clasificacion: ");
                    String cl = sc.nextLine();
                    Clasificacion clasificacion = null;

                    // Buscar si la clasificación ya existe
                    for (Clasificacion c : clasificaciones) {
                        if (c.getCompeticion().equalsIgnoreCase(cl)) {
                            clasificacion = c;
                            break;
                        }
                    }

                    // Si no existe, crear una nueva clasificación y añadirla a la lista
                    if (clasificacion == null) {
                        clasificacion = new Clasificacion(cl);
                        clasificaciones.add(clasificacion);
                        // Añadir el nombre de la liga al archivo clasificaciones.dat
                        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ruta +"/"+ "clasificaciones.dat", true))) {
                            writer.write(cl);
                            writer.newLine();
                        } catch (IOException e) {
                            System.out.println("Error al guardar la clasificación: " + e.getMessage());
                        }
                    }

                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();

                    System.out.print("Partidos jugados: ");
                    int partidos = sc.nextInt();

                    System.out.print("Victorias: ");
                    int victorias = sc.nextInt();

                    System.out.print("Derrotas: ");
                    int derrotas = sc.nextInt();

                    System.out.print("Puntos a favor: ");
                    int puntosAfavor = sc.nextInt();

                    System.out.print("Puntos en contra: ");
                    int puntosEnContra = sc.nextInt();
                    sc.nextLine();

                    Equipo equipo = new Equipo(nombre, partidos, victorias, derrotas, puntosAfavor, puntosEnContra);
                    clasificacion.addEquipo(equipo);
                    break;

                case "b":
                    // Mostrar clasificación
                    System.out.println(clasificacionDAO.getAll());
                    if (inicio == true) {
                        System.out.println("Clasificaciones disponibles:");
                        try (BufferedReader reader = new BufferedReader(new FileReader(ruta + "clasificaciones.dat"))) {
                            String line;
                            while ((line = reader.readLine()) != null) {
                                System.out.println(line);
                            }
                        } catch (IOException e) {
                            System.out.println("Error al leer las clasificaciones: " + e.getMessage());
                        }

                    }else {
                        System.out.println("No hay ninguna clasificacion cargada.");
                    }


                    System.out.print("Nombre de la clasificación a mostrar: ");
                    String nombreClasificacion = sc.nextLine();
                    Clasificacion clasificacionAMostrar = null;
                    for (Clasificacion c : clasificaciones) {
                        if (c.getCompeticion().equalsIgnoreCase(nombreClasificacion)) {
                            clasificacionAMostrar = c;
                            break;
                        }
                    }
                    if (clasificacionAMostrar != null) {
                        System.out.println("Clasificación:");
                        System.out.println(clasificacionAMostrar);
                    } else {
                        System.out.println("Clasificación no encontrada.");
                    }

                    break;

                case "c":

                    // Guardar clasificaciones
                    for (Clasificacion c : clasificaciones) {
                        clasificacionDAO.save(c);
                    }
                    System.out.println("Archivos guardados correctamente");

                    break;

                case "d":
                    // Cargar clasificaciones
                    clasificaciones = clasificacionDAO.getAll();
                    System.out.println("Clasificaciones cargadas:");
                    inicio = true;
                    break;

                case "e":
                    // Salir
                    System.out.print("¿Está seguro de que desea salir? (s/n): ");
                    String confirm = sc.nextLine().toLowerCase();
                    if (confirm.equals("s")) {
                        exit = true;
                    }
                    break;

                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
                    break;
            }
        }
        sc.close();
    }
}
