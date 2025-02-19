package org.example.model;

import java.util.List;

public class EquipoDAO implements DAO<Equipo, Integer>{


    @Override
    public Equipo get(Integer id) {
        return null;
    }

    @Override
    public List<Equipo> getAll() {
        return List.of();
    }

    @Override
    public boolean save(Equipo obxecto) {
        return false;
    }

    @Override
    public boolean delete(Equipo obx) {
        return false;
    }

    @Override
    public boolean deleteAll() {
        return false;
    }

    @Override
    public boolean deleteById(Integer id) {
        return false;
    }

    @Override
    public void update(Equipo obx) {

    }
}
