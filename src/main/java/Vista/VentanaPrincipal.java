package Vista;

import ControladorJuego.ControladorJuego;
import Modelo.Juego;

import javax.swing.*;

public class VentanaPrincipal extends JFrame {

    public VentanaPrincipal(Juego juego) {

        // --- PANEL DONDE SE DIBUJA LA ESCENA ---
        PanelEscena panelEscena = new PanelEscena();

        // --- CONTROLADOR ---
        ControladorJuego controlador = new ControladorJuego(juego, panelEscena);

        // --- CONFIGURACIÓN DE LA VENTANA ---
        setTitle("Visual Novel");
        setSize(1280, 720);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        add(panelEscena);

        setVisible(true);

        // --- INICIAR JUEGO ---
        controlador.iniciar();

        // --- CLICK PARA AVANZAR DIÁLOGO ---
        panelEscena.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                controlador.avanzarDialogo();
            }
        });
    }
}
//....




