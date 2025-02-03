package org.example;

import java.util.List;

public class EquipoDAO implements DAO<Equipo>{

    @Override
    public Equipo get(Object id) {
        return null;
    }

    @Override
    public List<Equipo> getAll() {
        return List.of();
    }

    @Override
    public boolean deleteAll() {
        return false;
    }

    @Override
    public boolean deleteById(Object id) {
        return false;
    }

    @Override
    public void update(Object obx) {

    }

    @Override
    public boolean delete(Object obx) {
        return false;
    }

    @Override
    public boolean save(Object obxecto) {
        return false;
    }
}
