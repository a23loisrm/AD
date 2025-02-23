package Tema_2.Boletin_02_01.Ejercicio_1;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionManager {

    private static volatile Connection instance;

    private ConnectionManager(){}

    public static Connection getInstance(){
        if (instance == null){
            try{
                synchronized (ConnectionManager.class){
                    if (instance == null){
                        instance = DriverManager.getConnection("");
                    }
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return instance;
    }

}
