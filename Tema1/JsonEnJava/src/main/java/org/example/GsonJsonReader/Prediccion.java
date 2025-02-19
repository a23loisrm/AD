package org.example.GsonJsonReader;

import java.util.List;

public class Prediccion {
    private Concello concello;
    private List<PrediccionDia> listaPredDiaConcello;

    public Prediccion(Concello concello, List<PrediccionDia> listaPredDiaConcello) {
        this.concello = concello;
        this.listaPredDiaConcello = listaPredDiaConcello;
    }

    public Concello getConcello() {
        return concello;
    }

    public void setConcello(Concello concello) {
        this.concello = concello;
    }

    public List<PrediccionDia> getListaPredDiaConcello() {
        return listaPredDiaConcello;
    }

    public void setListaPredDiaConcello(List<PrediccionDia> listaPredDiaConcello) {
        this.listaPredDiaConcello = listaPredDiaConcello;
    }

    @Override
    public String toString() {
        return "Prediccion{" +
                "concello=" + concello +
                ", listaPredDiaConcello=" + listaPredDiaConcello +
                '}';
    }
}
