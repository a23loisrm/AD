package Tema_1.Boletin_01_03.Ejercicio7;

public interface DAO<T, K> {

    // Para trabajar con objetos Java
    void saveToObject(T obj, K resource) throws Exception; // Guarda el objeto T en un recurso K
    T getFromObject(K resource) throws Exception;          // Recupera el objeto T desde un recurso K

    // Para trabajar con JSON
    void saveToJSON(T obj, K file) throws Exception;       // Guarda el objeto T en un archivo JSON especificado
    void saveToJSON(T obj) throws Exception;              // Guarda el objeto T en un archivo predeterminado
    T getFromJSON(K file) throws Exception;               // Recupera el objeto T desde un archivo JSON especificado
    T getFromJSON() throws Exception;                     // Recupera el objeto T desde un archivo predeterminado

    // Para trabajar con archivos de texto
    T getFromTXT(K resource) throws Exception;            // Recupera el objeto T desde un archivo de texto
}
