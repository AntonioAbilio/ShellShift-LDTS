package com.l06g06.shellshift.model.creators;

import com.google.common.annotations.VisibleForTesting;
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
    private Random random;
    private final Map<Integer, PowerUp> availablePowerUps;

    public PowerUpCreator() {
        availablePowerUps = new HashMap<>();
        Position pos = new Position(0,0);
        availablePowerUps.put(0, new BulletPowerUp(pos));
        availablePowerUps.put(1, new SpeedPowerUp(pos));
        availablePowerUps.put(2, new StarPowerUp(pos));
        random = new Random();
    }

    @VisibleForTesting
    public void setRandomSeed(int seed){
        random = new Random(seed);
    }

    @Override
    public Element create(Position position) {
        PowerUp powerUp = availablePowerUps.get(random.nextInt(availablePowerUps.size()));
        if (powerUp instanceof SpeedPowerUp) {
            return new SpeedPowerUp(position);
        }
        if (powerUp instanceof StarPowerUp) {
            return new StarPowerUp(position);
        }
        return new BulletPowerUp(position);
    }
}
