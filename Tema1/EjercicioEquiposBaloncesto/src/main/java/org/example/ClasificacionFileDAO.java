package org.example;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ClasificacionFileDAO implements DAO<Clasificacion, String> {
    private final Path ruta;


    public ClasificacionFileDAO(String ruta) {
        this.ruta = Path.of(ruta);
    }

    @Override
    public Clasificacion get(String competicion) {
        Clasificacion clasificacion = new Clasificacion(competicion);
        EquipoFileDAO equipoDAO = new EquipoFileDAO(Path.of(ruta + "/"+competicion + ".dat"));
        equipoDAO.getAll().forEach(clasificacion::addEquipo);
        return clasificacion;
    }

    @Override
    public boolean save(Clasificacion clasificacion) {

        Path archivoLigas = ruta.resolve(ruta +"/"+ "clasificaciones.dat");
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivoLigas.toFile(), true))) {
            bw.write(clasificacion.getCompeticion()); // Escribir el nombre de la liga
            bw.newLine();          // Añadir un salto de línea después del nombre de la liga
        } catch (IOException e) {
            System.out.println("Error al guardar la liga: " + e.getMessage());
        }


        EquipoFileDAO equipoFileDAO = new EquipoFileDAO(Path.of(ruta +"/"+ clasificacion.getCompeticion() + ".dat"));
        clasificacion.getEquipos().forEach(equipoFileDAO::save);
        return true;
    }

    @Override
    public List<Clasificacion> getAll() {
        List<Clasificacion> clasificaciones = new ArrayList<>();
        Path archivoLigas = Path.of(ruta + "clasificaciones.dat");
        if (Files.exists(archivoLigas)){
            try (BufferedReader br = new BufferedReader(new FileReader(archivoLigas.toFile()))) {
                String linea;
                while ((linea = br.readLine()) != null) {
                    clasificaciones.add(get(linea));
                }
            } catch (IOException e) {
                System.out.println("Error al leer clasificaciones.dat: " + e.getMessage());
            }
        }
        return clasificaciones;
    }

    @Override
    public boolean delete(Clasificacion obx) {
        return false;
    }

    @Override
    public boolean deleteAll() {
        return false;
    }

    @Override
    public boolean deleteById(String id) {
        return false;
    }

    @Override
    public void update(Clasificacion clasificacion) {
        save(clasificacion);
    }
}