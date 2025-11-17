package Modelo;

public class Dialogo {

    private Personaje personaje;
    private String texto;
    private String emocion;

    public Dialogo(Personaje personaje, String texto, String emocion) {
        this.personaje = personaje;
        this.texto = texto;
        this.emocion = emocion;
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

