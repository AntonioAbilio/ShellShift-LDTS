package com.l06g06.shellshift;

import com.google.common.annotations.VisibleForTesting;
import com.l06g06.shellshift.model.optionsMenu.OptionsMenu;

import javax.sound.sampled.*;
import java.io.File;
import java.net.URL;

import static java.lang.Thread.sleep;


public class Sound implements LineListener, Runnable {

    private static final int SLEEP_DURATION = 2000;

    private Thread thread;

    private File soundFile;
    private Clip clip;
    private static Sound soundPlayer;

    private Sound() {
    }

    @VisibleForTesting
    public static void setInstance(Sound soundPlayer) {
        Sound.soundPlayer = soundPlayer;
    }

    public void playSound(SoundsFx soundsFx) {
        Sound p = getInstance();
        p.playSoundFx(soundsFx);
    }

    @VisibleForTesting
    public void playPrivateSoundFx(SoundsFx soundsFx) {
        playSoundFx(soundsFx);
    }

    @VisibleForTesting
    public Thread getThread() {
        return this.thread;
    }

    @VisibleForTesting
    public Clip getClip() {
        return this.clip;
    }

    @VisibleForTesting
    public void setClip(Clip clip) {
        this.clip = clip;
    }


    private void playSoundFx(SoundsFx soundsFx) {
        URL resource = Sound.class.getClassLoader().getResource(soundsFx.getPath());
        assert resource != null;
        this.soundFile = new File(resource.getPath());
        thread = new Thread(this);
        thread.setName("SoundPlayer");
        thread.start();
    }

    @Override
    public void update(LineEvent event) {
    }

    @Override
    public void run() {
        if (!OptionsMenu.soundOFF) {
            try {
                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(this.soundFile);
                AudioFormat format = audioInputStream.getFormat();

                if (format.getEncoding().equals(AudioFormat.Encoding.ULAW) || format.getEncoding().equals(AudioFormat.Encoding.ALAW)) {
                    AudioFormat tmp = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED, format.getSampleRate(), format.getSampleSizeInBits() * 2, format.getChannels(), format.getFrameSize() * 2, format.getFrameRate(), true);
                    audioInputStream = AudioSystem.getAudioInputStream(tmp, audioInputStream);
                    format = tmp;
                }

                DataLine.Info info = new DataLine.Info(Clip.class, audioInputStream.getFormat(), ((int) audioInputStream.getFrameLength() * format.getFrameSize()));

                clip = (Clip) AudioSystem.getLine(info);
                Clip clip = AudioSystem.getClip();
                clip.addLineListener(event -> {
                    if (LineEvent.Type.STOP.equals(event.getType())) {
                        clip.close();
                    }
                });

                clip.open(audioInputStream);
                FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
                gainControl.setValue(OptionsMenu.getSoundSliderValue());
                clip.start();
                try {
                    sleep(SLEEP_DURATION);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }

                while (clip.isActive() && thread != null) {
                    try {
                        sleep(SLEEP_DURATION);
                    } catch (Exception e) {
                        break;
                    }
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.println("Audio Format: " + clip.getFormat().toString());
            }
        }
    }

    public static Sound getInstance() {
        if (soundPlayer == null) {
            soundPlayer = new Sound();
        }
        return soundPlayer;
    }

    public void stopClip() {
        clip.stop();
    }

    public void closeClip() {
        clip.close();
    }

    public void startClip() {
        clip.start();
    }
}
