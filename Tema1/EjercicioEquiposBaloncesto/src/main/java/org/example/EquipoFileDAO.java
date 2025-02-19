package org.example;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class EquipoFileDAO implements DAO<Equipo, String>{

    private final Path path;



    public EquipoFileDAO(Path path){
        this.path = path;
    }
    @Override
    public Equipo get(String id) {
        List<Equipo> equipos = getAll();
        for(Equipo equipo: equipos){
            if (equipo.getNombre().equalsIgnoreCase(id)){
                return equipo;
            }
        }
        return null;
    }

    @Override
    public List<Equipo> getAll() {
        List<Equipo> equipos = new ArrayList<>();
        if (Files.exists(path)) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path.toFile()))) {
                while (true) {
                    try {
                        Equipo equipo = (Equipo) ois.readObject();
                        equipos.add(equipo);
                    } catch (EOFException eof) {
                        break;
                    }
                }
            } catch (IOException | ClassNotFoundException e) {
                System.out.println("Error al leer el archivo: " + e.getMessage());
            }
        }
        return equipos;
    }

    @Override
    public boolean save(Equipo obxecto) {
        boolean append = Files.exists(path);
        try (FileOutputStream fos = new FileOutputStream(path.toFile(), append);
             ObjectOutputStream oos = append ? new EquipoOutputStream(fos) : new ObjectOutputStream(fos)) {
            oos.writeObject(obxecto);
            return true;
        } catch (IOException e) {
            System.out.println("Erro de Entrada/Saída");
            return false;
        }
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
    public boolean deleteById(String id) {
        return false;
    }

    @Override
    public void update(Equipo equipo) {
        deleteById(equipo.getNombre());
        save(equipo);
    }
}
