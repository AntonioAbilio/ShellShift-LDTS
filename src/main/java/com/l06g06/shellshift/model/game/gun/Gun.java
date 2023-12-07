package com.l06g06.shellshift.model.game.gun;

public class Gun {
    private int numBullets = 10;
    private FireStrategy strategy;

    public Gun(FireStrategy strategy) {
        this.strategy = strategy;
    }
    public void decreaseNumBullet() {
        this.numBullets--;
    }

    public int getNumBullets() {
        return numBullets;
    }

    public void setNumBullets(int numBullets) {
        this.numBullets = numBullets;
    }

    public void setStrategy(FireStrategy strategy) {
        this.strategy = strategy;
    }

    public FireStrategy getFireStrategy() {
        return this.strategy;
    }

    public double getReloadTime() {
        return strategy.getReloadTime();
    }

}
