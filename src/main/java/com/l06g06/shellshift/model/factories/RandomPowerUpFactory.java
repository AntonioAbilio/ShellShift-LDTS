package com.l06g06.shellshift.model.factories;

import com.l06g06.shellshift.model.game.elements.Position;
import com.l06g06.shellshift.model.game.elements.powerups.PowerUp;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomPowerUpFactory {
    private final Random random = new Random();
    private List<PowerUpFactory> availablePowerUpFactories;

    public RandomPowerUpFactory() {
        availablePowerUpFactories = new ArrayList<>();
        availablePowerUpFactories.add(new BulletPowerUpFactory());
        availablePowerUpFactories.add(new StarPowerUpFactory());
        availablePowerUpFactories.add(new SpeedPowerUpFactory());
    }

    public PowerUp create(Position position) {
        return (PowerUp) this.availablePowerUpFactories.get(random.nextInt(this.availablePowerUpFactories.size())).create(position);
    }
}
