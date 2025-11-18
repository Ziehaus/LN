
package Vista;



import javax.swing.*;
import java.net.URL;

public class ImageLoader {

    public static ImageIcon cargar(String ruta) {
        URL url = ImageLoader.class.getClassLoader().getResource(ruta);

        if (url == null) {
            System.err.println("Error: No se encontró la imagen -> " + ruta);
            return null;
        }

        return new ImageIcon(url);
    }
}
