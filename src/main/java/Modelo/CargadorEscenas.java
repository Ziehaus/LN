// CargadorEscenas.java
package Modelo;

import java.util.*;

public class CargadorEscenas {

    public static Map<String, IEscena> cargar() {

        Map<String, IEscena> escenas = new HashMap<>();

        // ---- PERSONAJES ----
        Personaje prota = CargadorPersonajes.cargarProtagonista();
        Personaje faris = CargadorPersonajes.cargarFaris();

        // ---------- ESCENA 1: DIÁLOGO ----------
        List<Dialogo> dialogos = new ArrayList<>();
        dialogos.add(new Dialogo(prota, "¿Dónde estoy...?", "triste"));
        dialogos.add(new Dialogo(faris, "Despierta, finalmente llegaste.", null));
        dialogos.add(new Dialogo(prota, "¿Faris? ¿Qué está pasando?", "neutral"));
        dialogos.add(new Dialogo(faris, "Luego te explico, ahora debemos elegir un camino.", null));

        EscenaDialogo escenaInicio = new EscenaDialogo(
                "escena_inicio",
                "Comienzo de la aventura",
                "/img/fondos/fondo1.jpg",
                dialogos
        );
        escenaInicio.musicaFondo = "/audio/musica1.wav";
        escenaInicio.efectoSonido = "/audio/click.wav";

        escenaInicio.setSiguienteEscena("escena_decision");

        escenas.put("escena_inicio", escenaInicio);


        // ---------- ESCENA 2: DECISIÓN ----------
        List<Opcion> opciones = new ArrayList<>();

        opciones.add(new Opcion(
                "Seguir a Faris",
                "escena_final_buena"
        ));

        opciones.add(new Opcion(
                "Ignorar a Faris y tomar otro camino",
                "escena_final_mala"
        ));

        EscenaDecision escenaDecision = new EscenaDecision(
                "escena_decision",
                "Debes decidir tu destino",
                opciones
        );

        escenaDecision.fondo = "/img/fondos/fondo2.jpg";

        escenas.put("escena_decision", escenaDecision);


        // ---------- ESCENA 3: FINAL BUENO ----------
        EscenaDialogo finalBueno = new EscenaDialogo(
                "escena_final_buena",
                "Final bueno",
                "/img/fondos/fondo2.jpg",
                List.of(
                        new Dialogo(faris, "Elegiste bien. Te guiaré a casa.", null)
                )
        );
        escenas.put("escena_final_buena", finalBueno);


        // ---------- ESCENA 4: FINAL MALO ----------
        EscenaDialogo finalMalo = new EscenaDialogo(
                "escena_final_mala",
                "Final malo",
                "/img/fondos/fondo1.jpg",
                List.of(
                        new Dialogo(prota, "Algo no está bien... ¿Qué fue esa sombra?", "triste")
                )
        );
        escenas.put("escena_final_mala", finalMalo);

        return escenas;
    }
}

