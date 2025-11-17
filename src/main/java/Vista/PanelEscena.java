/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista;

import ControladorJuego.*;
import javax.swing.*;
import java.awt.*;


public class PanelEscena extends JPanel {
private ControladorJuego controlador;


public PanelEscena(ControladorJuego controlador) {
this.controlador = controlador;
setLayout(null);
setBackground(Color.BLACK);
}


@Override
protected void paintComponent(Graphics g) {
super.paintComponent(g);
if (controlador != null && controlador.getEscenaActual() != null) {
controlador.getEscenaActual().dibujar(g, this);
}
}


public void actualizar() {
repaint();
}
}
