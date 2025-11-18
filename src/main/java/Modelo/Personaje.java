package Modelo;

import java.util.Map;
import java.util.HashMap;

public class Personaje {

    private final String nombre;
    private final String imagenBase;  // /img/personajes/prota.png
    private final Map<String, String> rutaEmociones; // "feliz" -> "/img/emociones/prota_feliz.png"

    public Personaje(String nombre, String imagenBase, Map<String, String> emociones) {

        if (nombre == null)
            throw new IllegalArgumentException("El nombre del personaje no puede ser null.");

        if (imagenBase == null)
            throw new IllegalArgumentException("La imagen base del personaje no puede ser null.");

        this.nombre = nombre;
        this.imagenBase = imagenBase;

        // Si emociones es null, usamos un mapa vacío
        this.rutaEmociones = (emociones != null)
                ? new HashMap<>(emociones)
                : new HashMap<>();
    }

    public String getNombre() {
        return nombre;
    }

    public String getImagenBase() {
        return imagenBase;
    }

    /** 
     * Devuelve la ruta de la emoción. 
     * Si la emoción no existe, retorna la imagen base.
     */
    public String getImagenEmocion(String emocion) {
        if (emocion == null) return imagenBase;
        return rutaEmociones.getOrDefault(emocion, imagenBase);
    }
}
