package Tema_2.Ejercicio1;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;
import javax.imageio.ImageIO;

public class Book {
    private long idBook;
    private String isbn;
    private String title;
    private String author;
    private int ano;
    private boolean available;
    private byte[] portada;

    // Constructor vacío
    public Book() {}

    // Constructor con parámetros
    public Book(long idBook, String isbn, String title, String author, int ano, boolean available, byte[] portada) {
        this.idBook = idBook;
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.ano = ano;
        this.available = available;
        this.portada = portada;
    }

    // Getters y Setters

    public long getIdBook() {
        return idBook;
    }

    public Book setIdBook(long idBook) {
        this.idBook = idBook;
        return this;
    }

    public String getIsbn() {
        return isbn;
    }

    public Book setIsbn(String isbn) {
        this.isbn = isbn;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public Book setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getAuthor() {
        return author;
    }

    public Book setAuthor(String author) {
        this.author = author;
        return this;
    }

    public int getAno() {
        return ano;
    }

    public Book setAno(int ano) {
        this.ano = ano;
        return this;
    }

    public boolean isAvailable() {
        return available;
    }

    public Book setAvailable(boolean available) {
        this.available = available;
        return this;
    }

    public byte[] getPortada() {
        return portada;
    }

    public Book setPortada(byte[] portada) {
        this.portada = portada;
        return this;
    }

    // Asigna una portada desde un archivo (Path)
    public Book setPortada(Path f) throws IOException {
        this.portada = Files.readAllBytes(f);
        return this;
    }

    // Asigna una portada desde una ruta (String)
    public Book setPortada(String f) throws IOException {
        return setPortada(Path.of(f));
    }

    // Crea una imagen desde la portada
    public BufferedImage getImage() throws IOException {
        if (portada != null) {
            ByteArrayInputStream flujo = new ByteArrayInputStream(portada);
            return ImageIO.read(flujo);
        }
        return null;
    }

    // Equals y hashCode basados en el ISBN
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(isbn, book.isbn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isbn);
    }

    // toString: Título, autor y año. Indica * si no está disponible
    @Override
    public String toString() {
        return title + ", " + author + ", " + ano + (available ? "" : " *");
    }
}
