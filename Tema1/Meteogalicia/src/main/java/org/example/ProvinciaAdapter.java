package org.example;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProvinciaAdapter extends TypeAdapter<List<Provincia>> {
    @Override
    public void write(JsonWriter jsonWriter, List<Provincia> provincias) throws IOException {

    }

    @Override
    public List<Provincia> read(JsonReader r) throws IOException {
        List<Provincia> provincias = new ArrayList<>();
        r.beginObject();
        while (r.peek() == JsonToken.NAME){ //Pilla el primero y mira si es un nombre
            Provincia pr = new Provincia(r.nextName());
           // pr.setConcellos(getConcellosProvincia(r));
            ConcellosAdapter ca = new ConcellosAdapter();
            pr.setConcellos(ca.read(r));
            provincias.add(pr);
        }
        r.endObject();
        return provincias;
    }


    private Concello getProvincia(JsonReader r) throws IOException {
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
}
