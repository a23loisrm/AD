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
    <persistence-unit name="jpa-hibernate-mysql">
        <properties>
            <property name="jakarta.persistence.jdbc.driver" value="org.h2.Driver" />
            <property name="jakarta.persistence.jdbc.url"    value="jdbc:h2:    " />
            <property name="jakarta.persistence.jdbc.user"   value="" />
            <property name="jakarta.persistence.jdbc.password" value="" />
            <property name="jakarta.persistence.schema-generation.database.action" value="create" />

            <property name="hibernate.dialect"    value="org.hibernate.dialect.H2Dialect" />
            <property name="hibernate.show_sql"   value="true" />
            <property name="hibernate.format_sql" value="true" />
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


## Creaciom de EmtityManagerUtil

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



## Consultas

### Consultas dinámicas



### Consultas estáticas

