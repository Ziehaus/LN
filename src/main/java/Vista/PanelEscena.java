package Vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;

public class PanelEscena extends JPanel {

    private JLabel lblNombre;
    private JLabel lblImagen;
    private JTextArea txtDialogo;
    private JScrollPane scrollDialogo;

    private JPanel panelDialogo;
    private JPanel panelOpciones;
    private JButton[] botonesOpciones;

    private JPanel contenedorSur;   // CardLayout para alternar diálogo/decisiones
    private ImageIcon fondoActual;  // Fondo unificado

public PanelEscena() {

    setLayout(new BorderLayout());

    // ============================================================
    // FONDO
    // ============================================================
    fondoActual = null;

    // ============================================================
    // PANEL DE DIÁLOGO
    // ============================================================
    panelDialogo = new JPanel(new BorderLayout());
    panelDialogo.setOpaque(false);

    // --- IMAGEN DEL PERSONAJE ---
    lblImagen = new JLabel();
    lblImagen.setHorizontalAlignment(SwingConstants.CENTER);
    panelDialogo.add(lblImagen, BorderLayout.CENTER);

    // --- PANEL INFERIOR PARA NOMBRE + TEXTO ---
    RoundedPanel panelTexto = new RoundedPanel(25, new Color(0, 0, 0, 180));
    panelTexto.setLayout(new BorderLayout());
    panelTexto.setBorder(BorderFactory.createEmptyBorder(10, 15, 10, 15));

    // NOMBRE (IZQUIERDA)
    lblNombre = new JLabel("");
    lblNombre.setFont(new Font("Georgia", Font.BOLD, 22));
    lblNombre.setForeground(Color.WHITE);
    lblNombre.setHorizontalAlignment(SwingConstants.LEFT);
    panelTexto.add(lblNombre, BorderLayout.NORTH);

    // TEXTO DEL DIÁLOGO
    txtDialogo = new JTextArea();
    txtDialogo.setEditable(false);
    txtDialogo.setLineWrap(true);
    txtDialogo.setWrapStyleWord(true);
    txtDialogo.setFont(new Font("Georgia", Font.PLAIN, 18));
    txtDialogo.setForeground(Color.WHITE);
    txtDialogo.setOpaque(false);

    // SCROLL PARA EL TEXTO
    scrollDialogo = new JScrollPane(txtDialogo);
    scrollDialogo.setOpaque(false);
    scrollDialogo.getViewport().setOpaque(false);
    scrollDialogo.setBorder(null);
    panelTexto.add(scrollDialogo, BorderLayout.CENTER);

    // Añadir el panel de texto al panel de diálogo
    panelDialogo.add(panelTexto, BorderLayout.SOUTH);

    // ============================================================
    // PANEL DE OPCIONES
    // ============================================================
    panelOpciones = new JPanel(new GridLayout(0, 1));
    panelOpciones.setOpaque(false);

    // ============================================================
    // CONTENEDOR SUR CON CARDLAYOUT
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

        // nombre + emoción
        lblNombre.setText(nombre + (emocion != null ? " [" + emocion + "]" : ""));

        // imagen del personaje
        if (rutaImagen != null && !rutaImagen.isEmpty()) {
            lblImagen.setIcon(new ImageIcon(getClass().getResource(rutaImagen)));
        } else {
            lblImagen.setIcon(null);
        }

        // texto del diálogo
        txtDialogo.setText(texto);

        // animación suave
        fadeInTexto();

        // mostrar panel correcto
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
    
        public void fadeInTexto() {
        txtDialogo.setForeground(new Color(255,255,255,0));
        Timer timer = new Timer(20, null);

        timer.addActionListener(e -> {
            Color c = txtDialogo.getForeground();
            int alpha = c.getAlpha() + 15;
            if (alpha >= 255) {
                alpha = 255;
                timer.stop();
            }
            txtDialogo.setForeground(new Color(255, 255, 255, alpha));
        });

        timer.start();
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
    
    class RoundedPanel extends JPanel {
        
    private int radius;
    private Color color;

    public RoundedPanel(int radius, Color bg) {
        this.radius = radius;
        this.color = bg;
        setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(color);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), radius, radius);
    }
}

}


