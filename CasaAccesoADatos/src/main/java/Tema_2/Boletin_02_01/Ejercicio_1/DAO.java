package Tema_2.Boletin_02_01.Ejercicio_1;

import java.util.List;

public interface DAO<T> {

    T get(long id);
    List<T> getAll();
    void save(T t);
    void update(T t);
    void delete(T t);
    public void deleteById(long id);
    public void updateImage(T t, String f);
    public void updateImageById(long id, String f);
    void deleteAll();

}
