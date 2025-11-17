package Modelo;

import java.util.Map;

public class Juego {

    private Map<String, IEscena> escenas;
    private IEscena escenaActual;
    private Inventario inventario = new Inventario();

    public Juego(Map<String, IEscena> escenas, String escenaInicialId) {
        this.escenas = escenas;
        this.escenaActual = escenas.get(escenaInicialId);
    }

    public IEscena getEscenaActual() {
        return escenaActual;
    }

    public Inventario getInventario() {
        return inventario;
    }

    // ---------- LÓGICA DE DIÁLOGOS ----------
    public boolean avanzarDialogo() {
        if (escenaActual instanceof EscenaDialogo ed) {
            boolean hayMas = ed.avanzar();
            if (!hayMas) {
                cambiarEscena(ed.getSiguienteEscena());
            }
            return hayMas;
        }
        return false;
    }

    // ---------- LÓGICA DE DECISIONES ----------
    public void elegirOpcion(int indice) {
        if (escenaActual instanceof EscenaDecision decision) {
            Opcion op = decision.getOpciones().get(indice);
            op.ejecutarAccion();
            cambiarEscena(op.getEscenaDestinoId());
        }
    }

    // ---------- CAMBIO DE ESCENA ----------
    public void cambiarEscena(String id) {
        IEscena nueva = escenas.get(id);
        if (nueva instanceof EscenaDialogo ed) {
            ed.reiniciar();
        }
        this.escenaActual = nueva;
    }
}
