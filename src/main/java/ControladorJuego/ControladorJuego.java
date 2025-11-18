package ControladorJuego;
import Modelo.*;
import Vista.PanelEscena;

public class ControladorJuego {

    private final Juego juego;
    private final PanelEscena panel;

    public ControladorJuego(Juego juego, PanelEscena panel) {
        this.juego = juego;
        this.panel = panel;
    }

    // -------------------------------------------------------
    // INICIALIZACIÓN
    // -------------------------------------------------------
    public void iniciar() {
        mostrarEscenaActual();
    }

    // -------------------------------------------------------
    // MOSTRAR ESCENAS SEGÚN TIPO
    // -------------------------------------------------------
    public void mostrarEscenaActual() {

        IEscena escena = juego.getEscenaActual();
        aplicarAudio(escena); // ? reproduce música y efectos

        switch (escena.getTipo()) {
            case DIALOGO -> mostrarEscenaDialogo((EscenaDialogo) escena);
            case DECISION -> mostrarEscenaDecision((EscenaDecision) escena);
        }
    }

    // -------------------------------------------------------
    // ESCENA DE DIÁLOGO
    // -------------------------------------------------------
    private void mostrarEscenaDialogo(EscenaDialogo escena) {

        Dialogo d = escena.getDialogoActual();

        // Fondo
        panel.mostrarFondo(escena.getFondo());

        // Texto, personaje, emoción
        panel.mostrarDialogo(
                d.getPersonaje().getNombre(),
                d.getPersonaje().getImagenEmocion(d.getEmocion()),
                d.getTexto(),
                d.getEmocion()
        );
    }

    // Acción cuando el jugador presiona "Continuar"
    public void avanzarDialogo() {

        boolean hayMas = juego.avanzarDialogo();

        if (hayMas) {
            mostrarEscenaDialogo((EscenaDialogo) juego.getEscenaActual());
        } else {
            mostrarEscenaActual(); // Cambio automático a la escena siguiente
        }
    }

    // -------------------------------------------------------
    // ESCENA DE DECISIÓN
    // -------------------------------------------------------
    private void mostrarEscenaDecision(EscenaDecision escena) {

        panel.mostrarOpciones(
                escena.getDescripcion(),
                escena.getOpciones().stream().map(Opcion::getTextoVisible).toList()
        );

        // Asignar ActionListeners a cada botón
        for (int i = 0; i < escena.getOpciones().size(); i++) {
            final int indice = i; // Necesario porque listeners deben ser final/efectivamente final

            panel.setActionListenerOpcion(i, e -> seleccionarOpcion(indice));
        }
    }

    // Acción al elegir una opción
    public void seleccionarOpcion(int indice) {

        juego.elegirOpcion(indice);

        mostrarEscenaActual();
    }
    
        private void aplicarAudio(IEscena escena) {
        if (escena instanceof EscenaBase base) {

            if (base.getMusicaFondo() != null) {
                Utils.AudioManager.reproducirMusica(base.getMusicaFondo());
            }

            if (base.getEfectoSonido() != null) {
                Utils.AudioManager.reproducirEfecto(base.getEfectoSonido());
            }
        }
    }


    // Acceso al modelo
    public IEscena getEscenaActual() {
        return juego.getEscenaActual();
    }

}//....


