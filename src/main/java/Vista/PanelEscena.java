package Vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;

public class PanelEscena extends JPanel {

    private JLabel lblNombre;
    private JLabel lblImagen;
    private JTextArea txtDialogo;

    private JPanel panelDialogo;
    private JPanel panelOpciones;
    private JButton[] botonesOpciones;

    private JPanel contenedorSur;   // CardLayout para alternar diálogo/decisiones
    private ImageIcon fondoActual;  // Fondo unificado

    public PanelEscena() {

        setLayout(new BorderLayout());

        // ============================================================
        // FONDO (se dibuja desde paintComponent)
        // ============================================================
        fondoActual = null;

        // ============================================================
        // PANEL DE DIÁLOGO
        // ============================================================
        panelDialogo = new JPanel(new BorderLayout());
        panelDialogo.setOpaque(false);

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

        // ============================================================
        // PANEL DE OPCIONES
        // ============================================================
        panelOpciones = new JPanel(new GridLayout(0, 1));
        panelOpciones.setOpaque(false);

        // ============================================================
        // PANEL SUR CON CARDLAYOUT
        // ============================================================
        contenedorSur = new JPanel(new CardLayout());
        contenedorSur.setOpaque(false);

        contenedorSur.add(panelDialogo, "DIALOGO");
        contenedorSur.add(panelOpciones, "OPCIONES");

        add(contenedorSur, BorderLayout.SOUTH);
    }

    // ============================================================
    // FONDO
    // ============================================================
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (fondoActual != null) {
            g.drawImage(fondoActual.getImage(), 0, 0, getWidth(), getHeight(), this);
        }
    }

    public void mostrarFondo(String rutaFondo) {
        if (rutaFondo != null && !rutaFondo.isEmpty()) {
            fondoActual = new ImageIcon(getClass().getResource(rutaFondo));
        } else {
            fondoActual = null;
        }
        repaint();
    }

    // ============================================================
    // DIALOGO
    // ============================================================
    public void mostrarDialogo(String nombre, String rutaImagen, String texto, String emocion) {

        lblNombre.setText(nombre + (emocion != null ? " [" + emocion + "]" : ""));

        if (rutaImagen != null && !rutaImagen.isEmpty()) {
            lblImagen.setIcon(new ImageIcon(getClass().getResource(rutaImagen)));
        } else {
            lblImagen.setIcon(null);
        }

        txtDialogo.setText(texto);

        mostrarPanel("DIALOGO");
    }

    // ============================================================
    // OPCIONES
    // ============================================================
    public void mostrarOpciones(String descripcion, List<String> opciones) {

        panelOpciones.removeAll();

        JLabel texto = new JLabel(descripcion, SwingConstants.CENTER);
        texto.setFont(new Font("Arial", Font.BOLD, 18));
        panelOpciones.add(texto);

        botonesOpciones = new JButton[opciones.size()];

        for (int i = 0; i < opciones.size(); i++) {
            botonesOpciones[i] = new JButton(opciones.get(i));
            panelOpciones.add(botonesOpciones[i]);
        }

        mostrarPanel("OPCIONES");
        revalidate();
        repaint();
    }

    // ============================================================
    // UTILIDAD MVC PARA CONTROLADOR
    // ============================================================
    public void setActionListenerOpcion(int index, ActionListener listener) {
        if (botonesOpciones != null && index >= 0 && index < botonesOpciones.length) {
            botonesOpciones[index].addActionListener(listener);
        }
    }

    public JButton getBotonOpcion(int i) {
        return botonesOpciones[i];
    }

    private void mostrarPanel(String nombre) {
        CardLayout cl = (CardLayout) contenedorSur.getLayout();
        cl.show(contenedorSur, nombre);
    }
}


