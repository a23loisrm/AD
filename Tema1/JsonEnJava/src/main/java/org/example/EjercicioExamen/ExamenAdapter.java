package org.example.EjercicioExamen;

import com.google.gson.*;

import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ExamenAdapter implements JsonSerializer<Examen>, JsonDeserializer<LocalDateTime> {
    private static final DateTimeFormatter formato
            = DateTimeFormatter.ofPattern("d:MM:uuuu HH:mm:ss");
    @Override
    public LocalDateTime deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        String fecha = jsonElement.getAsString();
        return LocalDateTime.parse(fecha,formato);
    }

    @Override
    public JsonElement serialize(Examen examen, Type type, JsonSerializationContext jsonSerializationContext) {
        return new JsonPrimitive(examen.getFecha().format(formato));
    }
}
