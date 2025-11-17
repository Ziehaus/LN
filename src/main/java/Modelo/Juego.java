package Modelo;

import java.util.List;
import java.util.Scanner;

public class Juego {

    private String titulo;
    private List<EscenaBase> escenas;
    private int escenaActual;
    private Inventario inventario;

    private Scanner scanner = new Scanner(System.in);

    // =====================
    // Constructor
    // =====================
    public Juego(String titulo, List<EscenaBase> escenas) {
        this.titulo = titulo;
        this.escenas = escenas;
        this.escenaActual = 0;
        this.inventario = new Inventario();
    }

    // =====================
    // Iniciar el juego
    // =====================
    public void iniciarJuego() {
        System.out.println("=== Iniciando: " + titulo + " ===");
        mostrarEscenaActual();
    }

    // =====================
    // Mostrar escena actual
    // =====================
    public void mostrarEscenaActual() {
        EscenaBase escena = escenas.get(escenaActual);
        escena.mostrarEscena();

        // Si es una escena de diálogo → permitir avanzar
        if (escena instanceof EscenaDialogo) {
            manejarDialogo((EscenaDialogo) escena);
        }

        // Si es una escena de decisión → permitir seleccionar
        else if (escena instanceof EscenaDecision) {
            manejarDecision((EscenaDecision) escena);
        }
    }

    // =====================
    // MANEJO DE DIÁLOGOS
    // =====================
    private void manejarDialogo(EscenaDialogo e) {
        boolean continuar = true;

        while (continuar) {
            System.out.println("\n[ENTER] para continuar...");
            scanner.nextLine();

            if (e.avanzarDialogo()) {
                e.mostrarDialogoActual();
            } else {
                continuar = false;
            }
        }

        siguienteEscena();
    }

    // =====================
    // MANEJO DE DECISIONES
    // =====================
    private void manejarDecision(EscenaDecision e) {

        System.out.println("\nElige una opción:");
        int opcion = leerOpcion(e.getOpciones().size());

        // Cambiar a la escena correspondiente
        cambiarEscena(escenaActual + opcion);

        mostrarEscenaActual();
    }

    // =====================
    // Cambiar a una escena específica
    // =====================
    public void cambiarEscena(int indice) {
        if (indice >= 0 && indice < escenas.size()) {
            escenaActual = indice;
        } else {
            System.out.println("Escena no válida, regresando al inicio.");
            escenaActual = 0;
        }
    }

    // =====================
    // Ir a la siguiente escena
    // =====================
    public void siguienteEscena() {
        if (escenaActual < escenas.size() - 1) {
            escenaActual++;
            mostrarEscenaActual();
        } else {
            System.out.println("Fin del juego.");
        }
    }

    // =====================
    // LEER OPCIÓN SEGURA
    // =====================
    private int leerOpcion(int max) {
        int opcion = -1;

        while (opcion < 1 || opcion > max) {
            System.out.print("→ ");
            try {
                opcion = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                opcion = -1;
            }

            if (opcion < 1 || opcion > max) {
                System.out.println("Opción inválida, intenta de nuevo.");
            }
        }

        return opcion;
    }

    // =====================
    // Getter inventario
    // =====================
    public Inventario getInventario() {
        return inventario;
    }
}
