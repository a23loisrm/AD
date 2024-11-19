package org.example;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class pruebas {
    public static void main(String[] args) throws IOException, URISyntaxException {
        URL url = new URI("https://manuais.pages.iessanclemente.net/plantillas/dam/ad/").toURL();
        HttpURLConnection httpConnection = (HttpURLConnection) url.openConnection();  // Hereda de URLConnection
        httpConnection.getInputStream();
        httpConnection.setRequestMethod("HEAD");
        long tamanho = httpConnection.getContentLengthLong();
    }
}
