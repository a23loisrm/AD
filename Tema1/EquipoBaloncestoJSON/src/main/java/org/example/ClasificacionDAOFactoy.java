package org.example;

public class ClasificacionDAOFactoy {

    public static Dao<Clasificacion, String> getClasificacionDAO(String tipo) {
        if (tipo.equalsIgnoreCase("file")) {
            return ClasificacionFileDAO.getInstance();
        } else if (tipo.equalsIgnoreCase("json")) {
            return  ClasificacionJSONDAO.getInstance();
        } else {
            return null;
        }
    }

}
