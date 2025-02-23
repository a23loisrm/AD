package Tema_2.Boletin_02_01.Ejercicio_1;

public class Book {

    private long idBook;
    private String isbn;
    private String title;
    private String author;
    private int ano;
    private boolean available;
    private byte[] portada;


    public Book() {
    }

    public Book(long idBook, String isbn, String title) {
        this.idBook = idBook;
        this.isbn = isbn;
        this.title = title;
    }

    public Book(long idBook, int ano, String author, String title, String isbn) {
        this.idBook = idBook;
        this.ano = ano;
        this.author = author;
        this.title = title;
        this.isbn = isbn;
    }

    public Book(String isbn, long idBook, String author, String title, int ano, boolean available, byte[] portada) {
        this.isbn = isbn;
        this.idBook = idBook;
        this.author = author;
        this.title = title;
        this.ano = ano;
        this.available = available;
        this.portada = portada;
    }

    public long getIdBook() {
        return idBook;
    }

    public void setIdBook(long idBook) {
        this.idBook = idBook;
    }

    public byte[] getPortada() {
        return portada;
    }

    public void setPortada(byte[] portada) {
        this.portada = portada;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
}
