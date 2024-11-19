package org.example;

import com.google.gson.*;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class PredicionAdapter implements JsonDeserializer<Prediccion> {

    @Override
    public Prediccion deserialize(JsonElement e, Type t, JsonDeserializationContext c) throws JsonParseException {
        JsonObject ojson = e.getAsJsonObject();
        JsonObject jsonPredicion = ojson.getAsJsonObject("predConcello");
        String nomeConcello = (jsonPredicion.has("nome")
                && !jsonPredicion.get("nome").isJsonNull()) ? jsonPredicion.get("nome").getAsString() : null;
        int idConcello = jsonPredicion.get("idConcello").getAsInt();
        Prediccion prediccion = new Prediccion(new Concello(nomeConcello, idConcello));

        JsonArray a = jsonPredicion.getAsJsonArray("listaPredDiaConcello");

        for (JsonElement elemento : a){
            JsonObject obxeto = elemento.getAsJsonObject();
            prediccion.addPredDiaConcello(c.deserialize(obxeto, PrediccionDia.class));
        }

        return prediccion;
    }


}
