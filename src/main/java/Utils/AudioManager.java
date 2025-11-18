
package Utils;

import javax.sound.sampled.*;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;

public class AudioManager {

    private static Clip musicaActual;
    private static HashMap<String, Clip> efectos = new HashMap<>();

    // ================================
    // MÚSICA DE FONDO
    // ================================
    public static void reproducirMusica(String ruta) {
        detenerMusica();

        try {
            URL url = AudioManager.class.getResource(ruta);
            if (url == null) {
                System.err.println("No se encontró la música: " + ruta);
                return;
            }

            AudioInputStream audio = AudioSystem.getAudioInputStream(url);
            musicaActual = AudioSystem.getClip();
            musicaActual.open(audio);
            musicaActual.loop(Clip.LOOP_CONTINUOUSLY);
            musicaActual.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void detenerMusica() {
        if (musicaActual != null && musicaActual.isRunning()) {
            musicaActual.stop();
            musicaActual.close();
        }
        musicaActual = null;
    }

    // ================================
    // EFECTOS DE SONIDO
    // ================================
    public static void reproducirEfecto(String ruta) {
        try {
            URL url = AudioManager.class.getResource(ruta);
            if (url == null) {
                System.err.println("No se encontró el efecto: " + ruta);
                return;
            }

            AudioInputStream audio = AudioSystem.getAudioInputStream(url);
            Clip clip = AudioSystem.getClip();
            clip.open(audio);
            clip.start();

            efectos.put(ruta, clip);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}//.....

