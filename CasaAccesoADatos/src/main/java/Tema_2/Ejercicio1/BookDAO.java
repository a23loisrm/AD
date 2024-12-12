package Tema_2.Ejercicio1;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {
    private Connection con;

    public BookDAO(Connection con) {
        this.con = con;
    }

    // Obtener un libro por su ID
    public Book get(long idBook) {
        String query = "SELECT * FROM Book WHERE idBook = ?";
        try (PreparedStatement stmt = con.prepareStatement(query)) {
            stmt.setLong(1, idBook);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return parseBook(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Obtener todos los libros
    public List<Book> getAll() {
        List<Book> books = new ArrayList<>();
        String query = "SELECT * FROM Book";
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                books.add(parseBook(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }

    // Guardar un nuevo libro
    public void save(Book book) {
        String query = "INSERT INTO Book (isbn, title, author, ano, available, portada) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, book.getIsbn());
            stmt.setString(2, book.getTitle());
            stmt.setString(3, book.getAuthor());
            stmt.setInt(4, book.getAno());
            stmt.setBoolean(5, book.isAvailable());
            stmt.setBytes(6, book.getPortada());
            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                book.setIdBook(rs.getLong(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Actualizar un libro
    public void update(Book book) {
        String query = "UPDATE Book SET isbn = ?, title = ?, author = ?, ano = ?, available = ?, portada = ? WHERE idBook = ?";
        try (PreparedStatement stmt = con.prepareStatement(query)) {
            stmt.setString(1, book.getIsbn());
            stmt.setString(2, book.getTitle());
            stmt.setString(3, book.getAuthor());
            stmt.setInt(4, book.getAno());
            stmt.setBoolean(5, book.isAvailable());
            stmt.setBytes(6, book.getPortada());
            stmt.setLong(7, book.getIdBook());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Eliminar un libro por objeto
    public void delete(Book book) {
        deleteById((int) book.getIdBook());
    }

    // Eliminar un libro por ID
    public void deleteById(int idBook) {
        String query = "DELETE FROM Book WHERE idBook = ?";
        try (PreparedStatement stmt = con.prepareStatement(query)) {
            stmt.setInt(1, idBook);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Eliminar todos los libros
    public void deleteAll() {
        String query = "DELETE FROM Book";
        try (Statement stmt = con.createStatement()) {
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Métodos no implementados
    public void updateImage(Book book, String f) {
        throw new UnsupportedOperationException("Método no implementado.");
    }

    public void updateImageByID(long idBook, String f) {
        throw new UnsupportedOperationException("Método no implementado.");
    }

    // Método auxiliar para convertir un ResultSet a un objeto Book
    private Book parseBook(ResultSet rs) throws SQLException {
        return new Book(
                rs.getLong("idBook"),
                rs.getString("isbn"),
                rs.getString("title"),
                rs.getString("author"),
                rs.getInt("ano"),
                rs.getBoolean("available"),
                rs.getBytes("portada")
        );
    }
}
