package org.example.view;

public interface IVistaCodigoPostal {
    // Métodos para mostrar los datos al usuario
    /**
     * Muestra un mensaje de error en la vista.
     */
    void mostrarError(String mensaje);

    /**
     * Muestra añade un lugar a la lista de lugares de la vista.
     */
    public void addLugar(String lugar);

    /**
     * Borra la lista de lugares de la vista.
     */
    public void deleteLugares();

    /**
     * Añade un código postal a la lista de códigos postales de la vista.
     */
    public void setLugares(String lugares);

    /**
     * Asigna un controlador a la vista.
     * @param controller Controlador a asignar.
     */
    public void setController(ICodigoPostalController controller);

    /**
     * Muestrea la vista
     */
    public void mostrar();
}
