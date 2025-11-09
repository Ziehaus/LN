package Modelo;

import java.util.ArrayList;
import java.util.List;

public class Inventario {

    // =====================
    // Atributos
    // =====================
    private List<String> pistas;   // Lista de pistas o ítems obtenidos

    // =====================
    // Constructor
    // =====================
    public Inventario() {
        this.pistas = new ArrayList<>();
    }

    // =====================
    // Métodos públicos
    // =====================

    /**
     * Agrega una nueva pista al inventario.
     */
    public void agregarPista(String pista) {
        if (pista != null && !pista.trim().isEmpty()) {
            pistas.add(pista);
            System.out.println("Pista obtenida: " + pista);
        }
    }

    /**
     * Muestra todas las pistas almacenadas.
     */
    public void mostrarPistas() {
        if (pistas.isEmpty()) {
            System.out.println("No tienes pistas aún.");
        } else {
            System.out.println("=== Inventario de Pistas ===");
            for (String p : pistas) {
                System.out.println("- " + p);
            }
        }
    }

    /**
     * Limpia el inventario (por ejemplo, al reiniciar el juego).
     */
    public void limpiarInventario() {
        pistas.clear();
        System.out.println("Inventario limpiado.");
    }

    // =====================
    // Getters y Setters
    // =====================

    public List<String> getPistas() {
        return pistas;
    }

    public void setPistas(List<String> pistas) {
        this.pistas = pistas;
    }
}

