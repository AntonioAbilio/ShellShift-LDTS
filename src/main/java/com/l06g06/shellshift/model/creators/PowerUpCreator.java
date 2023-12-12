package com.l06g06.shellshift.model.creators;

import com.l06g06.shellshift.model.game.elements.Element;
import com.l06g06.shellshift.model.game.elements.Platform;
import com.l06g06.shellshift.model.game.elements.Position;
import com.l06g06.shellshift.model.game.elements.powerups.BulletPowerUp;
import com.l06g06.shellshift.model.game.elements.powerups.PowerUp;
import com.l06g06.shellshift.model.game.elements.powerups.SpeedPowerUp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class PowerUpCreator extends Creator {
    private static Map<Integer, PowerUp> availablePowerUps;

    public PowerUpCreator() {
        availablePowerUps = new HashMap<>();
        Position pos = new Position(0,0);
        availablePowerUps.put(0, new BulletPowerUp(pos));
        availablePowerUps.put(1, new SpeedPowerUp(pos));
    }
    @Override
    public Element create(Position position) {
        Random random = new Random();
        PowerUp powerUp = availablePowerUps.get(random.nextInt(availablePowerUps.size()));
        if (powerUp instanceof SpeedPowerUp) {
            return new SpeedPowerUp(position);
        }
        if (powerUp instanceof BulletPowerUp) {
            return new BulletPowerUp(position);
        }
        else return new SpeedPowerUp(position);

    }
}
