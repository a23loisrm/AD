package org.example.ejerciciosJsonSerializerDeserializer.Ejercicio2;

import com.google.gson.*;
import org.example.ejerciciosJsonSerializerDeserializer.Ejercicio1.Persona;
//import org.example.ejerciciosJsonSerializerDeserializer.Ejercicio1.Persona;

import java.lang.reflect.Type;

/**
 * Ejercicio 2: Serialización y deserialización de objetos
 * anidados Manejar una clase que contiene otro objeto como
 * atributo.
 * Crea una clase Direccion con atributos calle y ciudad.
 * Añade un atributo de tipo Direccion. Implementa los
 * serializadores y deserializadores necesarios para manejar
 * esta estructura de modo que la dirección tenga el nombre
 * address y los atributos street y city. Además, la
 * dirección debe aparecer como una cadena de texto con el
 * formato calle, ciudad.
 */

public class Direccion implements JsonSerializer<Direccion>, JsonDeserializer<Persona> {
    public String calle;
    public String ciudad;
    public Direccion direccion;

    public Direccion(String calle, String ciudad, Direccion direccion) {
        this.calle = calle;
        this.ciudad = ciudad;
        this.direccion = direccion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return "Direccion{" +
                "calle='" + calle + '\'' +
                ", ciudad='" + ciudad + '\'' +
                ", direccion=" + direccion +
                '}';
    }

    @Override
    public Persona deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject jsonObject = jsonElement.getAsJsonObject();
        String nombre = jsonObject.get("name").getAsString();
        Integer edad = jsonObject.get("age").getAsInt();
        return new Persona(nombre, edad);
    }

    @Override
    public JsonElement serialize(Direccion direccion, Type type, JsonSerializationContext jsonSerializationContext) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("Calle", direccion.getCalle());
        jsonObject.addProperty("Ciudad", direccion.getCiudad());
        return jsonObject;
    }
}

