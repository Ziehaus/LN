/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;


public class Personaje {

    // =====================
    // Atributos
    // =====================
    private String nombre;
    private String descripcion;
    private String expresionActual;
    private String rutaImagen;  // Imagen o sprite actual del personaje

    // =====================
    // Constructor
    // =====================
    public Personaje(String nombre, String descripcion, String rutaImagen) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.rutaImagen = rutaImagen;
        this.expresionActual = "neutral"; // valor por defecto
    }

    // =====================
    // Métodos públicos
    // =====================

    /**
     * Cambia la expresión actual del personaje (feliz, triste, molesto, etc.)
     */
    public void cambiarExpresion(String nuevaExpresion) {
        this.expresionActual = nuevaExpresion;
        // Aquí luego podrías añadir lógica para cambiar sprite o audio asociado
    }

    /**
     * Retorna una representación de diálogo del personaje
     */
    public String hablar(String texto) {
        return nombre + ": " + texto;
    }

    // =====================
    // Getters y Setters
    // =====================

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getExpresionActual() {
        return expresionActual;
    }

    public void setExpresionActual(String expresionActual) {
        this.expresionActual = expresionActual;
    }

    public String getRutaImagen() {
        return rutaImagen;
    }

    public void setRutaImagen(String rutaImagen) {
        this.rutaImagen = rutaImagen;
    }
}
