package Modelo;

import java.util.List;

public class EscenaDialogo extends EscenaBase {

    private List<Dialogo> dialogos;
    private int indiceActual = 0;

    public EscenaDialogo(String id, String descripcion, List<Dialogo> dialogos) {
        super(id, descripcion);
        this.dialogos = dialogos;
    }

    @Override
    public TipoEscena getTipo() {
        return TipoEscena.DIALOGO;
    }

    public Dialogo getDialogoActual() {
        return dialogos.get(indiceActual);
    }

    /**
     * Avanza 1 diálogo.
     * @return true si quedan más diálogos, false si la escena terminó.
     */
    public boolean avanzar() {
        if (indiceActual < dialogos.size() - 1) {
            indiceActual++;
            return true;
        }
        return false;
    }

    public void reiniciar() {
        indiceActual = 0;
    }
}
