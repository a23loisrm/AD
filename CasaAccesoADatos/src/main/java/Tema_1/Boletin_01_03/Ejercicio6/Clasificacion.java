package Tema_1.Boletin_01_03.Ejercicio6;

public class Clasificacion {
    private String nombreEquipo;
    private int numeroPartidosJugados;
    private int numeroVictorias;
    private int derrotas;
    private int puntoFavor;
    private int puntosContra;
    private int diferencia;

    public Clasificacion(String nombreEquipo, int numeroPartidosJugados, int numeroVictorias, int derrotas, int puntoFavor, int puntosContra, int diferencia) {
        this.nombreEquipo = nombreEquipo;
        this.numeroPartidosJugados = numeroPartidosJugados;
        this.numeroVictorias = numeroVictorias;
        this.derrotas = derrotas;
        this.puntoFavor = puntoFavor;
        this.puntosContra = puntosContra;
        this.diferencia = diferencia;
    }

    public int getNumeroPartidosJugados() {
        return numeroPartidosJugados;
    }

    public void setNumeroPartidosJugados(int numeroPartidosJugados) {
        this.numeroPartidosJugados = numeroPartidosJugados;
    }

    public String getNombreEquipo() {
        return nombreEquipo;
    }

    public void setNombreEquipo(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
    }

    public int getNumeroVictorias() {
        return numeroVictorias;
    }

    public void setNumeroVictorias(int numeroVictorias) {
        this.numeroVictorias = numeroVictorias;
    }

    public int getDerrotas() {
        return derrotas;
    }

    public void setDerrotas(int derrotas) {
        this.derrotas = derrotas;
    }

    public int getPuntoFavor() {
        return puntoFavor;
    }

    public void setPuntoFavor(int puntoFavor) {
        this.puntoFavor = puntoFavor;
    }

    public int getPuntosContra() {
        return puntosContra;
    }

    public void setPuntosContra(int puntosContra) {
        this.puntosContra = puntosContra;
    }

    public int getDiferencia() {
        return diferencia;
    }

    public void setDiferencia(int diferencia) {
        this.diferencia = diferencia;
    }

    @Override
    public String toString() {
        return "Clasificacion{" +
                "nombreEquipo='" + nombreEquipo + '\'' +
                ", numeroPartidosJugados=" + numeroPartidosJugados +
                ", numeroVictorias=" + numeroVictorias +
                ", derrotas=" + derrotas +
                ", puntoFavor=" + puntoFavor +
                ", puntosContra=" + puntosContra +
                ", diferencia=" + diferencia +
                '}';
    }
}
