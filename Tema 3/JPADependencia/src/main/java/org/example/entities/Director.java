package org.example.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Director {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long idDirector;
    private String nome;
    private String apelidos;
    private String nacionalidade;

    @OneToMany(mappedBy = "director")
    private List <Pelicula> peliculas;

    public Director() {
    }

    public Director(Long idDirector, String nome, String apelidos, String nacionalidade) {
        this.idDirector = idDirector;
        this.nome = nome;
        this.apelidos = apelidos;
        this.nacionalidade = nacionalidade;
    }

    public Director(String nome, String apelidos, String nacionalidade) {
        this.nome = nome;
        this.apelidos = apelidos;
        this.nacionalidade = nacionalidade;
    }

    public Long getIdDirector() {
        return idDirector;
    }

    public void setIdDirector(Long idDirector) {
        this.idDirector = idDirector;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getApelidos() {
        return apelidos;
    }

    public void setApelidos(String apelidos) {
        this.apelidos = apelidos;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    @Override
    public String toString() {
        return "[" + idDirector + "] " + nome + " " + apelidos + " (" + nacionalidade + ')';
    }
}
