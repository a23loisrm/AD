package local.sanclemente.ad.exame;

import local.sanclemente.ad.exame.dao.GameConnectionMaganer;
import local.sanclemente.ad.exame.dao.GeneroDAO;
import local.sanclemente.ad.exame.dao.JuegoDAO;
import local.sanclemente.ad.exame.dao.PlataformaDAO;
import local.sanclemente.ad.exame.model.Genero;
import local.sanclemente.ad.exame.model.Juego;
import local.sanclemente.ad.exame.model.Plataforma;

import java.util.ArrayList;
import java.util.List;

public class AppExame {
    public static void main(String[] args) {
        GameConnectionMaganer connectionMaganer = GameConnectionMaganer.getInstance();
        GeneroDAO generoDAO = new GeneroDAO(connectionMaganer);

        Genero genero = generoDAO.getById(4);

        if (genero != null){
            System.out.println(genero);
        }else{
            System.out.println("No existe en la base de datos es id");
        }

        List<Genero> listaDeGeneros = generoDAO.getAll();

        if (listaDeGeneros.isEmpty()){
            System.out.println("No hay ningun elemento en la base de datos");
        }else{
            for(Genero g : listaDeGeneros){
                System.out.println(g);
            }
        }

        System.out.println("===================================================");
        System.out.println("===================================================");
        System.out.println("===================================================");
        System.out.println("=====================PLATAFORMA====================");
        System.out.println("===================================================");
        System.out.println("===================================================");
        System.out.println("===================================================");

        PlataformaDAO plataformaDAO = new PlataformaDAO(connectionMaganer);
        Plataforma plataforma = plataformaDAO.getById(1);

        if (plataforma != null){
            System.out.println(plataforma);
        }else{
            System.out.println("No existe una plataforma con ese ID");
        }

        List<Plataforma> listaDePlataformas = plataformaDAO.getAll();

        if (listaDePlataformas.isEmpty()){
            System.out.println("No hay ninguna plataforma en la base de datos");
        }else{
            for (Plataforma p : listaDePlataformas){
                System.out.println(p);
            }
        }


        System.out.println("===================================================");
        System.out.println("===================================================");
        System.out.println("===================================================");
        System.out.println("=======================JUEGO=======================");
        System.out.println("===================================================");
        System.out.println("===================================================");
        System.out.println("===================================================");


        JuegoDAO juegoDAO = new JuegoDAO(connectionMaganer);

        Juego juego = juegoDAO.getById(1);

        if (juego == null){
            System.out.println("No existe ese ID en la base de datos");
        }else {
            System.out.println(juego);
        }

        List<Juego> listaDeJuegos = juegoDAO.getAll();
        if (listaDeJuegos.isEmpty()){
            System.out.println("No existe ningun juego en la base de datos");
        }else{
            for(Juego j : listaDeJuegos){
                System.out.println(j);
            }
        }

    }
}
