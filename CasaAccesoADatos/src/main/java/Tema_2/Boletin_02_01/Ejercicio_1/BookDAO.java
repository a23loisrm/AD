package Tema_2.Boletin_02_01.Ejercicio_1;

import java.sql.Connection;
import java.util.List;

public class BookDAO implements DAO<Book>{

    public Connection connection;

    public BookDAO(Connection connection){
        this.connection  =connection;
    }
    
    @Override
    public Book get(long id) {
        return null;
    }

    @Override
    public List<Book> getAll() {
        return List.of();
    }

    @Override
    public void save(Book book) {

    }

    @Override
    public void update(Book book) {

    }

    @Override
    public void delete(Book book) {

    }

    @Override
    public void deleteById(long id) {

    }

    @Override
    public void updateImage(Book book, String f) {

    }

    @Override
    public void updateImageById(long id, String f) {

    }

    @Override
    public void deleteAll() {

    }
}
