package org.example;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonSerializer;

public class Main {
    public static void main(String[] args) {
        Pregunta preguntaTrueFalse = new PreguntaTrueFalse("¿Java es un lenguaje de programación orientado a objetos?", true);
        preguntaTrueFalse.setCategoria(new Categoria("Programación"))
                .setTipoPregunta(TipoPregunta.BOOLEAN)
                .setDificultad(Dificultad.EASY);
//        System.out.println(preguntaTrueFalse);

        Pregunta preguntaMultiple = new PreguntaMultiple("¿Cuál de los siguientes lenguajes de programación es orientado a objetos puro?");
        ((PreguntaMultiple)preguntaMultiple).addOpcion(new Opcion("Java", true))
                .addOpcion(new Opcion("C", false))
                .addOpcion(new Opcion("Python", true))
                .addOpcion(new Opcion("Modula-2", true))
                .setCategoria(new Categoria("Programación"))
                .setTipoPregunta(TipoPregunta.MULTIPLE)
                .setDificultad(Dificultad.EASY);


        Pregunta preguntaA = new Pregunta(TipoPregunta.MULTIPLE.getTipoPregunta());
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(TipoPregunta.class, new JsonSerializer<TipoPregunta>() )
        )
    }
}