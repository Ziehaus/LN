package Modelo;

public class Opcion {

    private String textoVisible;
    private String escenaDestinoId;
    private Runnable accion; // opcional

    public Opcion(String textoVisible, String escenaDestinoId) {
        this(textoVisible, escenaDestinoId, null);
    }

    public Opcion(String textoVisible, String escenaDestinoId, Runnable accion) {
        this.textoVisible = textoVisible;
        this.escenaDestinoId = escenaDestinoId;
        this.accion = accion;
    }

    public String getTextoVisible() {
        return textoVisible;
    }

    public String getEscenaDestinoId() {
        return escenaDestinoId;
    }

    public void ejecutarAccion() {
        if (accion != null) accion.run();
    }
}


