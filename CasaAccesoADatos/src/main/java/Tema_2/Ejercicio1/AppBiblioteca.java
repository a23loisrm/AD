package Tema_2.Ejercicio1;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

public class AppBiblioteca {
    public static void main(String[] args) {
        try {
            // Obtener la conexión
            Connection dbConnection = ConnectionManager.getInstance();
            Statement statement = dbConnection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

            // Crear un objeto BookDAO con la conexión
            BookDAO bookDAO = new BookDAO(dbConnection);

            // a) Añade libros a la base de datos
            Book libro1 = new Book();
            libro1.setIsbn("9788424937744")
                    .setTitle("Tractatus logico-philosophicus - investigaciones filosóficas")
                    .setAuthor("Ludwig Wittgenstein")
                    .setAno(2017)
                    .setAvailable(false);
            bookDAO.save(libro1);

            Book libro2 = new Book();
            libro2.setIsbn("9788499088150")
                    .setTitle("Verano")
                    .setAuthor("J. M. Coetzee")
                    .setAno(2011)
                    .setAvailable(true);
            bookDAO.save(libro2);

            // Mostrar contenido de la base de datos
            System.out.println("Contenido de la base de datos:");
            bookDAO.getAll().forEach(System.out::println);

            // b) Ejecutar el proceso Batch para insertar varios libros
            insertBatch(statement);

            // Mostrar contenido actualizado
            System.out.println("Contenido de la base de datos después del batch:");
            bookDAO.getAll().forEach(System.out::println);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void insertBatch(Statement statement) {
        try {
            // Consultas Batch
            statement.addBatch("INSERT INTO PUBLIC.Book (isbn, title, author, ano, available, portada) " +
                    "VALUES ('9780307277672', 'Cien años de soledad', 'Gabriel García Márquez', 1967, TRUE, NULL)");
            statement.addBatch("INSERT INTO PUBLIC.Book (isbn, title, author, ano, available, portada) " +
                    "VALUES ('9780743273565', 'Harry Potter y la piedra filosofal', 'J.K. Rowling', 1997, TRUE, NULL)");
            statement.addBatch("INSERT INTO PUBLIC.Book (isbn, title, author, ano, available, portada) " +
                    "VALUES ('9780307959474', 'The Sense of an Ending', 'Julian Barnes', 2011, TRUE, NULL)");
            statement.addBatch("INSERT INTO PUBLIC.Book (isbn, title, author, ano, available, portada) " +
                    "VALUES ('9780307386672', 'No Country for Old Men', 'Cormac McCarthy', 2005, TRUE, NULL)");
            statement.addBatch("INSERT INTO PUBLIC.Book (isbn, title, author, ano, available, portada) " +
                    "VALUES ('9781400064168', 'The Road', 'Cormac McCarthy', 2006, TRUE, NULL)");
            statement.addBatch("INSERT INTO PUBLIC.Book (isbn, title, author, ano, available, portada) " +
                    "VALUES ('9780099590088', 'The Noise of Time', 'Julian Barnes', 2016, TRUE, NULL)");
            statement.addBatch("INSERT INTO PUBLIC.Book (isbn, title, author, ano, available, portada) " +
                    "VALUES ('9780307277672', 'All the Pretty Horses', 'Cormac McCarthy', 1992, TRUE, NULL)");
            statement.addBatch("INSERT INTO PUBLIC.Book (isbn, title, author, ano, available, portada) " +
                    "VALUES ('9780099590088', 'Levels of Life', 'Julian Barnes', 2013, TRUE, NULL)");

            // Ejecutar el Batch
            statement.executeBatch();
            System.out.println("Batch insert completado con éxito.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
