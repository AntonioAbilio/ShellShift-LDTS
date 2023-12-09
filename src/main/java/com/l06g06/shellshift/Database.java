package com.l06g06.shellshift;

import com.l06g06.shellshift.model.game.gun.FireStrategy;
import com.l06g06.shellshift.model.game.gun.NormalFireStrategy;

import java.io.File;
import java.io.IOException;

public class Database {
    private static Database instance;

    private FireStrategy firingStrategy;
    private int numLives;
    private int damageMultiplier;
    private boolean tutorialCompleted;

    private Database() {
        this.firingStrategy = new NormalFireStrategy();
        this.numLives = 3;
        this.damageMultiplier = 1;
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

    public int getDamageMultiplier() {
        return damageMultiplier;
    }

    public void setDamageMultiplier(int damageMultiplier) {
        this.damageMultiplier = damageMultiplier;
    }
}
