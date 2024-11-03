package org.example;

import java.util.Objects;

public final class Categoria {
    public static  final String DEFAULR_CATEGORY = "General Knowledge";
    private final String nome;


    public String getNome() {
        return nome;
    }

    public Categoria() {
        this.nome = DEFAULR_CATEGORY;
    }

    public Categoria(String nome) {
        this.nome = nome;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        return  (o instanceof Categoria categoria) && Objects.equals(nome, categoria.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(nome);
    }

    @Override
    public String toString() {
        return nome;
    }
}
