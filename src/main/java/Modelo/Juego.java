package Modelo;


import java.util.List;

public class Juego {

    // =====================
    // Atributos
    // =====================
    private String titulo;
    private List<EscenaBase> escenas;     // Lista de escenas del juego
    private int indiceEscenaActual;       // Controla en qué escena se encuentra
    private Inventario inventarioPistas;  // Podría almacenar objetos, pistas o estados

    // =====================
    // Constructor
    // =====================
    public Juego(String titulo, List<EscenaBase> escenas) {
        this.titulo = titulo;
        this.escenas = escenas;
        this.indiceEscenaActual = 0;
        this.inventarioPistas = new Inventario();
    }

    // =====================
    // Métodos públicos
    // =====================

    /**
     * Inicia el juego desde la primera escena.
     */
    public void iniciarJuego() {
        System.out.println("=== Iniciando: " + titulo + " ===");
        if (!escenas.isEmpty()) {
            escenas.get(indiceEscenaActual).mostrarEscena();
        } else {
            System.out.println("No hay escenas cargadas.");
        }
    }

    /**
     * Muestra la escena actual.
     */
    public void mostrarEscenaActual() {
        if (indiceEscenaActual < escenas.size()) {
            escenas.get(indiceEscenaActual).mostrarEscena();
        } else {
            System.out.println("No hay más escenas en el juego.");
        }
    }

    /**
     * Avanza a la siguiente escena.
     */
    public void siguienteEscena() {
        if (indiceEscenaActual < escenas.size() - 1) {
            indiceEscenaActual++;
            mostrarEscenaActual();
        } else {
            System.out.println("Has completado todas las escenas.");
        }
    }

    /**
     * Reinicia el juego desde la primera escena.
     */
    public void reiniciarJuego() {
        indiceEscenaActual = 0;
        System.out.println("Juego reiniciado.");
        iniciarJuego();
    }

    // =====================
    // Getters y Setters
    // =====================

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public List<EscenaBase> getEscenas() {
        return escenas;
    }

    public void setEscenas(List<EscenaBase> escenas) {
        this.escenas = escenas;
    }

    public int getIndiceEscenaActual() {
        return indiceEscenaActual;
    }

    public void setIndiceEscenaActual(int indiceEscenaActual) {
        this.indiceEscenaActual = indiceEscenaActual;
    }

    public Inventario getInventarioPistas() {
        return inventarioPistas;
    }

    public void setInventarioPistas(Inventario inventarioPistas) {
        this.inventarioPistas = inventarioPistas;
    }
}


        
     
    
    
    
    
    
    

    
    
    
    
    
    
    
    
    
    
    

