package Modelo;

public class Personaje {

    private String nombre;
    private String rol;
    private String rutaImagen;

    public Personaje(String nombre, String rol, String rutaImagen) {
        this.nombre = nombre;
        this.rol = rol;
        this.rutaImagen = rutaImagen;
    }

    public String getNombre() {
        return nombre;
    }

    public String getRol() {
        return rol;
    }

    public String getRutaImagen() {
        return rutaImagen;
    }
}
