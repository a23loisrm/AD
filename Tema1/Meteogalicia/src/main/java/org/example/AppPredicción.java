package org.example;

import com.google.gson.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class AppPredicción {

    public static final String URL = "https://servizos.meteogalicia.gal/mgrss/predicion/" +
            "jsonPredConcellos.action?idConc=15078&request_locale=gl";

    public static void main(String[] args) {
        try {

            var r = new BufferedReader(new InputStreamReader(new URI(URL).toURL().openConnection().getInputStream()));
            Gson gson = new GsonBuilder()
                    .registerTypeAdapter(Prediccion.class, new PredicionAdapter())
                    .registerTypeAdapter(PrediccionDia.class, new PrediccionDiaAdapter())
                    .registerTypeAdapter(LocalDate.class,
                            (JsonDeserializer<LocalDate>) (e, t, c) -> LocalDateTime.parse(e.getAsString()).toLocalDate())
                    .setPrettyPrinting()
                    .create();

            System.out.println(gson.fromJson(r, Prediccion.class));
        } catch (URISyntaxException | IOException e) {
            throw new RuntimeException(e);
        }

    }
}