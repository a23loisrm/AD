package local.sanclemente.ad.exame;

import local.sanclemente.ad.exame.dao.GameConnectionMaganer;
import local.sanclemente.ad.exame.dao.GeneroDAO;
import local.sanclemente.ad.exame.dao.JuegoDAO;
import local.sanclemente.ad.exame.dao.PlataformaDAO;
import local.sanclemente.ad.exame.model.Genero;
import local.sanclemente.ad.exame.model.Juego;
import local.sanclemente.ad.exame.model.Plataforma;

import java.util.List;
import java.util.Scanner;

public class AppJuegos {
    public static void main(String[] args) {
        GameConnectionMaganer connectionMaganer = GameConnectionMaganer.getInstance();
        Scanner sc = new Scanner(System.in);
        boolean salir = true;

        while (salir){

            System.out.println("=========================================");
            System.out.println("=         SELECCIONE UNA OPCIÓN         =");
            System.out.println("=                                       =");
            System.out.println("=         1. Mostrar géneros            =");
            System.out.println("=         2. Mostrar plataformas        =");
            System.out.println("=         3. Buscar juego por ID        =");
            System.out.println("=         4. Salir                      =");
            System.out.println("=========================================");
            System.out.print("Ingrese su opción: ");

            int selecion = sc.nextInt();

            switch (selecion){
                case 1:
                    GeneroDAO generoDAO = new GeneroDAO(connectionMaganer);
                    List<Genero> listaDeGeneros =generoDAO.getAll();

                    for (Genero genero : listaDeGeneros){
                        System.out.println(genero);
                    }
                    break;

                case 2:
                    PlataformaDAO plataformaDAO = new PlataformaDAO(connectionMaganer);
                    List<Plataforma> listaDePlataformas = plataformaDAO.getAll();

                    for(Plataforma plataforma : listaDePlataformas){
                        System.out.println(plataforma);
                    }
                    break;

                case 3:
                    JuegoDAO juegoDAO = new JuegoDAO(connectionMaganer);
                    System.out.println("Seleccione un id del juego");
                    int idJuego = sc.nextInt();
                    Juego juego = juegoDAO.getById(idJuego);
                    if (juego == null){
                        System.out.println("El juego con id: "+idJuego+" no existe");
                    }else{
                        System.out.println(juego);
                    }
                    break;

                case 4:
                    System.out.println("Saliendo...");
                    salir = false;
                    break;


                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }
}
