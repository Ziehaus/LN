
package Modelo;

import java.util.HashMap;
import java.util.Map;

public class CargadorPersonajes {

    public static Personaje cargarMakoto() {
        Map<String, String> emo = new HashMap<>();
        emo.put("confundido", "/img/emociones/confundido.png");
        emo.put("pensando", "/img/emociones/pensando.png");
        emo.put("triste", "/img/emociones/triste.png");
        emo.put("decidido", "/img/emociones/decidido.png");
        emo.put("neutral", "/img/emociones/neutral.png");

        return new Personaje(
                "Makoto",
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

    

