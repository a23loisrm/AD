package org.example;

import java.util.function.Predicate;

public class PreguntaTrueFalse extends Pregunta implements Predicate<Boolean> {
    private boolean respuesta;

    public PreguntaTrueFalse() {
        setTipoPregunta(TipoPregunta.BOOLEAN);
    }

    public PreguntaTrueFalse(String pregunta) {
        super(pregunta);
        setTipoPregunta(TipoPregunta.BOOLEAN);
    }

    public PreguntaTrueFalse(String pregunta, boolean respuesta) {
        super(pregunta);
        this.respuesta = respuesta;
    }

    public boolean isRespuesta() {
        return respuesta;
    }

    public PreguntaTrueFalse setRespuesta(boolean respuesta) {
        this.respuesta = respuesta;
        return this;
    }

    @Override
    public String toString() {
        return super.toString()
                + "    " + "a. Verdadero" + (respuesta ? " *" : "") + System.lineSeparator()
                + "    " + "b. Falso" + (respuesta ? "" : " *");
    }

    @Override
    public boolean test(Boolean aBoolean) {
        return respuesta == aBoolean;
    }
}
