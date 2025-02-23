package local.sanclemente.ad.exame.dao;

import local.sanclemente.ad.exame.model.Plataforma;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PlataformaDAO implements DAO<Plataforma, Integer>{

    private final Connection con;

    public PlataformaDAO(GameConnectionMaganer gameConnectionMaganer) {
        this.con = gameConnectionMaganer.getConnection();
    }

    @Override
    public Plataforma getById(Integer id) {
        Plataforma plataforma = null;
        String query = "SELECT * FROM PLATAFORMA WHERE IDPLATAFORMA = ?";
        try(var stmt = con.prepareStatement(query)){
            stmt.setInt(1, id);
            var rs = stmt.executeQuery();

            if (rs.next()){
                plataforma = new Plataforma(rs.getInt("IDPLATAFORMA"), rs.getString("NOMBRE"));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return plataforma;
    }

    @Override
    public List<Plataforma> getAll() {
        List<Plataforma> listaDePlataformas = new ArrayList<>();
        String query = "SELECT * FROM PLATAFORMA";
        try(var stmt = con.prepareStatement(query)){
            var rs = stmt.executeQuery();

            while(rs.next()){
                listaDePlataformas.add(new Plataforma(rs.getInt("IDPLATAFORMA"), rs.getString("NOMBRE")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaDePlataformas;
    }
}
