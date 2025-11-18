
package Vista;
import javax.swing.*;
import java.awt.*;


class FondoPanel extends JPanel {

    private Image fondo;

    public FondoPanel(String ruta) {
        fondo = new ImageIcon(getClass().getResource(ruta)).getImage();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(fondo, 0, 0, getWidth(), getHeight(), this);
    }
}
