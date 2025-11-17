package Vista;

import ControladorJuego.ControladorJuego;
import Modelo.EscenaDecision;
import Modelo.IEscena;

import javax.swing.*;
import java.awt.*;

public class VentanaPrincipal extends JFrame {

    private final ControladorJuego controlador;
    private final PanelEscena panel;

    private JButton btnContinuar;

    public VentanaPrincipal(ControladorJuego controlador) {
        this.controlador = controlador;

        setTitle("Visual Novel");
        setSize(900, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        panel = new PanelEscena();
        add(panel, BorderLayout.CENTER);

        btnContinuar = new JButton("Continuar");
        add(btnContinuar, BorderLayout.SOUTH);

        // Acción del botón "Continuar"
        btnContinuar.addActionListener(e -> controlador.avanzarDialogo());
    }

    // Método llamado por el Controlador para actualizar la vista
    public void actualizar(IEscena escena) {

        if (escena instanceof EscenaDecision decision) {

            // Mostrar opciones
            panel.mostrarOpciones(decision.getDescripcion(),
                    decision.getOpciones().stream()
                            .map(o -> o.getTextoVisible())
                            .toList()
            );

            btnContinuar.setVisible(false);

            // Asignar listeners a cada botón
            for (int i = 0; i < decision.getOpciones().size(); i++) {

                int indice = i;

                panel.getBotonOpcion(i).addActionListener(e -> {
                    controlador.seleccionarOpcion(indice);
                });
            }

        } else {
            // Mostrar diálogo
            controlador.mostrarEscenaActual(); // usa tu implementación
            btnContinuar.setVisible(true);
        }
    }

    public PanelEscena getPanel() {
        return panel;
    }
}
