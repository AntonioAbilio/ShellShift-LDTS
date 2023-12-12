package com.l06g06.shellshift;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
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
    /*
        try{
            System.out.println(soundsFx.getPath());

            // create AudioInputStream object
            URL resource = Sound.class.getClassLoader().getResource(soundsFx.getPath());
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(resource.getPath()).getAbsoluteFile());

            // create clip reference
            Clip clip = AudioSystem.getClip();

            // open audioInputStream to the clip
            clip.open(audioInputStream);

            clip.loop(0);
            //clip.start();

        }
        catch (UnsupportedAudioFileException | IOException | LineUnavailableException | NullPointerException uafe){
            System.out.println(uafe.getMessage());
        }

    */

    }
}
