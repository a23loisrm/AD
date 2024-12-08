package Tema_1.Boletin_01_03.Ejercicio4;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import static java.lang.System.*;

public class Ejercicio4 {
    public static void main(String[] args) {
        Gson gson = new Gson();

        // Deserialization de una cadena
        String nome = gson.fromJson("\"Sylvia Plath\"", String.class);
        out.println(nome);

        // Serialization
        gson.toJson(256, out); // por pantalla
        out.println(); // salto de línea.
        gson.toJson("<html>", out); // por pantalla.
        out.println(); // salto de línea

        // Gson personalizado deshabilitando el escapado de HTML
        gson = new GsonBuilder().disableHtmlEscaping().create();
        gson.toJson("<html>", out); // Sin escapar HTML
        out.println();
    }
}
