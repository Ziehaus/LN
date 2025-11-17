package Modelo;

public abstract class EscenaBase implements IEscena {

    protected String id;
    protected String descripcion;
    protected String siguienteEscena; // útil para escenas lineales

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
}

