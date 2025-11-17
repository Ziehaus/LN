package Modelo;

import java.util.List;

public class EscenaDialogo extends EscenaBase {

    private List<Dialogo> dialogos;
    private List<Personaje> personajes;
    private int indiceDialogoActual;

    public EscenaDialogo(String titulo, String fondo, String musicaFondo,
                         String efectoSonido, List<Dialogo> dialogos,
                         List<Personaje> personajes) {

        super(titulo, "", fondo, musicaFondo, efectoSonido);  // descripción vacía
        this.dialogos = dialogos;
        this.personajes = personajes;
        this.indiceDialogoActual = 0;
    }

    @Override
    public void mostrarEscena() {
        System.out.println("=== Escena de Diálogo: " + titulo + " ===");
        System.out.println("Fondo: " + fondo);
        reproducirMusica();
        reproducirEfecto();
        mostrarDialogoActual();
    }

    public void mostrarDialogoActual() {
        if (indiceDialogoActual < dialogos.size()) {
            Dialogo d = dialogos.get(indiceDialogoActual);
            System.out.println(d.getPersonaje().hablar(d.getTexto()));
        } else {
            System.out.println("Fin de los diálogos.");
        }
    }

    public boolean avanzarDialogo() {
        if (indiceDialogoActual < dialogos.size() - 1) {
            indiceDialogoActual++;
            return true;
        }
        return false; // no hay más
    }

    public void reiniciar() {
        indiceDialogoActual = 0;
    }
}
