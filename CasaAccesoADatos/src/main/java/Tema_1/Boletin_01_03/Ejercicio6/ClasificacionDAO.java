package Tema_1.Boletin_01_03.Ejercicio6;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ClasificacionDAO {

    private static String OBJECT_FILE = "clasifiacion.dat";
    private static String JSON_FILE = "calsificacion.json";

    private Gson gson;

    public ClasificacionDAO(){
        this.gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
    }

    public void saveToObject(Clasificacion c){
        try{
            Path path = Paths.get(OBJECT_FILE);
            try (OutputStream os = Files.newOutputStream(path);
                 BufferedOutputStream bos = new BufferedOutputStream(os);
                 ObjectOutputStream oos = new ObjectOutputStream(bos)) {
                // Guardar el objeto Clasificacion en el archivo
                oos.writeObject(c);
                System.out.println("Clasificación guardada correctamente en " + OBJECT_FILE);
            }
        } catch (IOException e) {
            System.err.println("Error al guardar la clasificación: " + e.getMessage());
        }
    }

    public void saveToJSON(Clasificacion c, String File){
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(File)))){
            String json = gson.toJson(c);
            bw.write(json);
            System.out.println("Clasificación guardada en formato textual en " + File);
        } catch (FileNotFoundException e) {
            System.err.println("Error al guardar la clasificación: " + e.getMessage());

        } catch (IOException e) {
            System.err.println("Error al guardar la clasificación: " + e.getMessage());

        }
    }

    public void saveToJson(Clasificacion c){
        saveToJSON(c, JSON_FILE);
    }

    public Clasificacion getFromObject() {
        try {
            Path ruta = Paths.get(OBJECT_FILE);
            try (InputStream is = Files.newInputStream(ruta);
                 ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(is))) {
                // Leemos el objeto deserializado desde el archivo
                Clasificacion clasificacion = (Clasificacion) ois.readObject();
                System.out.println("Clasificación cargada correctamente desde " + OBJECT_FILE);
                return clasificacion;
            }
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error al cargar la clasificación: " + e.getMessage());
            return null;
        }
    }

    public Clasificacion getFromJSON(String File){
        Path path = Paths.get(File);
        try(BufferedReader bf = Files.newBufferedReader(path)) {
            //Leemos el objeto
            Clasificacion clasificacion = gson.fromJson(bf, Clasificacion.class);
            System.out.println("Clasificación cargada correctamente desde " + File);
            return clasificacion;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Clasificacion getFromJSON(){
        return getFromJSON(JSON_FILE);
    }

}
