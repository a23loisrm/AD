package org.example.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Entrenador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idEntrenador;
    private String nombre;
    private LocalDate fechaNacimiento;
    private float salario;

    @OneToOne(mappedBy = "entrenador")
    private Equipo equipo;

    public Entrenador() {
    }

    public Entrenador(long idEntrenador, String nombre, LocalDate fechaNacimiento, float salario, Equipo equipo) {
        this.idEntrenador = idEntrenador;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.salario = salario;
        this.equipo = equipo;
    }

    public long getIdEntrenador() {
        return idEntrenador;
    }

    public void setIdEntrenador(long idEntrenador) {
        this.idEntrenador = idEntrenador;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Entrenador{" +
                "idEntrenador=" + idEntrenador +
                ", nombre='" + nombre + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                ", salario=" + salario +
                ", equipo=" + equipo +
                '}';
    }
}
