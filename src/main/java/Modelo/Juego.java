package modelo;

import java.util.ArrayList;
import java.util.List;

public class Juego {
    // =======================
    // 🔒 Atributos privados
    // =======================
    private List<Escena> escenas;
    private int escenaActual;
    private InventarioPistas inventarioPistas;
    private boolean enMinijuego;

    // =======================
    // 🏗️ Constructor
    // =======================
    public Juego() {
        this.escenas = new ArrayList<>();
        this.escenaActual = 0;
        this.inventarioPistas = new InventarioPistas();
        this.enMinijuego = false;
    }

    // =======================
    // ⚙️ Métodos públicos
    // =======================
    
    /** Inicia el juego desde la primera escena */
    public void iniciarJuego() {
        if (!escenas.isEmpty()) {
            System.out.println("Iniciando juego...");
            escenas.get(escenaActual).mostrarEscena();
        } else {
            System.out.println("No hay escenas cargadas.");
        }
    }

    /** Cambia a la siguiente escena */
    public void siguienteEscena() {
        if (escenaActual < escenas.size() - 1) {
            escenaActual++;
            escenas.get(escenaActual).mostrarEscena();
        } else {
            System.out.println("Fin del juego.");
        }
    }

    /** Decide cuándo iniciar un minijuego */
    public void iniciarMinijuego(Minijuego mini) {
        this.enMinijuego = true;
        mini.empezar();
        this.enMinijuego = false;
    }

    /** Agrega una nueva escena al juego */
    public void agregarEscena(Escena escena) {
        escenas.add(escena);
    }

    // =======================
    // 🔁 Getters y Setters
    // =======================
    public InventarioPistas getInventarioPistas() {
        return inventarioPistas;
    }

    public void setInventarioPistas(InventarioPistas inventarioPistas) {
        this.inventarioPistas = inventarioPistas;
    }

    public List<Escena> getEscenas() {
        return escenas;
    }

    public int getEscenaActual() {
        return escenaActual;
    }

    public void setEscenaActual(int escenaActual) {
        this.escenaActual = escenaActual;
    }

    public boolean isEnMinijuego() {
        return enMinijuego;
    }
}

        
     
    
    
    
    
    
    

    
    
    
    
    
    
    
    
    
    
    

