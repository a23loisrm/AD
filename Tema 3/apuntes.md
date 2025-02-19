# JPA Dependencias


## Introducción

Lo primero que tenemos que hacer es añadir las dependencias necesarias.
Para hacer esto, si pulsamos alt+insert, nos aparecerá un menú en el que 
podremos seleccionar la opción de "Add Dependency".

Creamos la carpeta META-INF en src/main/resources y dentro de ella el archivo persistence.xml.
```xml
<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<persistence xmlns="https://jakarta.ee/xml/ns/persistence"
             xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
             xsi:schemaLocation="https://jakarta.ee/xml/ns/persistence https://jakarta.ee/xml/ns/persistence/persistence_3_0.xsd"
             version="3.0">
  <persistence-unit name="ejercicio_06_01" transaction-type="RESOURCE_LOCAL">
    <provider>org.hibernate.jpa.HibernatePersistenceProvider</provider>
    <exclude-unlisted-classes>false</exclude-unlisted-classes>
    <properties>
      <property name="jakarta.persistence.jdbc.url"
                value="jdbc:h2:.\src\main\resources\ejercicio_05_06;DB_CLOSE_ON_EXIT=TRUE;DATABASE_TO_UPPER=FALSE"/>
      <property name="jakarta.persistence.jdbc.user" value=""/>
      <property name="jakarta.persistence.jdbc.password" value=""/>
      <property name="jakarta.persistence.jdbc.driver" value="org.h2.Driver"/>

      <property name="jakarta.persistence.schema-generation.database.action" value="drop-and-create"/>


      <property name="hibernate.show_sql" value="true"/>
      <property name="hibernate.format_sql" value="true"/>
      <property name="hibernate.highlight_sql" value="true"/>

      <property name="hibernate.dialect" value="org.hibernate.dialect.H2Dialect" />
    </properties>

  </persistence-unit>
</persistence>
```
## Entidades

Creamos la clase Entidad con los atributos y las anotaciones necesarias.
```java
@Entity
public class Pelicula implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPelicula;
    private String titulo;
    private Short ano;

    private transient LocalDate fechaEstreno;
}
```

Luego una vez creada la clase creamos en el main un objeto de la clase y lo guardamos en la base de datos.
```java
public class Main {
    public static void main(String[] args) {
        Pelicula pelicula = new Pelicula("Titanic", (short) 1997);
        Pelicula pelicula2 = new Pelicula("Avatar", (short) 2009);
        Pelicula pelicula3 = new Pelicula("Terminator", (short) 1984);

        var emf = Persistence.createEntityManagerFactory("jpa-hibernate-h2");//El nombre es el que se encuentra en el archivo persistence.xml
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin(); //Iniciamos la transacción
        em.persist(pelicula); //Guardamos el objeto en la base de datos
        em.persist(pelicula2); //Guardamos el objeto en la base de datos
        em.persist(pelicula3); //Guardamos el objeto en la base de datos
        em.getTransaction().commit(); //Confirmamos la transacción


    }
}
```


## Creación de EmtityManagerUtil

Creamos una clase EntityManagerUtil que nos permitirá crear un EntityManagerFactory y un EntityManager.
Esto es un **Singleton**, por lo que solo se creará una vez.
```java
public class EntityManagerUtil {
    // Equivalente a SessionFactory
    private static final EntityManagerFactory ENTITY_MANAGER_FACTORY =
            Persistence.createEntityManagerFactory("jpa-hibernate-h2"); // Nombre de la unidad de persistencia

    // Equivalente a Session
    public static EntityManager getEntityManager() {
        return ENTITY_MANAGER_FACTORY.createEntityManager();
    }

    public static void shutdown() {
        ENTITY_MANAGER_FACTORY.close();
    }
}
```

## Creación de un JpaManager

```java
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.HashMap;
import java.util.Map;

public class JpaManager {

    public static final String EJERCICIO = "jpa-hibernate-h2";

    private static Map<String, EntityManagerFactory> instances = new HashMap<>();

    private JpaManager(){

    }

    private static boolean isEntityManagerFactoryClosed(String unidadPersistencia){
        return !instances.containsKey(unidadPersistencia) || instances.get(unidadPersistencia) == null ||
                !instances.get(unidadPersistencia).isOpen();
    }


    public static EntityManagerFactory getEntityManagerFactory(String unidadPersistencia){
        if (isEntityManagerFactoryClosed(unidadPersistencia)){
            synchronized (JpaManager.class){
                if (isEntityManagerFactoryClosed(unidadPersistencia)){
                    try{
                        instances.put(unidadPersistencia, Persistence.createEntityManagerFactory(unidadPersistencia));
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
        return instances.get(unidadPersistencia);
    }

    public static EntityManager getEntityManager(String persistenceUnitName){
        return getEntityManagerFactory(persistenceUnitName).createEntityManager();
    }

    public static void close(String persistenceUnitName){
        if (instances.containsKey(persistenceUnitName)){
            instances.get(persistenceUnitName).close();
            instances.remove(persistenceUnitName);
        }
    }
}
```
Luego en el main lo utilizamos de la siguiente manera.
```java
public class Main {
    public static void main(String[] args) {

        EntityManagerFactory emf = JpaManager.getEntityManagerFactory(JpaManager.EJERCICIO);
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Persona persona = new Persona(0, "Juan", "Perez", LocalDate.of(1990, 1, 1), Sexo.HOMBRE, EstadoCivil.SOLTERO, null);
        em.persist(persona);

        em.getTransaction().commit();


        em.close();
        emf.close();
    }

}
```

## @GeneratedValue

```java
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long idPelicula;
```
Se utiliza para especificar cómo se generarán los valores de las claves primarias
de una entidad (atributos marcados con `@Id`). En pocas palabras, define la estrategia
que usará la base de datos o el motor de persistencia para **generar el valor de este 
campo de clave primaria automáticamente**.

### `GenerationType.IDENTITY`

El **valor de la clave primaria se genera automáticamente por la base de datos**, 
generalmente utilizando una columna de tipo auto_increment.

Es ideal cuando la base de datos es responsable de **gestionar la generación de IDs**.

### `GenerationType.SEQUENCE`

El valor de la clave primaria se genera automáticamente utilizando una secuencia de 
la base de datos.

Es útil cuando la base de datos soporta secuencias y quieres **controlar la generación
de IDs**.

```java
@Id
@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pelicula_seq")
@SequenceGenerator(name = "pelicula_seq", sequenceName = "pelicula_sequence", allocationSize = 1)
private Long idPelicula;
```

### `GenerationType.TABLE`

Se **crea una tabla específica para almacenar y gestionar los valores de las claves primarias**.

Es útil si trabajas con una base de datos que no soporta AUTO_INCREMENT o secuencias.

```java
@Id
@GeneratedValue(strategy = GenerationType.TABLE, generator = "generadorIdDireccion")
@TableGenerator(
        name = "generadorIdDireccion",
        table = "GeneradorId",
        pkColumnName = "nombre_tabla",
        valueColumnName = "ultimo_valor",
        pkColumnValue = "direccion",
        allocationSize = 1
)
private Long idDireccion;
```

### `GenerationType.AUTO`

Deja que JPA **decida la estrategia de generación de claves primarias más adecuada
para la base de datos que estás utilizando**.

Puede usar secuencias, tablas, o auto_increment dependiendo de la configuración
del motor de persistencia.

Recomendado cuando no tienes un requerimiento específico y quieres dejar que JPA decida.

## @Transient
```java
@Transient
private LocalDate fechaEstreno;
```
otra forma de usar transient
```java
transient LocalDate fechaEstreno;
```

### Para que sirve @Transient
La anotación @Transient es parte de **JPA (Java Persistence API)**. Se usa en una 
**clase entidad** para indicar que un campo **NO debe ser persistido** en la base de datos.
Es decir, ese dato **no se almacenará en la base de datos**. Aunque el atributo exista
en tu clase Java, JPA (o Hibernate) no lo va a guardar como una columna en la tabla 
correspondiente de la base de datos..

### ¿Cuándo usar @Transient?
La anotación @Transient se usa cuando necesitas **un atributo que no debe guardarse en la
base de datos**, pero que es **útil** dentro de la lógica de tu aplicación.

## @Converter

Creamos una clase SexoConverter que implementa la interfaz AttributeConverter<Sexo, String>.

Luego añadimos la anotación @Convert(converter = SexoConverter.class) a la propiedad sexo 
de la clase Persona.

```java
public enum Sexo {
    HOMBRE("H"), MUJER("M");

    private String codigo;

    private Sexo(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }
}
```

```java
@Convert(converter = SexoConverter.class)
private Sexo sexo;
```


```java
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class SexoConverter implements AttributeConverter<Sexo, String> {
    @Override
    public String convertToDatabaseColumn(Sexo sexo) {
        if (sexo == null) {
            return null;
        } else {
            return sexo.name();
        }
    }

    @Override
    public Sexo convertToEntityAttribute(String s) {
        if (s == null) {
            return null;
        } else {
            return Sexo.valueOf(s);
        }
    }
}
```
### Para que sirve @Converter

La anotación `@Converter` se utiliza en JPA para definir una clase que **convierte
valores entre la representación de un atributo en la base de datos y su 
representación en la entidad Java**. Es decir, sirve para transformar un tipo de
dato personalizado (o no compatible directamente con la base de datos) en algo que 
sí se pueda almacenar en la base de datos y viceversa.




## Consultas

### Consultas dinámicas



### Consultas estáticas


## Objetos Grander (LOBs)


## Relaciones

Las realiaciones entre entidades se pueden clasificar en:

- **ManyToOne(Muchos a uno)**
- **OneToMany(Uno a muchos)**
- **OneToOne(Uno a uno)**
- **ManyToMany(Muchos a muchos)**

## Relaciones mono-valuadas: @OneToOne y @ManyToOne

### @OneToOne unidireccionales

```java
@Entity
public class Empleado {
    @Id
    private int idEmpleado;
    private String nombre;
    private long salario;
    @OneToOne
    private Aparcamiento aparcamiento;
    // ...
}
```
```java
@Entity
public class Aparcamiento {
    @Id
    private int idAparcamiento;
    private int numero;
    private String direccion;
    // ...
}
```
#### ¿Qué significa esto?

- **Unidireccional:** Aquí solo **Empleado** tiene conocimiento de su relación con **Aparcamiento**. Desde la entidad `Empleado` puedes acceder al aparcamiento asignado
a ese empleado, pero desde la entidad `Aparcamiento` no hay ninguna referencia al empleado.


- **Uso:** Se usa cuando solo necesitas consultar una relación en una dirección, en este caso, "¿Qué aparcamiento tiene un empleado?".


- **`@OneToOne`:** Indica que existe una relación uno a uno entre `Empleado` y `Aparcamiento`. Esto significa que cada empleado tiene 
exactamente un aparcamiento, y cada aparcamiento está asignado a un solo empleado.


- **Propietario de la relación:** En este caso, la entidad `Empleado` es la propietaria de la relación, ya que tiene la 
referencia directa a `Aparcamiento`. Esto también significa que la clave foránea (`aparcamiento_id`) estará en la tabla de `Empleado` en la base de datos.


### @OneToOne bidireccionales

```java
@Entity
public class Aparcamiento {
    @Id
    private int idAparcamiento;
    private int numero;
    private String direccion;
    
    @OneToOne(mappedBy="aparcamiento")
    private Empleado empleado;
    // ...
}
```
```java
@Entity
public class Empleado {
    @Id
    private int idEmpleado;
    private String nombre;
    private long salario;
    @OneToOne
    private Aparcamiento aparcamiento;
    // ...
}
```
#### ¿Qué significa esto?

- **Bidireccional:** Ahora ambas entidades tienen conocimiento una de la otra.
Desde Empleado puedes acceder a su Aparcamiento, y desde Aparcamiento puedes
acceder al Empleado que lo tiene asignado.


- **`mappedBy`**: En Aparcamiento, la anotación `@OneToOne(mappedBy = "aparcamiento")` indica
que Empleado es el propietario de la relación. Esto significa que la clave 
foránea sigue estando en la tabla Empleado. La relación en Aparcamiento solo
existe como una referencia lógica, pero no gestiona la base de datos.


- **Uso**: Se usa cuando necesitas navegar la relación en ambas direcciones,
por ejemplo, responder preguntas como:
  - ¿Qué aparcamiento tiene asignado un empleado?
  - ¿A qué empleado está asignado un aparcamiento?


### @ManyToOne unidireccional

```java
@Entity
public class Empleado {
    @Id
    private int idEmpleado;
    private String nombre;
    private long salario;
    @ManyToOne
    private Departamento departamento;
    // ...
}
```
```java
@Entity
public class Departamento {
    @Id
    private int idDepartamento;
    private String nombre;
    // ...
}
```
1. La relación entre `Empleado` y `Departamento` es de muchos a uno, es decir:

- Varios empleados pueden pertenecer a un solo departamento.

- Un departamento puede tener varios empleados asignados, pero en este modelo
unidireccional, el departamento no sabe cuántos ni cuáles empleados tiene.

2. Unidireccional:

- Solo la clase `Empleado` tiene conocimiento de esta relación a través de 
su atributo `departamento`.

- Desde `Departamento`, no es posible navegar hacia los empleados.

## Relaciones mmulti-valuadas: @OneToMany y @ManyToMany

### @OneToMany bidireccional

```java
@Entity
public class Departamento {
    @Id
    private int idDepartamento;
    private String nombre;
    @OneToMany(mappedBy="departamento") // Empleado debe tener un atributo "departamento"
    private Collection<Empleado> empleados;
    // ...
}
```
### <mark>Importante!!</mark>
**Cuando sea `@OneToMany` se debe usar `Collection` o `List`.**

```java
@Entity
public class Empleado {
    @Id
    private int idEmpleado;
    private String nombre;
    private long salario;
    @ManyToOne
    @JoinColumn(name="idDepartamento") // Nombre de la columna de clave foránea
    private Departamento departamento;
    // ...
}
```
### @OneToMany unidireccional

Cubrir esto

### @ManyToMany

Cubrir esto

### Nombre de la columna de clave foránea

Si quieres cambiar el nombre de la columna de clave foránea, puedes usar la anotación
`@JoinColumn` en la propiedad de la relación.

```java
@Entity
public class Empleado {

    @Id private int idEmpleado;
    private String nombre;
    private long salario;

    @ManyToOne
    @JoinColumn(name = "idDepartamento")
    private Departamento departamento;
    // ...
}
```


## Claves compartidas en relaciones uno a uno

### `@MapsId`

Se usa cuando **quieres compartir la clave primaria** de una entidad con una clave foránea de otra entidad.
Esto es común en relaciones **uno a uno** donde la entidad dependiente (por ejemplo, `HistorialEmpleado`) usa la clave primaria de la entidad principal (por ejemplo, `Empleado`).


**¿Como funciona?**
1. Definimos un atributo de clave primaria en la entidad dependiente (idEmpleado).


2. También definimos una relación con la entidad principal (Empleado empleado).


3. Ambos atributos apuntan a la misma columna en la base de datos, pero solo el atributo de relación se usa para persistir datos.


```java

@Entity
public class HistorialEmpleado {
@Id
int idEmpleado; // Clave primaria

    @MapsId // Mapea la relación a la misma columna que idEmpleado
    @OneToOne
    @JoinColumn(name="idEmpleado")
    private Empleado empleado; // Relación con Empleado
}
```

### PrimaryKeyJoinColumn y PrimaryKeyJoinColumns


La anotación `@PrimaryKeyJoinColumn` **se utiliza para especificar una columna de clave primaria de una tabla de unión.**

`@PrimaryKeyJoinColumns` se utiliza para **especificar varias columnas de clave primaria de una tabla de unión.**

Se usa en relaciones **uno a uno** cuando **la clave primaria de una entidad es también una clave foránea** que apunta a otra entidad.
La diferencia clave con `@MapsId` es que aquí **la entidad propietaria de la relación** define cómo se enlazan las claves.


**¿Como funciona?**
1. La entidad principal (por ejemplo, `Empleado`) tiene un campo que apunta a la entidad secundaria (`HistorialEmpleado`).


2. Se indica que la clave primaria de la entidad principal también funciona como clave foránea para la entidad secundaria.


```java
@Entity
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEmpleado;

    @OneToOne
    @PrimaryKeyJoinColumn // La clave primaria también es la clave foránea hacia HistorialEmpleado
    private HistorialEmpleado historial;
}
```

## Consultas

JPA proporciona varias formas de realizar consultas a la base de datos, permitiendo acceder y manipular datos de manera eficiente. Existen dos tipos principales de consultas en JPA:

- **Consultas Estáticas** (Definidas en la entidad con `@NamedQuery` o `@NamedNativeQuery`).
- **Consultas Dinámicas** (Utilizando `EntityManager.createQuery` o `createNativeQuery` en tiempo de ejecución).

### 1. Consultas JPQL (Java Persistence Query Language)
JPQL es el lenguaje de consultas orientado a objetos de JPA, similar a SQL pero operando sobre entidades en lugar de tablas.

#### a) Consulta Básica
```java
Query query = em.createQuery("SELECT p FROM Pelicula p WHERE p.titulo = :titulo");
query.setParameter("titulo", "Titanic");
List<Pelicula> peliculas = query.getResultList();
```

#### b) Consulta con Selección Parcial (Devuelve Objetos Específicos)
```java
Query query = em.createQuery("SELECT p.titulo, p.ano FROM Pelicula p");
List<Object[]> resultados = query.getResultList();
for (Object[] fila : resultados) {
    System.out.println("Título: " + fila[0] + ", Año: " + fila[1]);
}
```

#### c) Consulta con Funciones de Agregación
```java
Query query = em.createQuery("SELECT COUNT(p) FROM Pelicula p WHERE p.ano > 2000");
Long cantidad = (Long) query.getSingleResult();
System.out.println("Cantidad de películas después del 2000: " + cantidad);
```

### 2. Named Queries (Consultas Estáticas)

#### a) Uso de `@NamedQuery`
```java
@Entity
@NamedQuery(name = "Pelicula.findByTitulo", query = "SELECT p FROM Pelicula p WHERE p.titulo = :titulo")
public class Pelicula {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
}
```

#### b) Ejecución de una `@NamedQuery`
```java
TypedQuery<Pelicula> query = em.createNamedQuery("Pelicula.findByTitulo", Pelicula.class);
query.setParameter("titulo", "Titanic");
List<Pelicula> peliculas = query.getResultList();
```

---

### 3. Consultas Nativas (SQL Directo)

#### a) Consulta Nativa con `createNativeQuery`
```java
Query query = em.createNativeQuery("SELECT * FROM pelicula WHERE titulo = ?", Pelicula.class);
query.setParameter(1, "Titanic");
List<Pelicula> peliculas = query.getResultList();
```


