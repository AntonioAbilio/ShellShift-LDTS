package com.l06g06.shellshift.model.game.map;

import com.l06g06.shellshift.model.creators.PowerUpCreator;
import com.l06g06.shellshift.model.game.elements.Position;
import com.l06g06.shellshift.model.game.elements.powerups.PowerUp;

import java.util.List;

public class PowerUpSpawner {
    private PowerUpCreator powerUpCreator;
    private List<PowerUp> powerUps;

    public PowerUpSpawner(List<PowerUp> powerUps){
        this.powerUps = powerUps;
        this.powerUpCreator = new PowerUpCreator();
    }

    public void spawn(Position position){
        PowerUp powerUpSpawned = (PowerUp) powerUpCreator.create(position);
        powerUps.add(powerUpSpawned);
        powerUps.removeIf(powerUp -> powerUp.getPosition().getX() <= -20);
    }
}
