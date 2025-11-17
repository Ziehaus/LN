package Vista;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class PanelEscena extends JPanel {

    // COMPONENTES
    private JLabel lblNombre;
    private JLabel lblImagen;
    private JTextArea txtDialogo;

    private JPanel panelOpciones;
    private JButton[] botonesOpciones;

    public PanelEscena() {

        setLayout(new BorderLayout());

        // -------------------------
        // PANEL DE DIALOGO
        // -------------------------
        JPanel panelDialogo = new JPanel(new BorderLayout());

        lblNombre = new JLabel("", SwingConstants.LEFT);
        lblNombre.setFont(new Font("Arial", Font.BOLD, 20));

        lblImagen = new JLabel();
        lblImagen.setHorizontalAlignment(SwingConstants.CENTER);

        txtDialogo = new JTextArea();
        txtDialogo.setEditable(false);
        txtDialogo.setLineWrap(true);
        txtDialogo.setWrapStyleWord(true);
        txtDialogo.setFont(new Font("Arial", Font.PLAIN, 18));

        panelDialogo.add(lblNombre, BorderLayout.NORTH);
        panelDialogo.add(lblImagen, BorderLayout.CENTER);
        panelDialogo.add(new JScrollPane(txtDialogo), BorderLayout.SOUTH);

        // -------------------------
        // PANEL DE OPCIONES
        // -------------------------
        panelOpciones = new JPanel();
        panelOpciones.setLayout(new GridLayout(0, 1));
        panelOpciones.setVisible(false);

        add(panelDialogo, BorderLayout.CENTER);
        add(panelOpciones, BorderLayout.SOUTH);
    }

    // ============================================================
    // MÉTODO PARA MOSTRAR UN DIÁLOGO
    // ============================================================
    public void mostrarDialogo(String nombre, String rutaImagen, String texto, String emocion) {

        lblNombre.setText(nombre + " [" + emocion + "]");

        // Imagen del personaje
        if (rutaImagen != null && !rutaImagen.isEmpty()) {
            ImageIcon icon = new ImageIcon(rutaImagen);
            lblImagen.setIcon(icon);
        } else {
            lblImagen.setIcon(null);
        }

        txtDialogo.setText(texto);

        // Ocultar opciones si estaban visibles
        panelOpciones.setVisible(false);
    }

    // ============================================================
    // MÉTODO PARA MOSTRAR OPCIONES DE DECISIÓN
    // ============================================================
    public void mostrarOpciones(String descripcion, List<String> opciones) {

        panelOpciones.removeAll(); // limpiar opciones anteriores

        JLabel texto = new JLabel(descripcion);
        texto.setFont(new Font("Arial", Font.BOLD, 18));
        panelOpciones.add(texto);

        botonesOpciones = new JButton[opciones.size()];

        for (int i = 0; i < opciones.size(); i++) {
            botonesOpciones[i] = new JButton(opciones.get(i));
            panelOpciones.add(botonesOpciones[i]);
        }

        panelOpciones.setVisible(true);

        revalidate();
        repaint();
    }

    // Para que VentanaPrincipal pueda asignar los listeners de opciones
    public JButton getBotonOpcion(int i) {
        return botonesOpciones[i];
    }
}

