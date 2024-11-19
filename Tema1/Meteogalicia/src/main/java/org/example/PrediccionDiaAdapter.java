package org.example;

import com.google.gson.*;

import java.lang.reflect.Type;
import java.time.LocalDate;

public class PrediccionDiaAdapter implements JsonDeserializer<PrediccionDia> {

    @Override
    public PrediccionDia deserialize(JsonElement e, Type t, JsonDeserializationContext c) throws JsonParseException {
        JsonObject jsonPrediccionDia = e.getAsJsonObject();
        // Creamos un objeto PrediccionDia
        PrediccionDia pc = new PrediccionDia();
        pc.setTemperaturaMaxima(jsonPrediccionDia.get("tMax").getAsInt());
        pc.setTemperaturaMinima(jsonPrediccionDia.get("tMin").getAsInt());
        pc.setUvMaximo(jsonPrediccionDia.get("uvMax").getAsInt());
        if (jsonPrediccionDia.has("nivelAviso")
                && !jsonPrediccionDia.get("nivelAviso").isJsonNull())
            pc.setUvMaximo(jsonPrediccionDia.get("nivelAviso").getAsInt());

        // Obtenemos la fecha de la predicción llamando al método deserialize de la clase JsonDeserializationContext
        pc.setDataPredicion(c.deserialize(jsonPrediccionDia.get("dataPredicion"), LocalDate.class));

        for(VariableMeteo v: VariableMeteo.values()){
        }

        return pc;
    }

    private VariableFranxa getVariableFranxa(VariableMeteo v, JsonObject varFranxaJsonObject){
        VariableFranxa vf = new VariableFranxa();
        vf.setManha(varFranxaJsonObject.get("manha").getAsInt());
        vf.setTarde(varFranxaJsonObject.get("tarde").getAsInt());
        vf.setNoite(varFranxaJsonObject.get("noite").getAsInt());

        return vf;
    }
}
