
package Modelo;

public class Dialogo {

    // =====================
    // Atributos
    // =====================
    private Personaje personaje;   // Quién habla
    private String texto;          // Qué dice
    private String emocion;        // Opcional: emoción del momento (feliz, triste, etc.)

    // =====================
    // Constructor
    // =====================
    public Dialogo(Personaje personaje, String texto, String emocion) {
        this.personaje = personaje;
        this.texto = texto;
        this.emocion = emocion;
    }

    // Sobrecarga si no hay emoción específica
    public Dialogo(Personaje personaje, String texto) {
        this(personaje, texto, "neutral");
    }

    // =====================
    // Métodos
    // =====================

    /**
     * Devuelve el texto del diálogo formateado con el nombre del personaje.
     */
    public String mostrarDialogo() {
        return personaje.hablar(texto);
    }

    // =====================
    // Getters y Setters
    // =====================

    public Personaje getPersonaje() {
        return personaje;
    }

    public void setPersonaje(Personaje personaje) {
        this.personaje = personaje;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getEmocion() {
        return emocion;
    }

    public void setEmocion(String emocion) {
        this.emocion = emocion;
    }
}
