package Modelo;

import java.util.ArrayList;
import java.util.List;

public class Juego {
    // =======================
    // 🔒 Atributos privados
    // =======================
    private List<EscenaBase> escenas;
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

    /** Carga las escenas iniciales del juego */
    public void cargarEscenas() {
        // 🔹 Crear un diálogo de ejemplo
        Dialogo d1 = new Dialogo("Protagonista");
        d1.agregarLinea("¿Dónde estoy?");
        d1.agregarLinea("Parece una sala de clases, pero algo no está bien...");
        d1.agregarLinea("Debería buscar una pista.");

        // 🔹 Crear una escena de diálogo
        EscenaDialogo escena1 = new EscenaDialogo(
            "Despertar",
            "fondo_aula.jpg",
            "musica_suspenso.mp3",
            "puerta.mp3",
            d1
        );

        // 🔹 Otra escena (por ejemplo, luego de recoger una pista)
        Dialogo d2 = new Dialogo("Voz Misteriosa");
        d2.agregarLinea("Bienvenido al juego de la desesperación...");
        d2.agregarLinea("Tu objetivo es simple: sobrevive.");

        EscenaDialogo escena2 = new EscenaDialogo(
            "Mensaje misterioso",
            "fondo_pasillo.jpg",
            "musica_tensa.mp3",
            null,
            d2
        );

        // 🔹 Agregar las escenas al juego
        escenas.add(escena1);
        escenas.add(escena2);
    }

    /** Inicia el juego desde la primera escena */
    public void iniciarJuego() {
        if (!escenas.isEmpty()) {
            System.out.println("🔸 Iniciando el juego...");
            escenas.get(escenaActual).mostrarEscena();
        } else {
            System.out.println("No hay escenas cargadas.");
        }
    }

    /** Avanza a la siguiente escena */
    public void siguienteEscena() {
        if (escenaActual < escenas.size() - 1) {
            escenaActual++;
            escenas.get(escenaActual).mostrarEscena();
        } else {
            System.out.println("🏁 Fin del juego.");
        }
    }

    /** Inicia un minijuego (si aplica) */
    public void iniciarMinijuego(Minijuego mini) {
        enMinijuego = true;
        mini.empezar();
        enMinijuego = false;
    }

    /** Agrega una pista al inventario */
    public void agregarPista(String pista) {
        inventarioPistas.agregarPista(pista);
    }

    /** Muestra las pistas recolectadas */
    public void mostrarInventario() {
        inventarioPistas.mostrarPistas();
    }

    // =======================
    // 🔁 Getters
    // =======================
    public InventarioPistas getInventarioPistas() {
        return inventarioPistas;
    }

    public List<EscenaBase> getEscenas() {
        return escenas;
    }

    public int getEscenaActual() {
        return escenaActual;
    }

    public boolean isEnMinijuego() {
        return enMinijuego;
    }
}

        
     
    
    
    
    
    
    

    
    
    
    
    
    
    
    
    
    
    

