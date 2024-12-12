## Que es serializar y deserializar

Serializacion es escribir el objeto en un archivo y deserializar 
es leer de un archivo.


## Creacion de la clase DAO


#### 1. Primero creamos la interface DAO
Primero vamos a crear la interface DAO que tendrá la suguiente estructura:
```java
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
```
Descrito rápidamente, va a tener la estructura que va a tener nuestro archivoDAO, es decir, es una interface para poder
implementarla en varias zonas del código.

Como vemos hacemos referencia a el objeto y al recurso, en el caso de este ejemplo el 
objeto era el Sudoku y el recurso el archivo.


### 2. Creación de la clase DAO

