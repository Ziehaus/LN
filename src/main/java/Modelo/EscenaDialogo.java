
package Modelo;

public class EscenaDialogo extends EscenaBase {
    private Dialogo dialogoPrincipal;

    public EscenaDialogo(String titulo, String fondo, String musicaFondo, String efectoSonido, Dialogo dialogo) {
        super(titulo, null, fondo, musicaFondo, efectoSonido);
        this.dialogoPrincipal = dialogo;
    }

    @Override
    public void mostrarEscena() {
        super.mostrarEscena(); // muestra fondo, música, efectos, etc.
        dialogoPrincipal.reiniciar();
        while (dialogoPrincipal.hayMasLineas()) {
            dialogoPrincipal.mostrarSiguienteLinea();
        }
    }
}

