package Modelo;

public class Opcion {

    private final String textoVisible;
    private final String escenaDestinoId;
    private final Runnable accion; // opcional

    public Opcion(String textoVisible, String escenaDestinoId) {
        this(textoVisible, escenaDestinoId, null);
    }

    public Opcion(String textoVisible, String escenaDestinoId, Runnable accion) {

        if (textoVisible == null)
            throw new IllegalArgumentException("El texto visible no puede ser null.");

        if (escenaDestinoId == null)
            throw new IllegalArgumentException("El id de escena destino no puede ser null.");

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

    public Runnable getAccion() {
        return accion;
    }

    public void ejecutarAccion() {
        if (accion != null) accion.run();
    }
}



