
package Modelo;

import java.util.HashMap;
import java.util.Map;

public class CargadorPersonajes {

    public static Personaje cargarProtagonista() {
        Map<String, String> emo = new HashMap<>();
        emo.put("feliz", "/img/emociones/feliz.png");
        emo.put("neutral", "/img/emociones/neutral.png");
        emo.put("triste", "/img/emociones/triste.png");

        return new Personaje(
                "Protagonista",
                "/img/personajes/protagonista.png",
                emo
        );
    }

    public static Personaje cargarFaris() {
        return new Personaje(
                "Faris",
                "/img/personajes/Faris.png",
                new HashMap<>() // Faris no tiene emociones todavía
        );
    }
}

    

