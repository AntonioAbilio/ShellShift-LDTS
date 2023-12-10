package com.l06g06.shellshift;

import com.l06g06.shellshift.model.game.gun.FireStrategy;
import com.l06g06.shellshift.model.game.gun.NormalFireStrategy;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Database {
    private static Database instance;

    private FireStrategy firingStrategy;
    private int numLives;
    private int damageMultiplier;
    private int numCoins;
    private int monstersKilled;
    private List<Integer> scores = new ArrayList<>(0);
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

    public int getNumCoins() {
        return numCoins;
    }

    public void setNumCoins(int numCoins) {
        this.numCoins = numCoins;
    }

    public int getMonstersKilled() {
        return monstersKilled;
    }

    public void setMonstersKilled(int monstersKilled) {
        this.monstersKilled = monstersKilled;
    }

    public void addScore(int score) {
        this.scores.add(score);
        this.scores.sort(Collections.reverseOrder());
        if (this.scores.size() > 5) {
            this.scores = this.scores.subList(0,5);
        }
    }

    public void addCoins(int coins) {
        this.numCoins += coins;
        if (getMAXCOINS() < numCoins) this.numCoins = getMAXCOINS();
    }

    public List<Integer> getScores() {
        return scores;
    }

    public int getMAXSCORE() {
        return 999999;
    }

    public int getMAXCOINS() {
        return 1000;
    }
}
