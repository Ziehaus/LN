
package Modelo;



public abstract class EscenaBase implements IEscena {
    protected String titulo;
    protected String dialogo;
    protected String fondo;
    protected String musicaFondo;
    protected String efectoSonido;
    protected Minijuego minijuegoAsociado;

    // Constructor
    public EscenaBase(String titulo, String dialogo, String fondo, String musicaFondo, String efectoSonido) {
        this.titulo = titulo;
        this.dialogo = dialogo;
        this.fondo = fondo;
        this.musicaFondo = musicaFondo;
        this.efectoSonido = efectoSonido;
        this.minijuegoAsociado = null;
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

    @Override
    public void iniciarMinijuego() {
        if (minijuegoAsociado != null) {
            minijuegoAsociado.empezar();
        } else {
            System.out.println("No hay minijuego asociado.");
        }
    }

    public void asignarMinijuego(Minijuego mini) {
        this.minijuegoAsociado = mini;
    }
}

