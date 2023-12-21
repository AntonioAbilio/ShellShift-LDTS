package com.l06g06.shellshift.model.game.elements;

import com.l06g06.shellshift.Database;
import com.l06g06.shellshift.model.game.elements.powerups.*;
import com.l06g06.shellshift.model.game.gun.FireStrategy;
import com.l06g06.shellshift.model.game.gun.Gun;
import com.l06g06.shellshift.model.game.map.Map;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class PowerUpTest {

    @Test
    public void activateBulletPowerUpTest(){
        Position position = mock(Position.class);
        Map map = mock(Map.class);
        FireStrategy fireStrategy = mock(FireStrategy.class);
        Gun gun = new Gun(fireStrategy);
        when(map.getGun()).thenReturn(gun);

        BulletPowerUp bulletPowerUp = new BulletPowerUp(position);
        Assertions.assertEquals(Database.getInstance().getStartingNumBullets(), gun.getNumBullets());
        bulletPowerUp.activate(map);
        Assertions.assertEquals(Database.getInstance().getStartingNumBullets() + 20, gun.getNumBullets());
    }

    @Test
    public void activateSpeedPowerUpTest() {
        Map map = mock(Map.class);
        Chell chell = mock(Chell.class);
        when(map.getChell()).thenReturn(chell);
        ActivePowerUp activePowerUp = mock(ActivePowerUp.class);
        when(map.getActivePowerUp()).thenReturn(activePowerUp);

        Position position = mock(Position.class);
        SpeedPowerUp speedPowerUp = new SpeedPowerUp(position);
        speedPowerUp.activate(map);
        verify(map.getChell(), times(1)).setHorizontalSpeedWithTimer(2);
    }

    @Test
    public void activateStarPowerUpTest() {
        Map map = mock(Map.class);
        FireStrategy fireStrategy = mock(FireStrategy.class);
        Gun gun = new Gun(fireStrategy);
        when(map.getGun()).thenReturn(gun);
        Chell chell = mock(Chell.class);
        when(map.getChell()).thenReturn(chell);
        ActivePowerUp activePowerUp = new ActivePowerUp();
        when(map.getActivePowerUp()).thenReturn(activePowerUp);

        Assertions.assertEquals(Database.getInstance().getStartingNumBullets(), gun.getNumBullets());

        Position position = mock(Position.class);
        StarPowerUp starPowerUp = new StarPowerUp(position);
        starPowerUp.activate(map);
        verify(map.getChell(), times(1)).setInvincibilityEndTime(10000);
        verify(map.getChell(), times(1)).setHorizontalSpeedWithTimer(2);
        Assertions.assertEquals(Database.getInstance().getStartingNumBullets() + 50, gun.getNumBullets());
    }

    @Test
    public void hitboxTest(){
        PowerUp powerUp = new BulletPowerUp(new Position(0, 0));
        powerUp.setPosition(new Position(0, 0));
        Assertions.assertEquals(1, powerUp.getPolygon().xpoints[0]);
        Assertions.assertEquals(11, powerUp.getPolygon().xpoints[1]);
        Assertions.assertEquals(1, powerUp.getPolygon().xpoints[2]);
        Assertions.assertEquals(11, powerUp.getPolygon().xpoints[3]);

        Assertions.assertEquals(1, powerUp.getPolygon().ypoints[0]);
        Assertions.assertEquals(1, powerUp.getPolygon().ypoints[1]);
        Assertions.assertEquals(11, powerUp.getPolygon().ypoints[2]);
        Assertions.assertEquals(11, powerUp.getPolygon().ypoints[3]);
    }


}
