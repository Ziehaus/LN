package Modelo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CargadorEscenas {

    public static Map<String, IEscena> cargar() {

        Map<String, IEscena> escenas = new HashMap<>();

        // ---- PERSONAJES ----
        Personaje makoto = CargadorPersonajes.cargarMakoto();
        Personaje faris = CargadorPersonajes.cargarFaris();

        // ---------------------------------------------------------------------
        // ESCENA 1 — MONÓLOGO INICIAL
        // ID: escena_monologo_inicio
        // ---------------------------------------------------------------------
        List<Dialogo> dialogosMonologo1 = new ArrayList<>();
        dialogosMonologo1.add(new Dialogo(makoto, "Click to start", "neutral"));
        dialogosMonologo1.add(new Dialogo(makoto,
                "Primer día de preparatoria… Me siento extraño.\nNo sé si emocionado o nervioso… tal vez ambas cosas.",
                "neutral"));
        dialogosMonologo1.add(new Dialogo(makoto,
                "Dicen que la preparatoria es el punto donde uno cambia.\n¿Será cierto también para mí?",
                "preocupado"));
        dialogosMonologo1.add(new Dialogo(makoto, "Bueno… solo hay un modo de averiguarlo.", "neutral"));

        EscenaDialogo escenaMonologoInicio = new EscenaDialogo(
                "escena_monologo_inicio",
                "Comienzo de la aventura",
                "/img/fondos/calle_manana.jpg",
                dialogosMonologo1
        );
        // música y efecto (accesible desde el mismo paquete Modelo)
        escenaMonologoInicio.musicaFondo = "/audio/musica/musica_inicio.wav";
        escenaMonologoInicio.efectoSonido = "/audio/sfx/click.wav";

        escenaMonologoInicio.setSiguienteEscena("escena_encuentro_faris_manana");
        escenas.put(escenaMonologoInicio.getId(), escenaMonologoInicio);

        // ---------------------------------------------------------------------
        // ESCENA 2 — ENCUENTRO CON FARIS (MAÑANA)
        // ID: escena_encuentro_faris_manana
        // ---------------------------------------------------------------------
        List<Dialogo> dialogosEncuentroFaris = new ArrayList<>();
        dialogosEncuentroFaris.add(new Dialogo(faris,
                "¡Makoto! Qué sorpresa verte tan temprano. ¿Listo para el primer día?",
                "feliz"));
        dialogosEncuentroFaris.add(new Dialogo(makoto, "Faris… No esperaba encontrarte.", "neutral"));
        dialogosEncuentroFaris.add(new Dialogo(faris, "Anda, cuéntame. ¿Cómo te sientes?", "neutral"));

        EscenaDialogo escenaEncuentroFaris = new EscenaDialogo(
                "escena_encuentro_faris_manana",
                "Encuentro con Faris (Camino a la escuela)",
                "/img/fondos/calle_manana.jpg",
                dialogosEncuentroFaris
        );
        // La siguiente no es directa: irá a la escena de decisión
        escenaEncuentroFaris.setSiguienteEscena("decision_faris_manana");
        escenas.put(escenaEncuentroFaris.getId(), escenaEncuentroFaris);

        // ---------------------------------------------------------------------
        // DECISIÓN 1 — RESPUESTA A FARIS (MAÑANA)
        // ID: decision_faris_manana
        // ---------------------------------------------------------------------
        List<Opcion> opcionesManana = new ArrayList<>();
        opcionesManana.add(new Opcion("Estoy nervioso… pero intentaré hacerlo bien.", "respuesta_faris_m1"));
        opcionesManana.add(new Opcion("¡Obvio! Hoy voy con toda la energía.", "respuesta_faris_m2"));
        opcionesManana.add(new Opcion("Preferiría seguir dormido, sinceramente.", "respuesta_faris_m3"));

        EscenaDecision decisionFarisManana = new EscenaDecision(
                "decision_faris_manana",
                "¿Qué le respondes a Faris?",
                opcionesManana
        );
        decisionFarisManana.fondo = "/img/fondos/calle_manana.jpg";
        escenas.put(decisionFarisManana.getId(), decisionFarisManana);

        // ---------------------------------------------------------------------
        // RESPUESTAS A DECISIÓN 1 (mañana)
        // Cada respuesta es una EscenaDialogo corta que cierra con "Vamos, no queremos llegar tarde."
        // ---------------------------------------------------------------------
        EscenaDialogo respuestaM1 = new EscenaDialogo(
                "respuesta_faris_m1",
                "Respuesta: nervioso",
                "/img/fondos/calle_manana.jpg",
                List.of(
                        new Dialogo(faris,
                                "Lo entiendo. Los primeros días siempre imponen un poco, pero te irá bien. Si quieres, podemos almorzar juntos.",
                                "tranquilo"),
                        new Dialogo(faris, "Vamos, no queremos llegar tarde.", "neutral")
                )
        );
        respuestaM1.setSiguienteEscena("escena_dia_escuela");
        escenas.put(respuestaM1.getId(), respuestaM1);

        EscenaDialogo respuestaM2 = new EscenaDialogo(
                "respuesta_faris_m2",
                "Respuesta: entusiasta",
                "/img/fondos/calle_manana.jpg",
                List.of(
                        new Dialogo(faris, "¡Ese es el Makoto que quería ver! Me alegra que vengas con buen ánimo.", "feliz"),
                        new Dialogo(faris, "Vamos, no queremos llegar tarde.", "neutral")
                )
        );
        respuestaM2.setSiguienteEscena("escena_dia_escuela");
        escenas.put(respuestaM2.getId(), respuestaM2);

        EscenaDialogo respuestaM3 = new EscenaDialogo(
                "respuesta_faris_m3",
                "Respuesta: bromista",
                "/img/fondos/calle_manana.jpg",
                List.of(
                        new Dialogo(faris, "Jajaja, tú y tu cama… pero ánimo, que no puedes sobrevivir a la escuela durmiendo.", "bromista"),
                        new Dialogo(faris, "Vamos, no queremos llegar tarde.", "neutral")
                )
        );
        respuestaM3.setSiguienteEscena("escena_dia_escuela");
        escenas.put(respuestaM3.getId(), respuestaM3);

        // ---------------------------------------------------------------------
        // ESCENA 3 — DÍA ESCOLAR NORMAL
        // ID: escena_dia_escuela
        // ---------------------------------------------------------------------
        EscenaDialogo escenaDiaEscolar = new EscenaDialogo(
                "escena_dia_escuela",
                "Monólogo durante el día escolar",
                "/img/fondos/aula.jpg",
                List.of(
                        new Dialogo(makoto, "El día pasó bastante rápido. Presentaciones, profesores, más presentaciones…", "neutral"),
                        new Dialogo(makoto, "Nada fuera de lo común, pero… sentí que varias personas me observaban.", "neutral"),
                        new Dialogo(makoto, "¿Será solo mi imaginación?", "neutral")
                )
        );
        escenaDiaEscolar.setSiguienteEscena("escena_parque_tarde");
        escenas.put(escenaDiaEscolar.getId(), escenaDiaEscolar);

        // ---------------------------------------------------------------------
        // ESCENA 4 — ENCUENTRO EN EL PARQUE (TARDE)
        // ID: escena_parque_tarde
        // ---------------------------------------------------------------------
        EscenaDialogo escenaParqueTarde = new EscenaDialogo(
                "escena_parque_tarde",
                "Encuentro en el parque con Faris",
                "/img/fondos/parque_tarde.jpg",
                List.of(
                        new Dialogo(makoto, "Siempre, al regresar a casa sigo la misma ruta; esta vez decidí cambiarla.", "neutral"),
                        new Dialogo(makoto, "Faris… ¿tú también pasas por este parque?", "neutral"),
                        new Dialogo(faris, "A veces. Me ayuda a aclarar la mente.", "neutral"),
                        new Dialogo(faris, "Aunque no esperaba verte dos veces en el mismo día.", "feliz"),
                        new Dialogo(makoto, "¿Pensando en algo?", "neutral")
                )
        );
        // Enlazamos a la decisión de la tarde
        escenaParqueTarde.musicaFondo = "/audio/musica_parque.mp3";
        escenaParqueTarde.setSiguienteEscena("decision_faris_tarde");
        escenas.put(escenaParqueTarde.getId(), escenaParqueTarde);

        // ---------------------------------------------------------------------
        // DECISIÓN 2 — RESPUESTA A FARIS (TARDE)
        // ID: decision_faris_tarde
        // ---------------------------------------------------------------------
        List<Opcion> opcionesTarde = new ArrayList<>();
        opcionesTarde.add(new Opcion("Sí, fue un día largo… entiendo cómo te sientes.", "respuesta_faris_t1"));
        opcionesTarde.add(new Opcion("¿Tú cansada? Eso sí que es raro.", "respuesta_faris_t2"));
        opcionesTarde.add(new Opcion("Te ves diferente… ¿estás bien?", "respuesta_faris_t3"));

        EscenaDecision decisionFarisTarde = new EscenaDecision(
                "decision_faris_tarde",
                "¿Qué le dirás a Faris?",
                opcionesTarde
        );
        decisionFarisTarde.fondo = "/img/fondos/parque_tarde.jpg";
        escenas.put(decisionFarisTarde.getId(), decisionFarisTarde);

        // ---------------------------------------------------------------------
        // RESPUESTAS A DECISIÓN 2 (tarde)
        // ---------------------------------------------------------------------
        EscenaDialogo respuestaT1 = new EscenaDialogo(
                "respuesta_faris_t1",
                "Respuesta: comprensiva",
                "/img/fondos/parque_tarde.jpg",
                List.of(
                        new Dialogo(faris, "Sí… pero hablarlo con alguien ayuda. Gracias por entenderlo, Makoto.", "serio"),
                        new Dialogo(faris, "Vamos, te acompaño un rato mientras caminamos.", "neutral")
                )
        );
        respuestaT1.setSiguienteEscena("escena_fin_dia");
        escenas.put(respuestaT1.getId(), respuestaT1);

        EscenaDialogo respuestaT2 = new EscenaDialogo(
                "respuesta_faris_t2",
                "Respuesta: bromista",
                "/img/fondos/parque_tarde.jpg",
                List.of(
                        new Dialogo(faris, "¡Oye! Yo también soy humano, ¿sabes? Me canso como cualquiera.", "feliz"),
                        new Dialogo(faris, "Vamos, te acompaño un rato mientras caminamos.", "neutral")
                )
        );
        respuestaT2.setSiguienteEscena("escena_fin_dia");
        escenas.put(respuestaT2.getId(), respuestaT2);

        EscenaDialogo respuestaT3 = new EscenaDialogo(
                "respuesta_faris_t3",
                "Respuesta: preocupada",
                "/img/fondos/parque_tarde.jpg",
                List.of(
                        new Dialogo(faris,
                                "¿Notaste eso…? Supongo que no pude ocultarlo. No te preocupes, solo tengo muchas cosas en la cabeza.",
                                "triste"),
                        new Dialogo(faris, "Vamos, te acompaño un rato mientras caminamos.", "neutral")
                )
        );
        respuestaT3.setSiguienteEscena("escena_fin_dia");
        escenas.put(respuestaT3.getId(), respuestaT3);

        // ---------------------------------------------------------------------
        // ESCENA 5 — FIN DEL DÍA
        // ID: escena_fin_dia
        // ---------------------------------------------------------------------
        EscenaDialogo escenaFinDia = new EscenaDialogo(
                "escena_fin_dia",
                "Cierre del primer día",
                "/img/fondos/calle_noche.jpg",
                List.of(
                        new Dialogo(makoto, "Hoy… no estuvo tan mal.", "neutral"),
                        new Dialogo(makoto, "Quizás… solo quizás… la preparatoria no será tan terrible.", "feliz"),
                        new Dialogo(makoto, "Y Faris… también cambia algo en mí.", "neutral")
                )
        );
        // Aquí podrías reiniciar al menú, o terminar la historia del capítulo
        escenaFinDia.setSiguienteEscena(null); // fin de capítulo
        escenas.put(escenaFinDia.getId(), escenaFinDia);

        return escenas;
    }
}


