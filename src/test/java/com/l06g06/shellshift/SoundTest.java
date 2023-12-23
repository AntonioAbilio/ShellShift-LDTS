package com.l06g06.shellshift;

import com.l06g06.shellshift.model.optionsMenu.OptionsMenu;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.sound.sampled.Clip;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class SoundTest {

    private Sound sound;

    @BeforeEach
    void setUp() {
        Database.getInstance().setSound(true);
        Sound.setInstance(sound);
        sound = Sound.getInstance();
    }

    @Test
    void getInstance_ReturnsSingletonInstance() {
        Sound instance1 = Sound.getInstance();
        Sound instance2 = Sound.getInstance();
        assertSame(instance1, instance2);
    }

    @Test
    void run_DoNothingWhenSoundIsOff() {
        OptionsMenu.soundOFF = true;
        sound.setClip(null);
        sound.run();
        assertNull(sound.getClip());
    }

    @Test
    void stopClip_StopsTheClip() {
        Clip clip = mock(Clip.class);
        sound.setClip(clip);
        sound.stopClip();
        verify(clip).stop();
    }

    @Test
    void startClip_StartsTheClip() {
        Clip clip = mock(Clip.class);
        sound.setClip(clip);
        sound.startClip();
        verify(clip).start();
    }

    @Test
    void closeClip_ClosesTheClip() {
        Clip clip = mock(Clip.class);
        sound.setClip(clip);
        sound.closeClip();
        verify(clip).close();
    }
}
