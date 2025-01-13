package Tema_1.Boletin_01_03.Ejercicio7;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SudokuDAO {
    private static String JSON_FILE = "sudoku.json";

    private Gson gson;

    public SudokuDAO(){
        this.gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
    }

    public void saveToObject(Sudoku c, String ruta){
        try{
            Path path = Paths.get(ruta);
            try(ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(Files.newOutputStream(path)))) {
                //Leemos el objeto deserializado desde el archivo
                oos.writeObject(c);
                System.out.println("Archivo guardado en el archivo "+ruta);
            } catch (IOException e) {
                System.err.println("Error al guardar el sudoku como Objeto: "+e.getMessage());            }
        } catch (RuntimeException e) {
            System.err.println("Error al guardar el sudoku como Objeto: "+e.getMessage());            }
    }

    public Sudoku getFromObject(String ruta){
        
    }
}
