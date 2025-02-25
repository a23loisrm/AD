package local.sanclemente.ad.exame.json;

import com.google.gson.*;
import local.sanclemente.ad.exame.model.Imagen;
import local.sanclemente.ad.exame.model.Juego;

import java.lang.reflect.Type;

public class JuegoSerializer implements JsonSerializer<Juego> {
    @Override
    public JsonElement serialize(Juego juego, Type type, JsonSerializationContext jsonSerializationContext) {
        JsonObject jsonObject = new JsonObject();

        //Agregamos los datos al JSON
        jsonObject.addProperty("id", juego.getIdJuego());
        jsonObject.addProperty("title", juego.getTitulo());
        jsonObject.addProperty("genre", juego.getGenero().getNombre());
        jsonObject.addProperty("platform", juego.getPlataforma().getNombre());
        jsonObject.addProperty("thumbnail", juego.getMiniatura());
        jsonObject.addProperty("status", juego.getEstado());
        jsonObject.addProperty("short_description", juego.getDescripcionCorta());
        jsonObject.addProperty("description", juego.getDescripcion());
        jsonObject.addProperty("game_url", juego.getUrl());
        jsonObject.addProperty("publisher", juego.getEditor());
        jsonObject.addProperty("developer", juego.getDesarrollador());
        jsonObject.addProperty("release_date", juego.getFecha().toString());

        if (juego.getRequisitosSistema() != null){
            JsonObject requisitos = new JsonObject();
            requisitos.addProperty("os", juego.getRequisitosSistema().getSistemaOperativo());
            requisitos.addProperty("processor", juego.getRequisitosSistema().getProcesador());
            requisitos.addProperty("memory", juego.getRequisitosSistema().getMemoria());
            requisitos.addProperty("graphics", juego.getRequisitosSistema().getGraficos());
            requisitos.addProperty("storage", juego.getRequisitosSistema().getAlmacenamiento());
            jsonObject.add("minimum_system_requirements", requisitos);
        }

        //Agregamos las capturas
        JsonArray arrayDeImagenes = new JsonArray();
        for(Imagen img : juego.getImagenes()){
            JsonObject imagenes = new JsonObject();
            imagenes.addProperty("id", img.getIdImagen());
            imagenes.addProperty("image", img.getUrl());
            arrayDeImagenes.add(imagenes);
        }
        jsonObject.add("screenshots",arrayDeImagenes);
        return jsonObject;
    }
}
