
package Modelo;



public abstract class EscenaBase implements IEscena {
    protected String titulo;
    protected String dialogo;
    protected String fondo;
    protected String musicaFondo;
    protected String efectoSonido;

    // Constructor
    public EscenaBase(String titulo, String dialogo, String fondo, String musicaFondo, String efectoSonido) {
        this.titulo = titulo;
        this.dialogo = dialogo;
        this.fondo = fondo;
        this.musicaFondo = musicaFondo;
        this.efectoSonido = efectoSonido;
    }

    // Métodos comunes
    @Override
    public void mostrarEscena() {
        System.out.println("=== " + titulo + " ===");
        System.out.println("Fondo: " + fondo);
        reproducirMusica();
        reproducirEfecto();
        System.out.println(dialogo);
    }

    @Override
    public void reproducirMusica() {
        if (musicaFondo != null && !musicaFondo.isEmpty()) {
            System.out.println("Reproduciendo música: " + musicaFondo);
        }
    }

    @Override
    public void reproducirEfecto() {
        if (efectoSonido != null && !efectoSonido.isEmpty()) {
            System.out.println("Efecto: " + efectoSonido);
        }
    }


}

