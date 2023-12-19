package com.l06g06.shellshift.model.game.gun;

import com.l06g06.shellshift.Database;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;

public class GunTest {

    private Gun gun;

    @BeforeEach
    void setup(){
        FireStrategy fireStrategy = mock(FireStrategy.class);
        this.gun = new Gun(fireStrategy);
    }

    @Test
    public void decreaseNumBulletTest(){
        Assertions.assertEquals(Database.getInstance().getStartingNumBullets(), gun.getNumBullets());
        gun.decreaseNumBullet();
        Assertions.assertEquals(Database.getInstance().getStartingNumBullets() - 1, gun.getNumBullets());
    }

    @Test
    public void getReloadTimeTest(){
        NormalFireStrategy normalFireStrategy = new NormalFireStrategy();
        gun = new Gun(normalFireStrategy);
        Assertions.assertEquals(1000, normalFireStrategy.getReloadTime());
    }

}
