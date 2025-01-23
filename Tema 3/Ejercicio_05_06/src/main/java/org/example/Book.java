package org.example;

import java.time.LocalDate;
import java.util.Arrays;

public class Book {

    private long idBook;
    private String isbn;
    private String title;
    private String autor;
    private Short ano;
    private boolean available;
    private byte[] portada;
    private LocalDate dataPublicacion;

    public Book(long idBook, String isbn, String title, String autor, Short ano, boolean available, byte[] portada, LocalDate dataPublicacion) {
        this.idBook = idBook;
        this.isbn = isbn;
        this.title = title;
        this.autor = autor;
        this.ano = ano;
        this.available = available;
        this.portada = portada;
        this.dataPublicacion = dataPublicacion;
    }

    public Book(long idBook, String isbn, String title, String autor, Short ano, boolean available) {
        this.idBook = idBook;
        this.isbn = isbn;
        this.title = title;
        this.autor = autor;
        this.ano = ano;
        this.available = available;
    }

    public long getIdBook() {
        return idBook;
    }

    public void setIdBook(long idBook) {
        this.idBook = idBook;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Short getAno() {
        return ano;
    }

    public void setAno(Short ano) {
        this.ano = ano;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public byte[] getPortada() {
        return portada;
    }

    public void setPortada(byte[] portada) {
        this.portada = portada;
    }

    public LocalDate getDataPublicacion() {
        return dataPublicacion;
    }

    public void setDataPublicacion(LocalDate dataPublicacion) {
        this.dataPublicacion = dataPublicacion;
    }

    @Override
    public String toString() {
        return "Book{" +
                "idBook=" + idBook +
                ", isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                ", autor='" + autor + '\'' +
                ", ano=" + ano +
                ", available=" + available +
                ", portada=" + Arrays.toString(portada) +
                ", dataPublicacion=" + dataPublicacion +
                '}';
    }
}
