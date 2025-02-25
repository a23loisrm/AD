package local.sanclemente.ad.exame.json;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import local.sanclemente.ad.exame.model.*;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class JuegoTypeAdapter extends TypeAdapter<Juego> {
    @Override
    public void write(JsonWriter jsonWriter, Juego juego) throws IOException {
        jsonWriter.beginObject();

        jsonWriter.name("id").value(juego.getIdJuego());
        jsonWriter.name("title").value(juego.getTitulo());
        jsonWriter.name("thumbnail").value(juego.getMiniatura());
        jsonWriter.name("thumbnail").value(juego.getMiniatura());
        jsonWriter.name("status").value(juego.getEstado());
        jsonWriter.name("short_description").value(juego.getDescripcionCorta());
        jsonWriter.name("description").value(juego.getDescripcion());
        jsonWriter.name("game_url").value(juego.getUrl());
        jsonWriter.name("genre").value(juego.getGenero().getNombre());
        jsonWriter.name("platform").value(juego.getPlataforma().getNombre());
        jsonWriter.name("publisher").value(juego.getEditor());
        jsonWriter.name("developer").value(juego.getDesarrollador());
        jsonWriter.name("release_date").value(juego.getFecha().toString());

        if (juego.getRequisitosSistema() != null){
            jsonWriter.name("minimum_system_requirements");
            jsonWriter.beginObject();
            jsonWriter.name("os").value(juego.getRequisitosSistema().getSistemaOperativo());
            jsonWriter.name("preocessor").value(juego.getRequisitosSistema().getProcesador());
            jsonWriter.name("memory").value(juego.getRequisitosSistema().getMemoria());
            jsonWriter.name("graphics").value(juego.getRequisitosSistema().getGraficos());
            jsonWriter.name("storage").value(juego.getRequisitosSistema().getAlmacenamiento());
            jsonWriter.endObject();
        }

        jsonWriter.name("screenshot");
        jsonWriter.beginArray();
        for (Imagen img : juego.getImagenes()){
            jsonWriter.beginObject();
            jsonWriter.name("id").value(img.getIdImagen());
            jsonWriter.name("image").value(img.getUrl());
            jsonWriter.endObject();
        }
        jsonWriter.endArray();

        jsonWriter.endObject();
    }

    @Override
    public Juego read(JsonReader jsonReader) throws IOException {
        try{
            jsonReader.beginObject();
            int id = 0;
            Genero genero = null;
            Plataforma plataforma = null;
            String title = "";
            String thumbnail = "";
            String status = "";
            String short_description = "";
            String description = "";
            String game_url = "";
            String publisher = "";
            String developer = "";
            LocalDate release_date = null;
            RequisitosSistema requisitosSistema = null;
            List<Imagen> listaDeImagenes = new ArrayList<>();

            while (jsonReader.hasNext()){
                String nombre = jsonReader.nextName();
                switch (nombre){
                    case "id":
                            id = jsonReader.nextInt();
                        break;

                    case "title":
                        title = jsonReader.nextString();
                        break;

                    case "thumbnail":
                        thumbnail = jsonReader.nextString();
                        break;


                    case "status":
                        status = jsonReader.nextString();
                        break;

                    case "short_description":
                        short_description = jsonReader.nextString();
                        break;

                    case "description":
                        description = jsonReader.nextString();
                        break;

                    case "game_url":
                        game_url = jsonReader.nextString();
                        break;

                    case "genre":
                        genero = new Genero(0, jsonReader.nextString());
                        break;
                    case "platform":
                        plataforma = new Plataforma(0, jsonReader.nextString());
                        break;
                    case "publisher":
                        publisher = jsonReader.nextString();
                        break;
                    case "developer":
                        developer = jsonReader.nextString();
                        break;
                    case "release_date":
                        release_date = LocalDate.parse(jsonReader.nextString());
                        break;
                    case "freetogame_profile_url":
                        jsonReader.skipValue();
                        break;
                    case "minimum_system_requirements":
                        try {
                            jsonReader.beginObject();
                            String os = "", processor = "", memory = "", graphics = "", storage = "";

                            while (jsonReader.hasNext()) {
                                String key = jsonReader.nextName();
                                switch (key) {
                                    case "os": os = jsonReader.nextString(); break;
                                    case "processor": processor = jsonReader.nextString(); break;
                                    case "memory": memory = jsonReader.nextString(); break;
                                    case "graphics": graphics = jsonReader.nextString(); break;
                                    case "storage": storage = jsonReader.nextString(); break;
                                    default: jsonReader.skipValue();
                                }
                            }
                            jsonReader.endObject();
                            requisitosSistema = new RequisitosSistema(os, processor, memory, graphics, storage);
                        } catch (Exception e) {
                            System.err.println("Error al leer los requisitos del sistema: " + e);
                        }
                        break;
                    case "screenshots":
                        jsonReader.beginArray();
                        while (jsonReader.hasNext()) {
                            jsonReader.beginObject();
                            long idImage = 0;
                            String image = "";
                            while (jsonReader.hasNext()) {
                                String imagen = jsonReader.nextName();
                                switch (imagen) {
                                    case "id":
                                        idImage = jsonReader.nextLong();
                                        break;
                                    case "image":
                                        image = jsonReader.nextString();
                                        break;
                                    default:
                                        jsonReader.skipValue();
                                }

                            }
                            jsonReader.endObject();
                            listaDeImagenes.add(new Imagen(idImage, image));
                        }
                        jsonReader.endArray();
                        break;
                    default:
                        jsonReader.skipValue();
                }

            }
            jsonReader.endObject();
            return new Juego(id, genero, plataforma, title, thumbnail, status, short_description, description, game_url, publisher, developer, release_date, listaDeImagenes, requisitosSistema);
        } catch (Exception e) {
            System.err.println("Error al leer el JSON: "+e);
            return null;
        }
    }
}
