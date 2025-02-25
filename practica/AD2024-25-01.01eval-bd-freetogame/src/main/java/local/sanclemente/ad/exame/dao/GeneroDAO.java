package local.sanclemente.ad.exame.dao;

import local.sanclemente.ad.exame.model.Genero;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GeneroDAO implements DAO<Genero, Integer>{

    private final Connection con;


    public GeneroDAO(GameConnectionMaganer gameConnectionMaganer) {
        this.con = gameConnectionMaganer.getConnection();
    }

    @Override
    public Genero getById(Integer id) {
        Genero genero = null;
        String query = "SELECT * FROM GENERO WHERE IDGENERO = ?";
        try(var stmt = con.prepareStatement(query)){
            stmt.setInt(1, id);
            var rs = stmt.executeQuery();

            if (rs.next()){
                int idGenero = rs.getInt("IDGENERO");
                String nombreGenero = rs.getString("NOMBRE");
                genero = new Genero(idGenero, nombreGenero);
            }


        } catch (SQLException e) {
            System.err.println("Error al encontrar el ID: "+e);
        }
        return genero;
    }

    @Override
    public List<Genero> getAll() {
        List<Genero> listaDeGeneros = new ArrayList<>();
        String query = "SELECT * FROM GENERO";

        try(var stmt = con.prepareStatement(query)){
            var rs = stmt.executeQuery();

            while (rs.next()){
                Genero genero = new Genero(rs.getInt("IDGENERO"), rs.getString("NOMBRE"));
                listaDeGeneros.add(genero);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaDeGeneros;
    }
}
