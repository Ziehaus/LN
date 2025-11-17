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
    // MOSTRAR ESCENAS
    // -------------------------------------------------------
    private void mostrarEscenaActual() {

        IEscena escena = juego.getEscenaActual();

        switch (escena.getTipo()) {

            case DIALOGO -> mostrarEscenaDialogo((EscenaDialogo) escena);

            case DECISION -> mostrarEscenaDecision((EscenaDecision) escena);
        }
    }

    // ---------------------- DIALOGO --------------------------
    private void mostrarEscenaDialogo(EscenaDialogo escena) {

        Dialogo d = escena.getDialogoActual();

        panel.mostrarDialogo(
                d.getPersonaje().getNombre(),
                d.getPersonaje().getRutaImagen(),
                d.getTexto(),
                d.getEmocion()
        );
    }

    // El jugador hace clic en "Continuar"
    public void avanzarDialogo() {

        boolean hayMas = juego.avanzarDialogo();

        if (hayMas) {
            mostrarEscenaDialogo((EscenaDialogo) juego.getEscenaActual());
        } else {
            mostrarEscenaActual(); // cambio de escena automático
        }
    }

    // ---------------------- DECISION --------------------------
    private void mostrarEscenaDecision(EscenaDecision escena) {

        panel.mostrarOpciones(
                escena.getDescripcion(),
                escena.getOpciones().stream()
                        .map(Opcion::getTextoVisible)
                        .toList()
        );
    }

    // El jugador selecciona una opción
    public void seleccionarOpcion(int indice) {

        juego.elegirOpcion(indice);
        mostrarEscenaActual();
    }

    public Object getEscenaActual() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}

