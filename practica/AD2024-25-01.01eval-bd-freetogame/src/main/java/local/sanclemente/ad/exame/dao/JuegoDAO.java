package local.sanclemente.ad.exame.dao;

import local.sanclemente.ad.exame.model.Genero;
import local.sanclemente.ad.exame.model.Juego;
import local.sanclemente.ad.exame.model.Plataforma;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class JuegoDAO implements DAO<Juego, Integer>{
    private final Connection con;

    public JuegoDAO(GameConnectionMaganer gameConnectionMaganer) {
        this.con = gameConnectionMaganer.getConnection();
    }

    @Override
    public Juego getById(Integer id) {
        Juego juego = null;
        String query = "SELECT * FROM JUEGO WHERE IDJUEGO = ?";
        try(var stmt = con.prepareStatement(query)){
            stmt.setInt(1,id);
            var rs = stmt.executeQuery();

            if (rs.next()){
                juego = new Juego(
                        rs.getInt("IDJUEGO"),
                        new Genero(rs.getInt("IDGENERO")),
                        new Plataforma(rs.getInt("IDPLATAFORMA")),
                        rs.getString("TITULO"),
                        rs.getString("MINIATURA"),
                        rs.getString("ESTADO"),
                        rs.getString("DESCRIPCIONCORTA"),
                        rs.getString("DESCRIPCION"),
                        rs.getString("URL"),
                        rs.getString("EDITOR"),
                        rs.getString("DESARROLLADOR"),
                        LocalDate.parse(rs.getString("FECHA"))
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return juego;
    }

    @Override
    public List<Juego> getAll() {
        List<Juego> listaDeJuegos = new ArrayList<>();
        String query = "SELECT * FROM JUEGO";

        try(var stmt = con.prepareStatement(query)){
            var rs = stmt.executeQuery();

            while (rs.next()){
                listaDeJuegos.add(new Juego(
                        rs.getInt("IDJUEGO"),
                        new Genero(rs.getInt("IDGENERO")),
                        new Plataforma(rs.getInt("IDPLATAFORMA")),
                        rs.getString("TITULO"),
                        rs.getString("MINIATURA"),
                        rs.getString("ESTADO"),
                        rs.getString("DESCRIPCIONCORTA"),
                        rs.getString("DESCRIPCION"),
                        rs.getString("URL"),
                        rs.getString("EDITOR"),
                        rs.getString("DESARROLLADOR"),
                        LocalDate.parse(rs.getString("FECHA"))));
                }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaDeJuegos;
    }
}
