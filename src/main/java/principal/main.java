package principal;

import Modelo.*;
import java.util.ArrayList;
import java.util.List;

public class main {

    public static void main(String[] args) {

        // =====================
        // PERSONAJES
        // =====================
        Personaje sei = new Personaje("Sei", "El protagonista.", "img/sei.png");
        Personaje kyoko = new Personaje("Kyoko", "La detective.", "img/kyoko.png");


        // =====================
        // ESCENA 0 → INTRO DIÁLOGO
        // =====================
        List<Dialogo> dialogosIntro = new ArrayList<>();
        dialogosIntro.add(new Dialogo(sei, "¿Dónde estoy...? Todo está oscuro...", "confundido"));
        dialogosIntro.add(new Dialogo(kyoko, "Despierta. No hay tiempo que perder.", "seria"));
        dialogosIntro.add(new Dialogo(sei, "¿Quién eres tú?", "sorprendido"));
        dialogosIntro.add(new Dialogo(kyoko, "Te explicaré todo... pero primero debemos salir de aquí.", "neutral"));

        EscenaDialogo escenaIntro = new EscenaDialogo(
                "Despertar Misterioso",
                "fondo_aula.jpg",
                "musica_suspenso.mp3",
                "puerta_abriendose.wav",
                dialogosIntro,
                List.of(sei, kyoko)
        );


        // =====================
        // ESCENA 1 → DECISIÓN
        // =====================
        List<String> opcionesDecision = List.of(
                "Seguir a Kyoko",
                "Explorar el aula",
                "Esperar en el salón"
        );

        EscenaDecision escenaDecision = new EscenaDecision(
                "Decisión en el aula",
                "Debes tomar una decisión importante.",
                "fondo_aula.jpg",
                "musica_tensa.mp3",
                "tic_tac.wav",
                "¿Qué decides hacer?",
                opcionesDecision
        );


        // =====================
        // ESCENA 2 → SEGUIR A KYOKO
        // =====================
        List<Dialogo> dSeguirKyoko = new ArrayList<>();
        dSeguirKyoko.add(new Dialogo(sei, "Esto... ¿Cuál es tu nombre?", "confundido"));
        dSeguirKyoko.add(new Dialogo(kyoko, "Me llamo Kyoko.", "seria"));
        dSeguirKyoko.add(new Dialogo(sei, "Kyoko, un gusto conocerte. Mi nombre es Sei.", "neutral"));
        dSeguirKyoko.add(new Dialogo(sei, "(Ahora que me fijo bien, Kyoko es bastante atractiva)", "pensando"));
        dSeguirKyoko.add(new Dialogo(sei, "¿No era mejor idea despertar a los demás estudiantes?", "neutral"));
        dSeguirKyoko.add(new Dialogo(kyoko, "No estoy segura. Me desperté hace apenas tres minutos.", "neutral"));

        EscenaDialogo escenaSeguirKyoko = new EscenaDialogo(
                "Escena con Kyoko",
                "fondo_pasillo.jpg",
                "musica_suspenso.mp3",
                "pasos.wav",
                dSeguirKyoko,
                List.of(sei, kyoko)
        );


        // =====================
        // ESCENA 3 → EXPLORAR EL AULA
        // =====================
        List<Dialogo> dExplorarAula = new ArrayList<>();
        dExplorarAula.add(new Dialogo(sei, "(Intento despertar a los demás estudiantes, pero no reaccionan...)", "pensando"));
        dExplorarAula.add(new Dialogo(sei, "(Reviso el escritorio del profesor y encuentro una llave.)", "pensando"));
        dExplorarAula.add(new Dialogo(sei, "(No parece haber nada más útil aquí.)", "serio"));

        EscenaDialogo escenaExplorarAula = new EscenaDialogo(
                "Explorando el Aula",
                "fondo_aula.jpg",
                "musica_suspenso.mp3",
                "caminando.wav",
                dExplorarAula,
                List.of(sei)
        );


        // =====================
        // ESCENA 4 → ESPERAR (opción 3)
        // =====================
        List<Dialogo> dEsperar = new ArrayList<>();
        dEsperar.add(new Dialogo(sei, "(Decido esperar... pero nada pasa.)", "pensando"));
        dEsperar.add(new Dialogo(sei, "(El silencio es demasiado inquietante.)", "serio"));

        EscenaDialogo escenaEsperar = new EscenaDialogo(
                "Esperando en el Aula",
                "fondo_aula.jpg",
                "musica_tensa.mp3",
                "tic_tac.wav",
                dEsperar,
                List.of(sei)
        );


        // =====================
        // ORDEN DE ESCENAS
        // =====================
        List<EscenaBase> escenas = new ArrayList<>();
        escenas.add(escenaIntro);        // 0
        escenas.add(escenaDecision);     // 1
        escenas.add(escenaSeguirKyoko);  // 2  ← opción 1
        escenas.add(escenaExplorarAula); // 3  ← opción 2
        escenas.add(escenaEsperar);      // 4  ← opción 3
        

        // =====================
        // INICIAR EL JUEGO
        // =====================
        Juego juego = new Juego("Classmatter: El inicio", escenas);
        juego.iniciarJuego();
    }
}
