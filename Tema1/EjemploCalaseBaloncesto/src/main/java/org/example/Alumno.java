package org.example;


import java.util.Objects;

public class Alumno {
    private String nome;
    private String email;
    private Integer idade;

    public Alumno(){

    }

    public Alumno(String nome){
        this.nome = nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Alumno(Integer idade) {
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public Integer getIdade() {
        return idade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Alumno alumno = (Alumno) o;
        return Objects.equals(nome, alumno.nome) && Objects.equals(email, alumno.email) && Objects.equals(idade, alumno.idade);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, email, idade);
    }
}