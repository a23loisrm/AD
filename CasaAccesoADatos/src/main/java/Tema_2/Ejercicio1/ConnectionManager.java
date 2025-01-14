package Tema_2.Ejercicio1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager{
    private static volatile Connection instance;

    private ConnectionManager(){
    }

    public static Connection getInstance() throws SQLException {
        if (instance == null) {
            synchronized (ConnectionManager.class) {
                if (instance == null) {
                    instance = DriverManager.getConnection("urldelabassededatos");
                }
            }
        }
        return instance;
    }
}
