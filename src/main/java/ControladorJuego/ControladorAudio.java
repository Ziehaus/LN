
package ControladorJuego;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class ControladorAudio {

    private static ControladorAudio instancia;

    private Clip musicaActual;
    private FloatControl controlVolumenMusica;

    private float volumenMusica = -10.0f; // dB
    private float volumenSFX = -5.0f;     // dB

    // ================================
    // SINGLETON
    // ================================
    public static ControladorAudio getInstancia() {
        if (instancia == null) {
            instancia = new ControladorAudio();
        }
        return instancia;
    }

    // ================================
    // REPRODUCIR MUSICA (LOOP)
    // ================================
    public void reproducirMusica(String ruta) {
        detenerMusica(); // no solapar
        try {
            AudioInputStream audio = AudioSystem.getAudioInputStream(new File(ruta));
            musicaActual = AudioSystem.getClip();
            musicaActual.open(audio);

            controlVolumenMusica = (FloatControl) musicaActual.getControl(FloatControl.Type.MASTER_GAIN);
            controlVolumenMusica.setValue(volumenMusica); // aplicar volumen

            musicaActual.loop(Clip.LOOP_CONTINUOUSLY);
            musicaActual.start();

        } catch (Exception e) {
            System.err.println("Error al cargar música: " + e.getMessage());
        }
    }

    // ================================
    // FADE IN
    // ================================
    public void fadeIn(String ruta, int ms) {
        reproducirMusica(ruta);
        new Thread(() -> {
            try {
                for (float v = -40; v < volumenMusica; v += 1) {
                    controlVolumenMusica.setValue(v);
                    Thread.sleep(ms / 40);
                }
            } catch (Exception ignored) {}
        }).start();
    }

    // ================================
    // FADE OUT
    // ================================
    public void fadeOut(int ms) {
        if (musicaActual == null) return;

        new Thread(() -> {
            try {
                for (float v = volumenMusica; v > -40; v -= 1) {
                    controlVolumenMusica.setValue(v);
                    Thread.sleep(ms / 40);
                }
                detenerMusica();
            } catch (Exception ignored) {}
        }).start();
    }

    // ================================
    // DETENER MUSICA
    // ================================
    public void detenerMusica() {
        if (musicaActual != null && musicaActual.isRunning()) {
            musicaActual.stop();
            musicaActual.close();
        }
    }

    // ================================
    // EFECTO DE SONIDO (SFX)
    // ================================
    public void reproducirSFX(String ruta) {
        new Thread(() -> {
            try {
                AudioInputStream audio = AudioSystem.getAudioInputStream(new File(ruta));
                Clip clip = AudioSystem.getClip();
                clip.open(audio);

                FloatControl control = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
                control.setValue(volumenSFX);

                clip.start();
            } catch (Exception e) {
                System.err.println("Error SFX: " + e.getMessage());
            }
        }).start();
    }

    // ================================
    // SETTERS DE VOLUMEN
    // ================================
    public void setVolumenMusica(float volumenDb) {
        this.volumenMusica = volumenDb;
        if (controlVolumenMusica != null) {
            controlVolumenMusica.setValue(volumenDb);
        }
    }

    public void setVolumenSFX(float volumenDb) {
        this.volumenSFX = volumenDb;
    }
}

