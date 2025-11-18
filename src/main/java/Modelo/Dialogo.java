package Modelo;

public class Dialogo {

    private final Personaje personaje;
    private final String texto;
    private final String emocion;  // puede ser null → neutral

    public Dialogo(Personaje personaje, String texto, String emocion) {

        if (personaje == null)
            throw new IllegalArgumentException("El diálogo debe tener un personaje.");

        if (texto == null)
            throw new IllegalArgumentException("El texto del diálogo no puede ser null.");

        this.personaje = personaje;
        this.texto = texto;
        this.emocion = emocion; // puede ser null
    }

    public Personaje getPersonaje() {
        return personaje;
    }

    public String getTexto() {
        return texto;
    }

    public String getEmocion() {
        return emocion;
    }
}


