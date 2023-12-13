package com.l06g06.shellshift;

import com.l06g06.shellshift.model.optionsMenu.OptionsMenu;

import javax.sound.sampled.*;
import java.io.File;
import java.net.URL;

public class Sound {
    public enum SoundsFx{
        Coin("sounds/coin.wav"),
        PowerUP("sounds/powerup.wav"),
        Death("sounds/death.wav"),
        MonsterCollision("sounds/hurt.wav"),
        Jump("sounds/jump.wav"),
        BulletFired("sounds/fire.wav"),
        OptionSelect("sounds/select.wav");

        private final String path;

        SoundsFx(String path) {
            this.path = path;
        }

        public String getPath() {
            return path;
        }
    }

    public static void playSound(SoundsFx soundsFx){
        if (!OptionsMenu.soundOFF) {
            try {
                // create AudioInputStream object
                URL resource = Sound.class.getClassLoader().getResource(soundsFx.getPath());
                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(resource.getPath()).getAbsoluteFile());

                // create clip reference
                Clip clip = AudioSystem.getClip();

                // open audioInputStream to the clip
                clip.open(audioInputStream);

                // change clip volume
                //FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
                //gainControl.setValue(-20.0f);

                clip.loop(0);
            } catch (Exception uafe) {
                System.out.println(uafe.getMessage());
            }
        }


    }
}
