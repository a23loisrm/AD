package Tema_1.Boletin_01_03.Ejercicio9;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LocalDateTimeAdapter extends TypeAdapter<LocalDateTime> {

    private static final DateTimeFormatter formato
            = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    @Override
    public void write(JsonWriter out, LocalDateTime localDateTime) throws IOException {

        if (localDateTime == null){
            out.nullValue(); // Si el valor es nulo, escribimos nulo
        }else {
            out.value(localDateTime.format(formato));
        }

    }

    @Override
    public LocalDateTime read(JsonReader in) throws IOException {
        String value = in.nextString();
        return LocalDateTime.parse(value, formato);

    }
}
