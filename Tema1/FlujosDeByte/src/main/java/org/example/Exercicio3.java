/*
package org.example;

import java.io.*;

public class Exercicio3 {
    public static class ColeccionPersonas implements Serializable {
        private String nombre;
        private int edad;

        public void Persona(String nombre, int edad){
            this.nombre = nombre;
            this.edad = edad;
        }

        public String getNombre(){
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public int getEdad() {
            return edad;
        }

        public void setEdad(int edad) {
            this.edad = edad;
        }

        @Override
        public String toString() {
            return nombre+" , "+edad;
        }
    }


    public static void main(String[] args) {
         ColeccionPersonas persona = new Persona();


        //Serializacion
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("usuario.txt"))){
            out.writeObject(persona);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Deserializacion
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("usuario.txt"))){
            Exercicio2.Persona personaDeserilizada = (Exercicio2.Persona)
                    in.readObject();
            System.out.println(personaDeserilizada.toString());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
*/