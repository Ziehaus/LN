package Vista;

import Modelo.*;
import Utils.AudioManager;

import javax.swing.*;
import java.awt.*;

/**
 * VentanaInicio que recibe el juego ya creado en main.
 * Al pulsar "Iniciar" abre VentanaPrincipal pasándole el mismo juego.
 */
public class VentanaInicio extends JFrame {

    private final Juego juego;

    public VentanaInicio(Juego juego) {
        this.juego = juego;
        initUI();
    }

    private void initUI() {
        setTitle("Visual Novel - Inicio");
        setSize(900, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        // Panel con imagen de fondo (usa /img/fondos/menu.jpg si existe)
        JPanel panelFondo = new JPanel() {
            private Image fondo = null;
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                if (fondo == null) {
                    try {
                        fondo = new ImageIcon(getClass().getResource("/img/fondos/menu.jpg")).getImage();
                    } catch (Exception ignored) {}
                }
                if (fondo != null) g.drawImage(fondo, 0, 0, getWidth(), getHeight(), this);
            }
        };
        panelFondo.setLayout(null); // colocación absoluta simple
        setContentPane(panelFondo);

        // TÍTULO o LOGO
        JLabel titulo = new JLabel("Visual Novel", SwingConstants.CENTER);
        titulo.setFont(new Font("Georgia", Font.BOLD, 36));
        titulo.setForeground(Color.WHITE);
        titulo.setBounds(0, 40, getWidth(), 50);
        panelFondo.add(titulo);

        // BOTÓN INICIAR
        JButton btnIniciar = new JButton("Iniciar");
        btnIniciar.setFont(new Font("Georgia", Font.BOLD, 22));
        btnIniciar.setBounds( (getWidth()/2) - 100, 350, 200, 50);
        panelFondo.add(btnIniciar);

        // BOTÓN SALIR
        JButton btnSalir = new JButton("Salir");
        btnSalir.setFont(new Font("Georgia", Font.BOLD, 18));
        btnSalir.setBounds((getWidth()/2) - 100, 420, 200, 40);
        panelFondo.add(btnSalir);

        // Evento INICIAR: abre VentanaPrincipal con el juego creado en main
        btnIniciar.addActionListener(e -> {
            // opcional: detener música de menú
            AudioManager.fadeOutMusica(); // Si usas AudioManager con ese método; si no, usar detenerMusica()
            // Abrir la ventana principal pasando el juego
            new VentanaPrincipal(juego).setVisible(true);
            dispose();
        });

        // Evento SALIR
        btnSalir.addActionListener(e -> {
            AudioManager.fadeOutMusica();
            System.exit(0);
        });

        // Reproducir música de menú (opcional)
        try {
            AudioManager.reproducirMusica("/audio/musica/menu.wav");
        } catch (Exception ignored) {}

        // Mostrar ventana
        // setVisible(true); // lo hace main con .setVisible(true)
    }
}
