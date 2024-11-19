package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class ClasificacionJSONDAO implements Dao<Clasificacion, String> {

    public static final Path DEFAULT_PATH = Paths.get("e:\\data\\");
    public static final Gson gson = new GsonBuilder().setPrettyPrinting().create();
    public static ClasificacionJSONDAO instance;


    private Path ruta;

    public ClasificacionJSONDAO() {
        ruta = DEFAULT_PATH;
    }

    public ClasificacionJSONDAO(String ruta) {
        this.ruta = Paths.get(ruta);
    }

    public static ClasificacionJSONDAO getInstance() {
        if (instance == null) {
            instance = new ClasificacionJSONDAO();
        }
        return instance;
    }

    @Override
    public Clasificacion get(String id) {
        try(var r = Files.newBufferedReader(ruta.resolve(id+".json"))){
            return gson.fromJson(r, Clasificacion.class);
        } catch (IOException e) {
            System.out.println("Error al leer el fichero de la clasificacion: "+e);
            return null;
        }
    }

    @Override
    public List<Clasificacion> getAll() {
        return List.of();
    }

    @Override
    public boolean save(Clasificacion clasificacion) {
        try (var f = Files.newBufferedWriter(ruta.resolve(clasificacion.getCompeticion() + ".json"))){
            gson.toJson(clasificacion, f);
            return true;
        } catch (IOException e) {
            System.out.println("Error al escribir el fichero de la clasificación");
            return false;
        }
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
    public void update(Clasificacion obx) {

    }
}
