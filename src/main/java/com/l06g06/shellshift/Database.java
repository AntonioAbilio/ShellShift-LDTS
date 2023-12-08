package com.l06g06.shellshift;

import com.l06g06.shellshift.model.game.gun.FireStrategy;
import com.l06g06.shellshift.model.game.gun.NormalFireStrategy;

public class Database {
    private static Database instance;

    private FireStrategy firingStrategy;
    private int numLives;
    private double damageMultiplier;

    private Database() {
        this.firingStrategy = new NormalFireStrategy();
        this.numLives = 3;
        this.damageMultiplier = 1.0;
    }

    public static Database getInstance() {
        if (instance == null) {
            instance = new Database();
        }
        return instance;
    }

    public FireStrategy getFiringStrategy() {
        return firingStrategy;
    }

    public void setFiringStrategy(FireStrategy firingStrategy) {
        this.firingStrategy = firingStrategy;
    }

    public int getNumLives() {
        return numLives;
    }

    public void setNumLives(int numLives) {
        this.numLives = numLives;
    }

    public double getDamageMultiplier() {
        return damageMultiplier;
    }

    public void setDamageMultiplier(double damageMultiplier) {
        this.damageMultiplier = damageMultiplier;
    }
}
