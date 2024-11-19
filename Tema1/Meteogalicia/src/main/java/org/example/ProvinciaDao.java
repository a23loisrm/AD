package org.example;

import java.util.List;

public class ProvinciaDao implements Dao <Provincia, Integer>{
    @Override
    public Provincia getById(Integer id) {
        return null;
    }

    @Override
    public Provincia getByName(String name) {
        return null;
    }

    @Override
    public List<Provincia> getAll() {
        return List.of();
    }
}
