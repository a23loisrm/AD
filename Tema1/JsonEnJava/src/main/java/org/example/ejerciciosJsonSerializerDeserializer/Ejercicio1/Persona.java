package org.example.ejerciciosJsonSerializerDeserializer.Ejercicio1;

import com.google.gson.*;

import java.lang.reflect.Type;

/**
 * Ejercicio 1: Serialización y deserialización básica
 * Crea una clase Persona con atributos nombre y edad. Implementa
 * un JsonSerializer y un JsonDeserializer para esta clase,
 * personalizando los nombres de los atributos en el JSON resultante,
 * de modo que aparezcan como name y age en formato JSON.
 */


public class Persona implements JsonSerializer<Persona>, JsonDeserializer <Persona>{
    public String nombre;
    public Integer edad;

    public Persona(String nombre, Integer edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    @Override
    public Persona deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject jsonObject = jsonElement.getAsJsonObject();
        String nombre = jsonObject.get("name").getAsString();
        Integer edad = jsonObject.get("age").getAsInt();
        return new Persona(nombre, edad);
    }

    @Override
    public JsonElement serialize(Persona persona, Type type, JsonSerializationContext jsonSerializationContext) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("name", persona.getNombre());
        jsonObject.addProperty("age", persona.getEdad());
        return jsonObject;
    }
    /*

    public static void main(String[] args) {
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(Persona.class, new Persona("Juan", 25))
                .setPrettyPrinting()
                .create();
        Persona persona = new Persona("Juan", 25);
        String json = gson.toJson(persona);
        System.out.println(json);
    }


     */
}

