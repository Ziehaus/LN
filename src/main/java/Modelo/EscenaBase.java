package Modelo;

public abstract class EscenaBase implements IEscena {

    protected String id;
    protected String descripcion;
    protected String siguienteEscena;   // USADO por Juego y ControladorJuego
    protected String fondo;
    protected String musicaFondo;
    protected String efectoSonido;

    public EscenaBase(String id, String descripcion, String siguienteEscena,
                      String fondo, String musicaFondo, String efectoSonido) {

        this.id = id;
        this.descripcion = descripcion;
        this.siguienteEscena = siguienteEscena;
        this.fondo = fondo;
        this.musicaFondo = musicaFondo;
        this.efectoSonido = efectoSonido;
    }

    public EscenaBase(String id, String descripcion, String fondo) {
        this.id = id;
        this.descripcion = descripcion;
        this.fondo = fondo;
    }

    public EscenaBase(String id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
    }

    @Override
    public String getId() {
        return id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getSiguienteEscena() {
        return siguienteEscena;
    }

    public void setSiguienteEscena(String siguienteEscena) {
        this.siguienteEscena = siguienteEscena;
    }

    public String getFondo() {
        return fondo;
    }
}

