package com.pepinho.ad.jpa;

import com.pepinho.ad.jpa.peliculas.Ocupacion;
import com.pepinho.ad.jpa.peliculas.Pais;
import com.pepinho.ad.jpa.peliculas.Pelicula;
import jakarta.persistence.EntityManager;

public class Main {
    public static void main(String[] args) {
        EntityManager em = JPAUtil.getEntityManager();

        // a) duración mayor a 120 minutos

        var q = em.createQuery("SELECT p FROM Pelicula p WHERE p.duracion > 120", Pelicula.class);
        q.getResultStream().forEach(System.out::println);


        // b) Películas de un género específico (por ejemplo, "Drama")
        System.out.println("\nPelículas del género 'Drama':");
        var q2 = em.createQuery("SELECT p FROM Pelicula p WHERE p.genero = :genero", Pelicula.class);
        q2.setParameter("genero", "Drama");
        q2.getResultStream().forEach(System.out::println);

        // c) Ocupaciones con más de 5 películas asociadas
        System.out.println("\nOcupaciones con más de 5 películas:");
        var q3 = em.createQuery("SELECT o FROM Ocupacion o WHERE SIZE(o.peliculas) > 5", Ocupacion.class);
        q3.getResultStream().forEach(System.out::println);

        // d) Películas de un país específico (por ejemplo, "España")
        System.out.println("\nPelículas de España:");
        var q4 = em.createQuery("SELECT p FROM Pelicula p WHERE p.pais = :pais", Pelicula.class);
        q4.setParameter("pais", "España");
        q4.getResultStream().forEach(System.out::println);

        // e) Películas con un personaje interpretado por un actor de un país específico (por ejemplo, "Francia")
        System.out.println("\nPelículas con actores de Francia:");
        var q5 = em.createQuery("SELECT DISTINCT p FROM Pelicula p JOIN p.personajes pj JOIN pj.actor a WHERE a.pais = :pais", Pelicula.class);
        q5.setParameter("pais", "Francia");
        q5.getResultStream().forEach(System.out::println);

        // f) Películas con música de un compositor específico (por ejemplo, "John Williams")
        System.out.println("\nPelículas con música de John Williams:");
        var q6 = em.createQuery("SELECT p FROM Pelicula p WHERE p.compositor = :compositor", Pelicula.class);
        q6.setParameter("compositor", "John Williams");
        q6.getResultStream().forEach(System.out::println);

        // g) Películas con un personaje interpretado por un actor con un nombre específico (por ejemplo, "Tom Hanks")
        System.out.println("\nPelículas con Tom Hanks:");
        var q7 = em.createQuery("SELECT DISTINCT p FROM Pelicula p JOIN p.personajes pj JOIN pj.actor a WHERE a.nombre = :nombre", Pelicula.class);
        q7.setParameter("nombre", "Tom Hanks");
        q7.getResultStream().forEach(System.out::println);

        // h) Películas de un género específico y un año específico (por ejemplo, "Acción" y 2005)
        System.out.println("\nPelículas de Acción de 2005:");
        var q8 = em.createQuery("SELECT p FROM Pelicula p WHERE p.genero = :genero AND p.anio = :anio", Pelicula.class);
        q8.setParameter("genero", "Acción");
        q8.setParameter("anio", 2005);
        q8.getResultStream().forEach(System.out::println);

        // i) Películas con un personaje interpretado por un actor de un género específico (por ejemplo, "Mujer")
        System.out.println("\nPelículas con actrices (Mujer):");
        var q9 = em.createQuery("SELECT DISTINCT p FROM Pelicula p JOIN p.personajes pj JOIN pj.actor a WHERE a.genero = :genero", Pelicula.class);
        q9.setParameter("genero", "Mujer");
        q9.getResultStream().forEach(System.out::println);

        // j) Películas con un personaje interpretado por un actor de un país específico y duración > 100 min
        System.out.println("\nPelículas con actores de México y duración mayor a 100 min:");
        var q10 = em.createQuery("SELECT DISTINCT p FROM Pelicula p JOIN p.personajes pj JOIN pj.actor a WHERE a.pais = :pais AND p.duracion > 100", Pelicula.class);
        q10.setParameter("pais", "México");
        q10.getResultStream().forEach(System.out::println);

        // k) Países sin películas asociadas
        System.out.println("\nPaíses sin películas asociadas:");
        var q11 = em.createQuery("SELECT p FROM Pais p WHERE p NOT IN (SELECT DISTINCT p.pais FROM Pelicula p)", Pais.class);
        q11.getResultStream().forEach(System.out::println);

        em.close();

    }
}