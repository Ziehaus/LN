
package principal;
import java.util.Map;
public class Main {
    public static void main(String[] args) {

        Map<String, Modelo.IEscena> escenas = Modelo.CargadorEscenas.cargar();

        Modelo.Juego juego = new Modelo.Juego(escenas, "escena_inicio");

        new Vista.VentanaPrincipal(juego);
    }
}

