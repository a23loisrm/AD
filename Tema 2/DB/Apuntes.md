# Tema 2
## Acceso a bases remotas relacionales

### Creamos una conexión con la base de datos
```java
 Connection con = DriverManager.getConnection("enlace de la base de datos");
```

Posteriormente creamos una sentencia para poder trabajar con las bases de datos
```java
Statement st = con.createStatement();
```

**Recuerda**, cerrar la base de datos
```java
con.close();
```