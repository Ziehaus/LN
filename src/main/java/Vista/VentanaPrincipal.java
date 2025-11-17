
package Vista;

import ControladorJuego.*;
import javax.swing.*;
import java.awt.*;


public class VentanaPrincipal extends JFrame {
        private PanelEscena panelEscena;
        private ControladorJuego controlador;


    public VentanaPrincipal(ControladorJuego controlador) {
    this.controlador = controlador;
    setTitle("Visual Novel");
    setSize(900, 600);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLayout(new BorderLayout());


    panelEscena = new PanelEscena(controlador);
    add(panelEscena, BorderLayout.CENTER);


    setVisible(true);
    }


    public void actualizar() {
    panelEscena.actualizar();
    }
    }
