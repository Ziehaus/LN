package Modelo;

import java.util.Map;

public class Juego {

    private final Map<String, IEscena> escenas;
    private IEscena escenaActual;
    private final Inventario inventario = new Inventario();

    public Juego(Map<String, IEscena> escenas, String escenaInicialId) {
        this.escenas = escenas;

        if (!escenas.containsKey(escenaInicialId)) {
            throw new IllegalArgumentException("La escena inicial no existe: " + escenaInicialId);
        }

        this.escenaActual = escenas.get(escenaInicialId);
    }

    public IEscena getEscenaActual() {
        return escenaActual;
    }

    public Inventario getInventario() {
        return inventario;
    }

    // ---------------------------------------------------------
    // LÓGICA DE DIÁLOGOS
    // ---------------------------------------------------------
    public boolean avanzarDialogo() {

        if (escenaActual instanceof EscenaDialogo ed) {

            boolean hayMas = ed.avanzar();

            if (!hayMas) {
                String siguiente = ed.getSiguienteEscena();
                cambiarEscena(siguiente);
            }

            return hayMas;
        }

        return false;
    }

    // ---------------------------------------------------------
    // LÓGICA DE DECISIONES
    // ---------------------------------------------------------
    public void elegirOpcion(int indice) {

        if (escenaActual instanceof EscenaDecision decision) {

            if (indice < 0 || indice >= decision.getOpciones().size()) {
                throw new IndexOutOfBoundsException(
                        "Índice de opción inválido: " + indice);
            }

            Opcion op = decision.getOpciones().get(indice);

            // Ejecutar acción adicional (agregar objetos, variables, etc.)
            op.ejecutarAccion();

            // Cambiar a la escena destino
            cambiarEscena(op.getEscenaDestinoId());
        }
    }

    // ---------------------------------------------------------
    // CAMBIO DE ESCENA
    // ---------------------------------------------------------
    public void cambiarEscena(String id) {

        if (id == null) {
            throw new IllegalArgumentException(
                    "La escena destino es null. Revisa tu guion o IDs.");
        }

        IEscena nueva = escenas.get(id);

        if (nueva == null) {
            throw new IllegalArgumentException(
                    "La escena destino no existe: " + id);
        }

        // Reiniciar diálogos al entrar nuevamente
        if (nueva instanceof EscenaDialogo ed) {
            ed.reiniciar();
        }

        this.escenaActual = nueva;
    }
}
