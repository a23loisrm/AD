package Tema_1.Boletin_01_03.Ejercicio7;

import com.google.gson.annotations.Expose;

public class Sudoku {
    @Expose
    private int[][] grid; // La matriz de números del Sudoku

    @Expose
    private int size; // Tamaño del Sudoku (por ejemplo, 9 para un Sudoku 9x9)

    private String alphabet; // El alfabeto no debe ser serializado

    // Constructor
    public Sudoku(int[][] grid, int size, String alphabet) {
        this.grid = grid;
        this.size = size;
        this.alphabet = alphabet;
    }

    // Getters y Setters
    public int[][] getGrid() {
        return grid;
    }

    public void setGrid(int[][] grid) {
        this.grid = grid;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getAlphabet() {
        return alphabet;
    }

    public void setAlphabet(String alphabet) {
        this.alphabet = alphabet;
    }

    // Método toString para depuración
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int[] row : grid) {
            for (int num : row) {
                sb.append(num).append(" ");
            }
            sb.append("\n");
        }
        return "Sudoku:\n" + sb.toString() + "Size: " + size + "\nAlphabet: " + alphabet;
    }
}
