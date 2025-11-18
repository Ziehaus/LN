package Modelo;

import java.util.List;

public class EscenaDecision extends EscenaBase {

    private final List<Opcion> opciones;

    public EscenaDecision(String id, String descripcion, List<Opcion> opciones) {
        super(id, descripcion);
        this.opciones = opciones;
    }

    @Override
    public TipoEscena getTipo() {
        return TipoEscena.DECISION;
    }

    public List<Opcion> getOpciones() {
        return opciones;
    }
}

