
package principal;

import Modelo.*;
import java.util.ArrayList;
import java.util.List;

public class main {

    public static void main(String[] args) {

        // =====================
        // Crear personajes
        // =====================
        Personaje sei = new Personaje("sei", "El protagonista .", "img/sei.png");
        Personaje kyoko = new Personaje("Kyoko", "La detective .", "img/kyoko.png");

        // =====================
        // Crear diálogos
        // =====================
        List<Dialogo> dialogosIntro = new ArrayList<>();
        dialogosIntro.add(new Dialogo(sei, "¿Dónde estoy...? Todo está oscuro...", "confundido"));
        dialogosIntro.add(new Dialogo(kyoko, "Despierta. No hay tiempo que perder.", "seria"));
        dialogosIntro.add(new Dialogo(sei, "¿Quién eres tú?", "sorprendido"));
        dialogosIntro.add(new Dialogo(kyoko, "Te explicaré todo... pero primero debemos salir de aquí.", "neutral"));

        // =====================
        // Crear escena de diálogo
        // =====================
        EscenaDialogo escena1 = new EscenaDialogo(
                "Despertar Misterioso",
                "fondo_aula.jpg",
                "musica_suspenso.mp3",
                "puerta_abriendose.wav",
                dialogosIntro,
                List.of(sei, kyoko)
        );
        
        // =====================
        // Crear lista de escenas
        // =====================
        List<EscenaBase> escenas = new ArrayList<>();
        escenas.add(escena1);

        // =====================
        // Crear juego
        // =====================
        Juego juego = new Juego("Classmatter: El inicio", escenas);

        // =====================
        // Iniciar juego
        // =====================
        juego.iniciarJuego();

        // =====================
        // Avanzar diálogos manualmente
        // =====================
        EscenaDialogo escenaActual = (EscenaDialogo) escenas.get(0);
        
        

        // Avanzar paso a paso
        escenaActual.siguienteDialogo();
        escenaActual.siguienteDialogo();
        escenaActual.siguienteDialogo();
        escenaActual.siguienteDialogo(); // Intentar avanzar más allá del final
        // Avanzar a la siguiente escena (la de decisión)
                    
        

        // =====================
        // Probar inventario
        // =====================
        juego.getInventarioPistas().agregarPista("Llave oxidada encontrada en el aula.");
        juego.getInventarioPistas().mostrarPistas();
    }
}
//zd