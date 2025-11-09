/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

public class EscenaDesicion extends EscenaBase {
    
    private String[] opciones;

    public EscenaDesicion(String titulo, String dialogo, String fondo, String musicaFondo, String efectoSonido, String[] opciones) {
        super(titulo, dialogo, fondo, musicaFondo, efectoSonido);
        this.opciones = opciones;
    }

    public void mostrarOpciones() {
        for (int i = 0; i < opciones.length; i++) {
            System.out.println((i + 1) + ". " + opciones[i]);
        }
    }
}

