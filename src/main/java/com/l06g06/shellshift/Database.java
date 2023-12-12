package com.l06g06.shellshift;

import com.l06g06.shellshift.model.game.gun.FireStrategy;
import com.l06g06.shellshift.model.game.gun.NormalFireStrategy;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Database {
    private static Database instance;

    private FireStrategy firingStrategy;
    private int numLives = 3;
    private int damageMultiplier = 1;
    private int numCoins = 999;
    private int collectedCoins = 0;
    private int monstersKilled = 0;
    private int startingNumBullets = 30;
    private List<Integer> scores = new ArrayList<>(0);
    private Database() {
        this.firingStrategy = new NormalFireStrategy();
        for (int i = 0 ; i < 3; i++)  addScore(0);
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
        if (this.scores.size() > 3) {
            this.scores = this.scores.subList(0,3);
        }
    }

    public void addCoins(int coins) {
        this.numCoins += coins;
        addCollectedCoins(coins);
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

    public int getMAXLIVES() {
        return 8;
    }
    public int getMAXBULLETS() {
        return 200;
    }
    public void addMonstersKilled(int monstersKilled) {
        this.monstersKilled += monstersKilled;
    }

    public int getCollectedCoins() {
        return collectedCoins;
    }

    public void setCollectedCoins(int collectedCoins) {
        this.collectedCoins = collectedCoins;
    }

    public void addCollectedCoins(int coins) {
        this.collectedCoins += coins;
        if (collectedCoins > getMAXCOINS()) this.collectedCoins = getMAXCOINS();
    }

    public void addStartingBullets(int bullets) {
        this.startingNumBullets += bullets;
        if (this.startingNumBullets > getMAXBULLETS()) this.startingNumBullets = getMAXBULLETS();
    }

    public int getStartingNumBullets() {
        return this.startingNumBullets;
    }
}
