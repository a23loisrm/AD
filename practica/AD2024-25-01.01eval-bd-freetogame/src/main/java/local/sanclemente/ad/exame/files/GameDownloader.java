package local.sanclemente.ad.exame.files;

import local.sanclemente.ad.exame.dao.GameConnectionMaganer;

import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GameDownloader {

    public static final String DIRECTORY = "C:\\Users\\dam2ad\\Desktop\\download\\";

    private static final Path directorioImagenes = Paths.get(DIRECTORY);

    public static void downloadDescriptions(Connection con) {
        String sql = "SELECT idJuego, descripcion FROM juego"; // 📌 Ajustar según la estructura de tu DB

        try (var stmt = con.prepareStatement(sql);
             var rs = stmt.executeQuery()) {

            while (rs.next()) {
                int idJuego = rs.getInt("idJuego");
                String descripcion = rs.getString("descripcion");

                Path descriptionPath = directorioImagenes.resolve(idJuego + ".txt");

                // 📌 Guardar la descripción en un archivo
                try (BufferedWriter writer = Files.newBufferedWriter(descriptionPath)) {
                    writer.write(descripcion);
                    System.out.println("📝 Descripción guardada: " + descriptionPath);

                } catch (IOException e) {
                }
            }
            System.out.println("✅ Descarga de descripciones completada.");

        } catch (SQLException e) {
            System.err.println("❌ Error al obtener las descripciones: " + e.getMessage());
        }
    }



    public static void downloadImages(Connection con){
        String query = "SELECT idJuego, idImagen, url FROM IMAGEN";
        try(var stmt = con.prepareStatement(query)){
            var rs = stmt.executeQuery();

            while (rs.next()){
                int idJuego = rs.getInt("idJuego");
                long idImagen = rs.getLong("idImagen");
                String imageUrl = rs.getString("url");

                Path imagePath = directorioImagenes.resolve(idJuego + "-" + idImagen + ".png");


                try (InputStream in = new URL(imageUrl).openStream();
                     BufferedInputStream bis = new BufferedInputStream(in);
                     BufferedOutputStream bos = new BufferedOutputStream(Files.newOutputStream(imagePath))) {

                    byte[] buffer = new byte[1024];
                    int bytesRead;
                    while ((bytesRead = bis.read(buffer)) != -1) {
                        bos.write(buffer, 0, bytesRead);
                    }
                    System.out.println("📸 Imagen descargada: " + imagePath);

                } catch (IOException e) {
                    System.err.println("❌ Error al descargar la imagen: " + imageUrl + " - " + e.getMessage());
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public static void main(String[] args) throws IOException {

        if (!Files.exists(directorioImagenes)){
            Files.createFile(directorioImagenes);
        }else{
            GameConnectionMaganer connectionMaganer = GameConnectionMaganer.getInstance();

            downloadImages(connectionMaganer.getConnection());
            downloadDescriptions(connectionMaganer.getConnection());
        }

    }
}
