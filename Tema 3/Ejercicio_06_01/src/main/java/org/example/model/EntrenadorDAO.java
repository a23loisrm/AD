package org.example.model;

import java.util.List;

public class EntrenadorDAO implements DAO<Entrenador, Integer>{

    @Override
    public Entrenador get(Integer id) {
        return null;
    }

    @Override
    public List<Entrenador> getAll() {
        return List.of();
    }

    @Override
    public boolean save(Entrenador obxecto) {
        return false;
    }

    @Override
    public boolean delete(Entrenador obx) {
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
    public void update(Entrenador obx) {

    }
}
