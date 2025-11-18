package Utils;

import javax.sound.sampled.*;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;

public class AudioManager {

    private static Clip musicaActual;
    private static FloatControl controlVolumen;

    private static HashMap<String, Clip> efectos = new HashMap<>();

    private static float volumenInicial = -30f; // volumen al iniciar (fade-in)
    private static float volumenMaximo = 0f;    // volumen normal
    private static float volumenPaso = 2f;      // velocidad del fade

    // ============================================================
    // EFECTOS DE SONIDO (con caché)
    // ============================================================
    public static void reproducirEfecto(String ruta) {
        try {
            Clip clip;

            // Si ya está cargado → usarlo nuevamente
            if (efectos.containsKey(ruta)) {
                clip = efectos.get(ruta);
                if (!clip.isRunning()) {
                    clip.setFramePosition(0);
                    clip.start();
                }
                return;
            }

            // Cargar desde recurso
            URL url = AudioManager.class.getResource(ruta);
            if (url == null) {
                System.err.println("No se encontró el efecto: " + ruta);
                return;
            }

            AudioInputStream ais = AudioSystem.getAudioInputStream(url);
            clip = AudioSystem.getClip();
            clip.open(ais);

            efectos.put(ruta, clip);
            clip.start();

        } catch (Exception e) {
            System.out.println("Error al reproducir efecto: " + ruta);
            e.printStackTrace();
        }
    }

    // ============================================================
    // MÚSICA CON FADE-IN
    // ============================================================
    public static void reproducirMusica(String ruta) {

        // Si ya está sonando la misma música → no repetir
        if (musicaActual != null && musicaActual.isOpen()) {
            return;
        }

        fadeOutMusica();

        try {
            URL url = AudioManager.class.getResource(ruta);
            if (url == null) {
                System.err.println("No se encontró la música: " + ruta);
                return;
            }

            AudioInputStream ais = AudioSystem.getAudioInputStream(url);

            musicaActual = AudioSystem.getClip();
            musicaActual.open(ais);

            controlVolumen = (FloatControl) musicaActual.getControl(FloatControl.Type.MASTER_GAIN);
            controlVolumen.setValue(volumenInicial);

            musicaActual.loop(Clip.LOOP_CONTINUOUSLY);
            musicaActual.start();

            // Fade-in gradual
            new Thread(() -> {
                try {
                    for (float v = volumenInicial; v < volumenMaximo; v += volumenPaso) {
                        controlVolumen.setValue(v);
                        Thread.sleep(100);
                    }
                } catch (InterruptedException ignored) {}
            }).start();

        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println("Error al reproducir música: " + ruta);
            e.printStackTrace();
        }
    }

    // ============================================================
    // FADE OUT DE LA MÚSICA
    // ============================================================
    public static void fadeOutMusica() {
        if (musicaActual == null || !musicaActual.isOpen()) return;

        new Thread(() -> {
            try {
                FloatControl volume = (FloatControl) musicaActual.getControl(FloatControl.Type.MASTER_GAIN);

                for (float v = volumenMaximo; v > volumenInicial; v -= volumenPaso) {
                    volume.setValue(v);
                    Thread.sleep(80);
                }

                musicaActual.stop();
                musicaActual.close();
                musicaActual = null;

            } catch (Exception ignored) {}
        }).start();
    }

    // ============================================================
    // DETENER INMEDIATAMENTE LA MÚSICA
    // ============================================================
    public static void detenerMusica() {
        if (musicaActual != null) {
            musicaActual.stop();
            musicaActual.close();
            musicaActual = null;
        }
    }
}



