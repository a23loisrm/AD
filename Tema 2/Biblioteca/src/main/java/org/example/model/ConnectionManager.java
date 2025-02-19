package org.example.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
    private Connection conexion;
    private static ConnectionManager instance;

    private static String URL = "jdbc:h2:L:\\AccesoADatos\\Tema 2\\BasesDeDatos\\biblioteca2";

    public ConnectionManager() {

    }

    public ConnectionManager getInstance(){
        if (instance == null){
            return instance = new ConnectionManager();
        }
        return instance;
    }

    public  static Connection getConexion() {
        Connection conexion = null;
        try {
            if (conexion == null) {
                try {
                    conexion = DriverManager.getConnection(URL);
                } catch (SQLException ex) {
                    System.err.println("Error al establecer la conexión: " + ex.getMessage());
                }
            }
        } catch (Exception e) {
            System.err.println("Error al establecer la conexión: "+e.getMessage());
        }
        return conexion;
    }
}