package local.sanclemente.ad.exame;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;
import local.sanclemente.ad.exame.json.JuegoDeserializer;
import local.sanclemente.ad.exame.json.JuegoSerializer;
import local.sanclemente.ad.exame.json.JuegoTypeAdapter;
import local.sanclemente.ad.exame.model.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AppJuegoJSON {
    public static void main(String[] args) {

        String rutaJson = "C:\\Users\\loisr\\Desktop\\practica\\AD2024-25-01.01eval-bd-freetogame\\src\\main\\java\\local\\sanclemente\\ad\\exame\\json\\515.json";



        //Esto es para el writer
        try {
            JsonReader jsonReader = new JsonReader(new FileReader(rutaJson));

            JuegoTypeAdapter juegoTypeAdapter = new JuegoTypeAdapter();

            Juego juego = juegoTypeAdapter.read(jsonReader);

            System.out.println(juego);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        //Esto es para el reader

        try(FileReader fr = new FileReader(rutaJson)) {
            Gson gson = new GsonBuilder()
                    .registerTypeAdapter(Juego.class, new JuegoTypeAdapter())
                    .setPrettyPrinting()
                    .create();

            Juego juego = gson.fromJson(fr, Juego.class);
            System.out.println(juego);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        System.out.println("======================================");
        System.out.println("======================================");
        System.out.println("======================================");
        System.out.println("======================================");
        System.out.println("======================================");
        System.out.println("======================================");

        try(FileReader fileReader = new FileReader(rutaJson)){

            Gson gson = new GsonBuilder()
                    .registerTypeAdapter(Juego.class, new JuegoDeserializer())
                    .setPrettyPrinting()
                    .create();

            Juego juego = gson.fromJson(fileReader, Juego.class);
            System.out.println(juego);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        System.out.println("=========================================");
        System.out.println("=========================================");
        System.out.println("=========================================");
        System.out.println("=========================================");
        System.out.println("=========================================");
        System.out.println("=========================================");
        System.out.println("=========================================");
        System.out.println("Probamos lo de serializer");

//        Genero genero = new Genero(0, "Shooter");
//        Plataforma plataforma = new Plataforma(0, "Windows");
//        List<Imagen> imagenes = new ArrayList<>();
//        imagenes.add(new Imagen(4L, "https://www.url1.com"));
//        imagenes.add(new Imagen(5L, "https://www.url2.com"));
//
//        RequisitosSistema requisitos = new RequisitosSistema("Windows 10", "Intel i5", "8GB", "NVIDIA 1050", "40GB");
//
//        Juego juego = new Juego(516, genero, plataforma, "PUBG: BATTLEGROUNDS",
//                "https://thumbnail.jpg", "Live", "Un battle royale popular.",
//                "Juego de disparos", "https://game_url.com", "KRAFTON", "KRAFTON",
//                LocalDate.of(2022, 1, 12), imagenes, requisitos);
//
//
//        Gson gson = new GsonBuilder()
//                .registerTypeAdapter(Juego.class, new JuegoDeserializer())
//                .setPrettyPrinting()
//                .create();
//
//        //Convertimos a json
//        String json = gson.toJson(juego);
//
//        System.out.println(json);
    }
}
