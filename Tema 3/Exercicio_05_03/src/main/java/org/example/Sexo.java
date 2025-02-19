package org.example;

public enum Sexo {
    HOMBRE("H"), MUJER("M");

    private String codigo;

    private Sexo(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }
}
