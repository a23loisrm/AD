package org.example.GsonJsonReader;

public class VariableFranxa {
    private VariableMeteoroloxica variableMeteorologica;
    private int valorManha;
    private int valorTarde;
    private int valorNoche;

    public VariableFranxa(VariableMeteoroloxica variableMeteorologica, int valorManha, int valorTarde, int valorNoche) {
        this.variableMeteorologica = variableMeteorologica;
        this.valorManha = valorManha;
        this.valorTarde = valorTarde;
        this.valorNoche = valorNoche;
    }

    public VariableMeteoroloxica getVariableMeteorologica() {
        return variableMeteorologica;
    }

    public void setVariableMeteorologica(VariableMeteoroloxica variableMeteorologica) {
        this.variableMeteorologica = variableMeteorologica;
    }

    public int getValorManha() {
        return valorManha;
    }

    public void setValorManha(int valorManha) {
        this.valorManha = valorManha;
    }

    public int getValorTarde() {
        return valorTarde;
    }

    public void setValorTarde(int valorTarde) {
        this.valorTarde = valorTarde;
    }

    public int getValorNoche() {
        return valorNoche;
    }

    public void setValorNoche(int valorNoche) {
        this.valorNoche = valorNoche;
    }

    @Override
    public String toString() {
        return "VariableFranxa{" +
                "variableMeteorologica=" + variableMeteorologica +
                ", valorManha=" + valorManha +
                ", valorTarde=" + valorTarde +
                ", valorNoche=" + valorNoche +
                '}';
    }
}
