package com.l06g06.shellshift.model.creators;

import com.l06g06.shellshift.model.game.elements.Element;
import com.l06g06.shellshift.model.game.elements.Position;
import com.l06g06.shellshift.model.game.elements.powerups.BulletPowerUp;
import com.l06g06.shellshift.model.game.elements.powerups.PowerUp;
import com.l06g06.shellshift.model.game.elements.powerups.SpeedPowerUp;
import com.l06g06.shellshift.model.game.elements.powerups.StarPowerUp;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class PowerUpCreator extends Creator {
    private final Map<Integer, PowerUp> availablePowerUps;

    public PowerUpCreator() {
        availablePowerUps = new HashMap<>();
        Position pos = new Position(0,0);
        availablePowerUps.put(0, new BulletPowerUp(pos));
        availablePowerUps.put(1, new SpeedPowerUp(pos));
        availablePowerUps.put(2, new StarPowerUp(pos));
    }
    @Override
    public Element create(Position position) {
        Random random = new Random();
        PowerUp powerUp = availablePowerUps.get(random.nextInt(availablePowerUps.size()));
        if (powerUp instanceof SpeedPowerUp) {
            return new StarPowerUp(position);
        }
        if (powerUp instanceof BulletPowerUp) {
            return new StarPowerUp(position);
        }
        if (powerUp instanceof StarPowerUp) {
            return new StarPowerUp(position);
        }
        else return new BulletPowerUp(position);

    }
}
