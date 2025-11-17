package Modelo;

import java.util.List;

public class EscenaDecision extends EscenaBase {

    private String pregunta;
    private List<String> opciones;

    public EscenaDecision(String titulo, String descripcion, String fondo,
                          String musicaFondo, String efectoSonido,
                          String pregunta, List<String> opciones) {

        super(titulo, descripcion, fondo, musicaFondo, efectoSonido);
        this.pregunta = pregunta;
        this.opciones = opciones;
    }

    @Override
    public void mostrarEscena() {
        System.out.println("=== Escena de Decisión: " + titulo + " ===");
        System.out.println("Fondo: " + fondo);
        reproducirMusica();
        reproducirEfecto();

        if (descripcion != null && !descripcion.isEmpty()) {
            System.out.println(descripcion);
        }

        System.out.println("\n" + pregunta);

        for (int i = 0; i < opciones.size(); i++) {
            System.out.println((i + 1) + ". " + opciones.get(i));
        }
    }

    public List<String> getOpciones() {
        return opciones;
    }
}
