package com.l06g06.shellshift.model.game.gun;

import com.l06g06.shellshift.Database;
import net.jqwik.api.ForAll;
import net.jqwik.api.Property;
import net.jqwik.api.constraints.Positive;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;

public class GunTest {

    private Gun gun;

    @BeforeEach
    void setup(){
        Database.getInstance().setSound(true);
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

        RapidFireStrategy rapidFireStrategy = new RapidFireStrategy();
        gun = new Gun(rapidFireStrategy);
        Assertions.assertEquals(300, rapidFireStrategy.getReloadTime());
    }

    @Property
    public void getReloadTimeTestFromGun(@ForAll @Positive int bullets){
        Database.getInstance().setSound(true);
        NormalFireStrategy normalFireStrategy = new NormalFireStrategy();
        gun = new Gun(normalFireStrategy,bullets);
        Assertions.assertEquals(1000, gun.getReloadTime());
        Assertions.assertEquals(bullets, gun.getNumBullets());

        RapidFireStrategy rapidFireStrategy = new RapidFireStrategy();
        gun = new Gun(rapidFireStrategy,bullets);
        Assertions.assertEquals(300, gun.getReloadTime());
        Assertions.assertEquals(bullets, gun.getNumBullets());
    }

}
