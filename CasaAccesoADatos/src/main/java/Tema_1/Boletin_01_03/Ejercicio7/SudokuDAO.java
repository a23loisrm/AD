package Tema_1.Boletin_01_03.Ejercicio7;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SudokuDAO implements DAO<Sudoku, String>{

    private  String JSON_FILE;
    private  Gson gson;


    // Constructor sin argumentos
    public SudokuDAO() {
        this.JSON_FILE = "sudoku.json";
        this.gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
    }

    // Constructor con archivo JSON
    public SudokuDAO(String JSON_FILE) {
        this.JSON_FILE = JSON_FILE;
        this.gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
    }


    @Override
    public void saveToObject(Sudoku obj, String resource) throws Exception {
        Path path = Paths.get(resource);
        try(ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(Files.newOutputStream(path)))){
            oos.writeObject(obj);
            System.out.println("Sudoku guarado correctamente en: "+resource);
        }
    }

    @Override
    public Sudoku getFromObject(String resource) throws Exception {
        Path path = Paths.get(resource);
        try(ObjectInputStream iis = new ObjectInputStream(new BufferedInputStream(Files.newInputStream(path)))){
            //Leer el objeto deserializado  desde el archivo
            Sudoku sudoku = (Sudoku) iis.readObject();
            System.out.println("Sudoku cargado correctamente desde: " + resource);
            return sudoku;

        }
    }

    @Override
    public void saveToJSON(Sudoku obj, String file) throws Exception {
        try(BufferedWriter bw = Files.newBufferedWriter(Paths.get(file))){
            //Convertir el objeto a JSON
            String json = gson.toJson(obj);
            bw.write(json);
            System.out.println("Clasificacion guardad en formato JSON en: "+file);
        }
    }

    @Override
    public void saveToJSON(Sudoku obj) throws Exception {
        saveToJSON(obj, JSON_FILE);
    }

    @Override
    public Sudoku getFromJSON(String file) throws Exception {
        Path path = Paths.get(file);
        try(BufferedReader br = Files.newBufferedReader(path)){
            // Leer el contenido del archivo JSON y deserializarlo
            Sudoku sudoku = gson.fromJson(br, Sudoku.class);
            System.out.println("Sudoku cargado correctamente desde: "+file);
            return sudoku;
        }
    }

    @Override
    public Sudoku getFromJSON() throws Exception {
        return getFromJSON(JSON_FILE);
    }

    @Override
    public Sudoku getFromTXT(String resource) throws Exception {
        Path path  =Paths.get(resource);
        try(FileReader fr = new FileReader(String.valueOf(path))){
            //Leer el contenido del archivo TXT y derelializarlo
            Sudoku sudoku  =gson.fromJson(fr, Sudoku.class);
            System.out.println("Sudoku cargado correctamente desde: "+resource);
            return sudoku;
        }
    }
}