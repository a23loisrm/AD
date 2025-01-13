package Tema_1.Boletin_01_03.Ejercicio7;

import java.util.Arrays;

public class Sudoku {
    private int[][] datos; // Datos del Sudoku
    private transient String alfabeto; // No se serializa

    public Sudoku(int[][] datos, String alfabeto) {
        this.datos = datos;
        this.alfabeto = alfabeto;
    }

    public int[][] getDatos() {
        return datos;
    }

    public void setDatos(int[][] datos) {
        this.datos = datos;
    }

    public String getAlfabeto() {
        return alfabeto;
    }

    public void setAlfabeto(String alfabeto) {
        this.alfabeto = alfabeto;
    }

    @Override
    public String toString() {
        return "Sudoku{" +
                "datos=" + Arrays.deepToString(datos) +
                ", alfabeto='" + alfabeto + '\'' +
                '}';
    }
}
