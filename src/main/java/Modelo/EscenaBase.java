package Modelo;

public abstract class EscenaBase implements IEscena {

    // =====================
    // Atributos
    // =====================
    protected String titulo;
    protected String descripcion;     // ← ahora sí incluida y funcional
    protected String fondo;
    protected String musicaFondo;
    protected String efectoSonido;

    // =====================
    // Constructor
    // =====================
    public EscenaBase(String titulo, String descripcion, String fondo, 
                      String musicaFondo, String efectoSonido) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.fondo = fondo;
        this.musicaFondo = musicaFondo;
        this.efectoSonido = efectoSonido;
    }

    // =====================
    // Métodos comunes
    // =====================
    @Override
    public void mostrarEscena() {
        System.out.println("=== " + titulo + " ===");
        System.out.println("Fondo: " + fondo);

        reproducirMusica();
        reproducirEfecto();

        if (descripcion != null && !descripcion.isEmpty()) {
            System.out.println(descripcion);
        }
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
            System.out.println("Efecto de sonido: " + efectoSonido);
        }
    }

    // =====================
    // Getters / Setters
    // =====================

    public String getTitulo() {
        return titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
