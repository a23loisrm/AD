package org.example;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.Period;

@Entity
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idPersona;
    private String nombre;
    private String apellidos;
    private LocalDate fechaNacimiento;
    @Convert(converter = SexoConverter.class)
    private Sexo sexo;
    @Convert(converter = EstadoCivilConverter.class)
    private EstadoCivil estadoCivil;
    @Lob
    private byte[] foto;

    transient private int edad;

    public Persona() {
    }

    public Persona(long idPersona, String nombre, String apellidos, LocalDate fechaNacimiento, Sexo sexo, EstadoCivil estadoCivil, byte[] foto) {
        this.idPersona = idPersona;
        this.nombre = capitalize(nombre);
        this.apellidos = capitalize(apellidos);
        this.fechaNacimiento = fechaNacimiento;
        this.sexo = sexo;
        this.estadoCivil = estadoCivil;
        this.foto = foto;
    }

    public long getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(long idPersona) {
        this.idPersona = idPersona;
    }

    public String getNombre() {
        return capitalize(nombre);
    }

    public void setNombre(String nombre) {
        this.nombre = capitalize(nombre);
    }

    public String getApellidos() {
        return capitalize(apellidos);
    }

    public void setApellidos(String apellidos) {
        this.apellidos = capitalize(apellidos);
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getEdad() {
        return edad;
    }

    @PrePersist
    @PostLoad
    private void postLoad() {
        if (fechaNacimiento != null) {
            this.edad = Period.between(fechaNacimiento, LocalDate.now()).getYears();
        }
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public EstadoCivil getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(EstadoCivil estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    private String capitalize(String input) {
        if (input == null || input.isEmpty()) {
            return input;
        }
        String[] words = input.toLowerCase().split(" ");
        StringBuilder capitalized = new StringBuilder();
        for (String word : words) {
            if (!word.isEmpty()) {
                capitalized.append(Character.toUpperCase(word.charAt(0)))
                        .append(word.substring(1)).append(" ");
            }
        }
        return capitalized.toString().trim();
    }

}
