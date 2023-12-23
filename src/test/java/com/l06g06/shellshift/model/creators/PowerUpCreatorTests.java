package com.l06g06.shellshift.model.creators;

import com.l06g06.shellshift.Database;
import com.l06g06.shellshift.model.game.elements.Element;
import com.l06g06.shellshift.model.game.elements.Position;
import com.l06g06.shellshift.model.game.elements.powerups.BulletPowerUp;
import com.l06g06.shellshift.model.game.elements.powerups.PowerUp;
import com.l06g06.shellshift.model.game.elements.powerups.SpeedPowerUp;
import com.l06g06.shellshift.model.game.elements.powerups.StarPowerUp;
import net.jqwik.api.ForAll;
import net.jqwik.api.Property;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PowerUpCreatorTests {

    private PowerUpCreator powerUpCreator;

    @Property
    void testCreateMethod(@ForAll int x, @ForAll int y) {
        Database.getInstance().setSound(true);
        powerUpCreator = new PowerUpCreator();
        Element powerup = powerUpCreator.create(new Position(x, y));
        Assertions.assertNotNull(powerup);
        Assertions.assertTrue((powerup instanceof PowerUp));
        Assertions.assertEquals(x, powerup.getPosition().getX());
        Assertions.assertEquals(y, powerup.getPosition().getY());
    }

    @Test
    public void testForBullets(){
        powerUpCreator = new PowerUpCreator();
        powerUpCreator.setRandomSeed(1);
        Element powerup = powerUpCreator.create(new Position(1, 1));
        Assertions.assertNotNull(powerup);
        Assertions.assertTrue(powerup instanceof BulletPowerUp);
        Assertions.assertFalse(powerup instanceof SpeedPowerUp);
        Assertions.assertFalse(powerup instanceof StarPowerUp);
    }

    @Test
    public void testForSpeed(){
        powerUpCreator = new PowerUpCreator();
        powerUpCreator.setRandomSeed(1212);
        Element powerup = powerUpCreator.create(new Position(1, 1));
        Assertions.assertNotNull(powerup);
        Assertions.assertTrue(powerup instanceof SpeedPowerUp);
        Assertions.assertFalse(powerup instanceof BulletPowerUp);
        Assertions.assertFalse(powerup instanceof StarPowerUp);
    }

    @Test
    public void testForStar(){
        powerUpCreator = new PowerUpCreator();
        powerUpCreator.setRandomSeed(12122);
        Element powerup = powerUpCreator.create(new Position(1, 1));
        Assertions.assertNotNull(powerup);
        Assertions.assertFalse(powerup instanceof SpeedPowerUp);
        Assertions.assertFalse(powerup instanceof BulletPowerUp);
        Assertions.assertTrue(powerup instanceof StarPowerUp);
    }
}
