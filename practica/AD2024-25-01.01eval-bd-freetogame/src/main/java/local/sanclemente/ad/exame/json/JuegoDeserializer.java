package local.sanclemente.ad.exame.json;

import com.google.gson.*;
import local.sanclemente.ad.exame.model.*;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class JuegoDeserializer implements JsonDeserializer<Juego> {
    @Override
    public Juego deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject jsonObject = jsonElement.getAsJsonObject();


        int idJuego = jsonObject.get("id").getAsInt();
        String title = jsonObject.get("title").getAsString();
        String thumbnail = jsonObject.get("thumbnail").getAsString();
        String status = jsonObject.get("status").getAsString();
        String short_description = jsonObject.get("short_description").getAsString();
        String description = jsonObject.get("description").getAsString();
        String game_url = jsonObject.get("game_url").getAsString();
        Genero genre = new Genero(0, jsonObject.get("genre").getAsString());
        Plataforma platform = new Plataforma(0, jsonObject.get("platform").getAsString());
        String publisher = jsonObject.get("publisher").getAsString();
        String developer = jsonObject.get("developer").getAsString();
        LocalDate release_date = LocalDate.parse(jsonObject.get("release_date").getAsString());

        RequisitosSistema requisitosSistema =null;
        if (jsonObject.has("minimum_system_requirements")){
            JsonObject jsonObject1 = jsonObject.getAsJsonObject("minimum_system_requirements");
            String os = jsonObject1.get("os").getAsString();
            String processor = jsonObject1.get("processor").getAsString();
            String memory = jsonObject1.get("memory").getAsString();
            String graphics = jsonObject1.get("graphics").getAsString();
            String storage = jsonObject1.get("storage").getAsString();

            requisitosSistema = new RequisitosSistema(os, processor, memory, graphics, storage);
        }

        List<Imagen> listaDeImagenes = new ArrayList<>();
        JsonArray arrayImagenes = jsonObject.getAsJsonArray("screenshots");
        if (arrayImagenes != null){
            for (JsonElement jsonElement1 : arrayImagenes){
                JsonObject imagen =jsonElement1.getAsJsonObject();
                long idImagen = imagen.get("id").getAsLong();
                String image = imagen.get("image").getAsString();
                listaDeImagenes.add(new Imagen(idImagen, image));
            }
        }

        return new Juego(idJuego,genre, platform, title, thumbnail, status, short_description, description, game_url, publisher, developer, release_date, listaDeImagenes, requisitosSistema);
    }
}
