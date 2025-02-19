package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ConcellosAdapter extends TypeAdapter<List<Concello>> {
    @Override
    public void write(JsonWriter jsonWriter, List<Concello> concellos) throws IOException {

    }

    @Override
    public List<Concello> read(JsonReader r) throws IOException {
        List<Concello> concellos = new ArrayList<>();

        if (r.peek() == JsonToken.BEGIN_ARRAY){
            r.beginArray(); //Epieza el array
            while (r.hasNext()){
                concellos.add(getConcello(r));
            }
            r.endArray(); //Finaliza el array
        }

        return concellos;
    }

    private Concello getConcello(JsonReader r) throws IOException {
        String nome = null;
        Integer id = null;

        r.beginObject();
        while (r.hasNext()){
            String name = r.nextName();

            switch (name) {
                case "nombre"->nome = r.nextString();
                case "id" -> id = r.nextInt();
                default -> r.skipValue();

            }

        }
        r.endObject();
        return new Concello(nome, id);
    }
/*
    public static void main(String[] args) throws IOException {
        Type tipo = new TypeToken<List<Concello>>(){}.getType();
        Gson g = new GsonBuilder()
                .registerTypeAdapter(tipo, new ConcellosAdapter())
                .create();
        List<Concello> concellos = g.fromJson(Files.newBufferedReader(Paths.get("concellos.json")), tipo);
        concellos.forEach(System.out::println);
    }

 */
}
