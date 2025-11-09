package Modelo;

import java.util.ArrayList;
import java.util.List;

public class InventarioPistas {
    // =======================
    // 🔒 Atributos privados
    // =======================
    private List<String> pistas;

    // =======================
    // 🏗️ Constructor
    // =======================
    public InventarioPistas() {
        this.pistas = new ArrayList<>();
    }

    // =======================
    // ⚙️ Métodos públicos
    // =======================
    /** Agrega una nueva pista al inventario */
    public void agregarPista(String pista) {
        pistas.add(pista);
        System.out.println("Pista agregada: " + pista);
    }

    /** Muestra todas las pistas recolectadas */
    public void mostrarPistas() {
        if (pistas.isEmpty()) {
            System.out.println("No tienes pistas aún.");
        } else {
            System.out.println("Pistas encontradas:");
            for (String p : pistas) {
                System.out.println("- " + p);
            }
        }
    }

    /** Devuelve la lista completa de pistas */
    public List<String> getPistas() {
        return pistas;
    }

    /** Limpia el inventario */
    public void limpiarPistas() {
        pistas.clear();
        System.out.println("Inventario vaciado.");
    }
}
