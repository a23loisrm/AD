package org.example.view;

public interface ICodigoPostalController {
    /**
     * Obtiene la lista de lugaros a partir de un código postal. Si no se encuentra el código postal
     * devuelve null.
     *
     * @param codigoPostal Código postal como cadena de texto
     * @param asHTML       Devuelve los datos en formato HTML
     * @return Lista de lugares como cadena o null si no se ha podido obtener
     */
    public String getLugares(String codigoPostal, boolean asHTML);

    /**
     * Obtiene la lista de lugares a partir de un código postal y un país. Si no se encuentra el código postal
     * devuelve null.
     *
     * @param codigoPostal Código postal como cadena de texto
     * @param pais         País como cadena de texto ("es", "fr", "us", etc.)
     * @param asHTML Devuelve los datos en formato HTML
     * @return  Lista de lugares como cadena o null si no se ha podido obtener
     */
    public String getLugares(String codigoPostal, String pais, boolean asHTML);

    /**
     * Asigna la lista de lugares a la vista a partir de un código postal con el pais por defecto.
     * Si no se encuentra el código postal devuelve null.
     * @param codigoPostal
     * @param asHTML
     */
    public void setLugares(String codigoPostal, boolean asHTML);

    public void setVista(IVistaCodigoPostal vista);
}
