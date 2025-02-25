/*
 * Autor: Pepe Calo
 * Realizado con fines educativos.
 * Puede modificarlo siempre que no lo haga con fines comerciales.
 */
package local.sanclemente.ad.exame.dao;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @author pepecalo
 */
public class GameConnectionMaganer {

    public static final String URL = "jdbc:h2:C:\\Users\\loisr\\Desktop\\2DAM-AD\\2DAM-AD\\FreeToGameExame;DB_CLOSE_ON_EXIT=TRUE;" +
            "DATABASE_TO_UPPER=FALSE;FILE_LOCK=NO";

    public static final String DRIVER = "org.h2.Driver";

    private static GameConnectionMaganer instance;

    private Connection conexion;

    public GameConnectionMaganer() {
    }

    public static GameConnectionMaganer getInstance(){
        if (instance == null){
            synchronized (GameConnectionMaganer.class){
                if (instance == null){
                    instance = new GameConnectionMaganer();
                }
            }
        }

        return instance;
    }

    public Connection getConnection() {

        try{
            if (conexion == null || conexion.isClosed()){
                synchronized (GameConnectionMaganer.class){
                    if (conexion == null){
                        try{
                            Class.forName(DRIVER);
                            conexion = DriverManager.getConnection(URL);
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }
        } catch (Exception e) {
            System.err.println("Error al encontrar conectarse con la base de datos: "+e);
        }

        return conexion;
    }


}
