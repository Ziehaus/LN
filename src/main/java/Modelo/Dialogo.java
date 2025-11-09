
package Modelo;

import java.util.ArrayList;
import java.util.List;

public class Dialogo {
    // =======================
    // 🔒 Atributos privados
    // =======================
    private String personaje;
    private List<String> lineas;
    private int indiceActual;

    // =======================
    // 🏗️ Constructor
    // =======================
    public Dialogo(String personaje) {
        this.personaje = personaje;
        this.lineas = new ArrayList<>();
        this.indiceActual = 0;
    }

    // =======================
    // ⚙️ Métodos públicos
    // =======================
    /** Agrega una nueva línea de diálogo */
    public void agregarLinea(String texto) {
        lineas.add(texto);
    }

    /** Muestra la siguiente línea del diálogo */
    public void mostrarSiguienteLinea() {
        if (indiceActual < lineas.size()) {
            System.out.println(personaje + ": " + lineas.get(indiceActual));
            indiceActual++;
        } else {
            System.out.println("Fin del diálogo.");
        }
    }

    /** Reinicia el diálogo desde el inicio */
    public void reiniciar() {
        indiceActual = 0;
    }

    /** Devuelve true si aún hay líneas por mostrar */
    public boolean hayMasLineas() {
        return indiceActual < lineas.size();
    }

    // =======================
    // 🔁 Getters y Setters
    // =======================
    public String getPersonaje() {
        return personaje;
    }

    public void setPersonaje(String personaje) {
        this.personaje = personaje;
    }

    public List<String> getLineas() {
        return lineas;
    }

    public void setLineas(List<String> lineas) {
        this.lineas = lineas;
    }

    public int getIndiceActual() {
        return indiceActual;
    }
}
