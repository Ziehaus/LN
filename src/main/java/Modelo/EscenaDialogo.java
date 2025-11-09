
package Modelo;

import java.util.List;

public class EscenaDialogo extends EscenaBase {

    // =====================
    // Atributos
    // =====================
    private List<Dialogo> dialogos;          // lista de líneas de diálogo
    private List<Personaje> personajes;      // personajes presentes en la escena
    private int indiceDialogoActual;         // control de diálogo actual

    // =====================
    // Constructor
    // =====================
    public EscenaDialogo(String titulo, String fondo, String musicaFondo, String efectoSonido,
                         List<Dialogo> dialogos, List<Personaje> personajes) {
        super(titulo, "", fondo, musicaFondo, efectoSonido);
        this.dialogos = dialogos;
        this.personajes = personajes;
        this.indiceDialogoActual = 0;
    }

    // =====================
    // Métodos sobrescritos
    // =====================
    @Override
    public void mostrarEscena() {
        System.out.println("=== Escena de Diálogo: " + titulo + " ===");
        System.out.println("Fondo: " + fondo);
        reproducirMusica();
        reproducirEfecto();
        mostrarDialogoActual();
    }

    // =====================
    // Métodos específicos
    // =====================

    /**
     * Muestra el diálogo actual de la escena.
     */
    public void mostrarDialogoActual() {
        if (indiceDialogoActual < dialogos.size()) {
            Dialogo d = dialogos.get(indiceDialogoActual);
            System.out.println(d.getPersonaje().hablar(d.getTexto()));
        } else {
            System.out.println("Fin de los diálogos.");
        }
    }

    /**
     * Avanza al siguiente diálogo.
     */
    public void siguienteDialogo() {
        if (indiceDialogoActual < dialogos.size() - 1) {
            indiceDialogoActual++;
            mostrarDialogoActual();
        } else {
            System.out.println("No hay más diálogos en esta escena.");
        }
    }

    /**
     * Reinicia la escena (por ejemplo, si el jugador vuelve a verla).
     */
    public void reiniciar() {
        indiceDialogoActual = 0;
    }

    // =====================
    // Getters y Setters
    // =====================

    public List<Dialogo> getDialogos() {
        return dialogos;
    }

    public void setDialogos(List<Dialogo> dialogos) {
        this.dialogos = dialogos;
    }

    public List<Personaje> getPersonajes() {
        return personajes;
    }

    public void setPersonajes(List<Personaje> personajes) {
        this.personajes = personajes;
    }

    public int getIndiceDialogoActual() {
        return indiceDialogoActual;
    }

    public void setIndiceDialogoActual(int indiceDialogoActual) {
        this.indiceDialogoActual = indiceDialogoActual;
    }
}

