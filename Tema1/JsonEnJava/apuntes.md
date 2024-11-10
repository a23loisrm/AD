## JSON en Java

Podemos usar json para leer y guardar datos de datos de forma rápida.

Recordar que un json tiene la siguiente **estructura**:
```JSON
{
  "Equipos": [
    {
      "equipo": "Real Madrid",
      "jugados": 4,
      "victorias": 4,
      "derrotas": 0,
      "favor": 374,
      "contra": 311,
      "diferencia": 63
    },
    {
    "equipo": "Baskonia",
    "jugados": 4,
    "victorias": 3,
    "derrotas": 1,
    "favor": 346,
    "contra": 320,
    "diferencia": 26
    }
  ]
}

```


### Ejercicio 3 del Boletín 01_03

Crea un proyecto Maven con una sencilla clase Examen que contenga los siguientes
atributos:
- materia: de tipo String.
- fecha: de tipo LocalDateTime.
- participantes: de tipo List de String con los nombres de los estudiantes.

Crea los métodos get/set que consideres adecuados, así como un método
toString() que devuelva la materia, la fecha seguida de la lista de participantes (emplea
StringBuilder).

Crea una sencilla aplicación que cree un examen de “Acceso a Datos” para el 12
de noviembre del 2023 a las 9:45 horas, con 5 estudiantes con nombres de poetas
femeninas del siglo XX.

Guarda el examen en un archivo JSON llamado accesoADatos.json mediante el
api de JSON-B y muestre el contenido del archivo por pantalla, utilizando Files de Java
NIO.2 y recupere el archivo para guardarlo en un nuevo objeto Java.

**Explicación del ejercicio:**


Primero nos pide que cremos las clase Examen, con sus respectivos atributos
```java
public class Examen {
    public String materia;
    public LocalDateTime fecha;
    public List<String> participantes;

    public Examen(String materia, LocalDateTime fecha, List<String> participantes) {
        this.materia = materia;
        this.fecha = fecha;
        this.participantes = participantes;
    }

    public List<String> getParticipantes() {
        return participantes;
    }

    public void setParticipantes(List<String> participantes) {
        this.participantes = participantes;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Materia: ").append(materia).append("\n");
        sb.append("Fecha: ").append(fecha).append("\n");
        sb.append("Participantes:\n");
        for (String participante : participantes) {
            sb.append(participante).append("\n");
        }
        return sb.toString();
    }
}
```
y ahora el **main**:
````java

public static void main(String[] args) {
        File file = new File("accesoADatos.json");
        List<String> p = List.of("Pepe", "Nicolas", "Laura", "Lucia");
        LocalDateTime fecha = LocalDateTime.of(2023,11,12,9,45);
        Examen examen = new Examen("Acceso a datos", fecha, p);

        JsonbConfig config = new JsonbConfig().withFormatting(true);
        Jsonb jsonb = JsonbBuilder.create(config);

        //Convertir el objeto Java a JSON
        String strJson = jsonb.toJson(examen);

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))){
            bw.write(strJson);
            if (file.exists()) {
                System.out.println("JSON escrito en el archivo");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

````
Usamos el **JsonConfig** para darle el formato de json al texto, si no lo creamos, se imprimiría todo en una misma línea.


## JsonSerializer y Json Deserializer

### **¿Qué es la serialización y deserialización?**

- **Serialización:** Es el proceso de convertir un objeto de una clase en un formato que pueda ser almacenado o transmitido, como un archivo o cadena de texto. En este caso, el formato es JSON.

- **Deserialización:** Es el proceso inverso, convertir un formato (JSON) en un objeto de una clase.

Para hacer la serialización y deserialización, necesitamos implementar las interfaces **JsonbSerializer** y **JsonbDeserializer**.

Por ejemplo, vamos a explicarlo con este ejercicio:

**Ejercicio 1: Serialización y deserialización básica** _Serializar y deserializar una clase sencilla con atributos básicos._

Crea una clase Persona con atributos nombre y edad. Implementa un JsonSerializer y un JsonDeserializer para esta clase, personalizando los nombres de los atributos en el JSON resultante, de modo que aparezcan como name y age en formato JSON.

```java
//Creamos la clase Persona e implementamos los métodos de serialización y deserialización

public class Persona implements JsonSerializer<Persona>, JsonDeserializer <Persona> {
    public String nombre;
    public Integer edad;

    public Persona(String nombre, Integer edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    //Métodos de serialización y deserialización
    @Override
    public Persona deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject jsonObject = jsonElement.getAsJsonObject();
        String nombre = jsonObject.get("name").getAsString();
        Integer edad = jsonObject.get("age").getAsInt();
        return new Persona(nombre, edad);
    }

    @Override
    public JsonElement serialize(Persona persona, Type type, JsonSerializationContext jsonSerializationContext) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("name", persona.getNombre());
        jsonObject.addProperty("age", persona.getEdad());
        return jsonObject;
    }
}
```

Ahora vamos a crear el **main** para probar la serialización y deserialización:

```java
public static void main(String[] args) {
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(Persona.class, new Persona("Juan", 25))
                .setPrettyPrinting()
                .create();
        Persona persona = new Persona("Juan", 25);
        String json = gson.toJson(persona);
        System.out.println(json);
        Persona persona2 = gson.fromJson(json, Persona.class);
        System.out.println(persona2.getNombre());
        System.out.println(persona2.getEdad());
    }
```

## Gson. JsonReader

