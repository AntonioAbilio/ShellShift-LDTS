package com.l06g06.shellshift.model.game.spawners;

import com.l06g06.shellshift.model.creators.*;
/*
import com.l06g06.shellshift.model.factories.RandomPowerUpFactory;
*/
import com.l06g06.shellshift.model.game.elements.Position;
import com.l06g06.shellshift.model.game.elements.powerups.PowerUp;

import java.util.List;

public class PowerUpSpawner {
    private PowerUpCreator powerUpCreator;
/*
    private RandomPowerUpFactory randomPowerUpFactory;
*/
    private List<PowerUp> powerUps;

    public PowerUpSpawner(List<PowerUp> powerUps){
        this.powerUps = powerUps;
        this.powerUpCreator = new PowerUpCreator();
/*
        this.randomPowerUpFactory = new RandomPowerUpFactory();
*/
    }

    public void spawn(Position position){
        PowerUp powerUpSpawned = (PowerUp) powerUpCreator.create(position);
/*
        PowerUp powerUpSpawned = randomPowerUpFactory.create(position);
*/
        powerUps.add(powerUpSpawned);
        powerUps.removeIf(powerUp -> powerUp.getPosition().getX() <= -20);

    }
}
