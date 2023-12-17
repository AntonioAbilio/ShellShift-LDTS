package com.l06g06.shellshift.model.creators;

import com.l06g06.shellshift.model.game.elements.Element;
import com.l06g06.shellshift.model.game.elements.Position;
import com.l06g06.shellshift.model.game.elements.powerups.PowerUp;
import net.jqwik.api.ForAll;
import net.jqwik.api.Property;
import org.junit.jupiter.api.Assertions;

public class PowerUpCreatorTests {

    private PowerUpCreator powerUpCreator;

    @Property
    void testCreateMethod(@ForAll int x, @ForAll int y) {
        powerUpCreator = new PowerUpCreator();
        Element powerup = powerUpCreator.create(new Position(x, y));
        Assertions.assertNotNull(powerup);
        Assertions.assertTrue((powerup instanceof PowerUp));
        Assertions.assertEquals(x, powerup.getPosition().getX());
        Assertions.assertEquals(y, powerup.getPosition().getY());
    }

}
