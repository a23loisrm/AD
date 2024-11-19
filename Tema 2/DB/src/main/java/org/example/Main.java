package org.example;

import java.sql.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost//");
        //Connection con = DriverManager.getConnection("jdbc:h2:L:\\AccesoADatos\\Tema 2\\BasesDeDatos\\h2\\zoo");
        Statement st = con.createStatement();
       // st.execute("CREATE TABLE animal (id animal INTEGER PRIMARY KEY, nome VARCHAR(100), especie VARCHAR(100))");

        ResultSet rs = st.executeQuery("Select * from Especie");

        while(rs.next()){
            System.out.println("Especie: "+rs.getInt(1) + ", "+ rs.getString(2) + rs.getDouble("area"));
        }

        System.out.println("Conexion establecida");

        con.close();
    }
}