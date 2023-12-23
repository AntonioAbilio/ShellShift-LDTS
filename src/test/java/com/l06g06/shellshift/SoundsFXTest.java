package com.l06g06.shellshift;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SoundsFXTest {

    @Test
    public void setUp(){
        Database.getInstance().setSound(true);
        Assertions.assertEquals(7, SoundsFx.values().length);
        Assertions.assertEquals("sounds/coin.wav",SoundsFx.Coin.getPath());
        Assertions.assertEquals("sounds/powerup.wav",SoundsFx.PowerUP.getPath());
        Assertions.assertEquals("sounds/death.wav",SoundsFx.Death.getPath());
        Assertions.assertEquals("sounds/hurt.wav",SoundsFx.MonsterCollision.getPath());
        Assertions.assertEquals("sounds/jump.wav",SoundsFx.Jump.getPath());
        Assertions.assertEquals("sounds/fire.wav",SoundsFx.BulletFired.getPath());
        Assertions.assertEquals("sounds/select.wav",SoundsFx.OptionSelect.getPath());

    }
}
