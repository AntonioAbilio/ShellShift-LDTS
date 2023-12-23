package com.l06g06.shellshift.model.game.gun;

import com.google.common.annotations.VisibleForTesting;
import com.l06g06.shellshift.Database;
import com.l06g06.shellshift.Sound;
import com.l06g06.shellshift.SoundsFx;

public class Gun {
    private int numBullets;
    private FireStrategy strategy;

    @VisibleForTesting
    public Gun(FireStrategy strategy, int numBullets) {
        this.strategy = strategy;
        this.numBullets = numBullets;
    }

    public Gun(FireStrategy strategy) {
        this.strategy = Database.getInstance().getFiringStrategy();
        this.numBullets = Database.getInstance().getStartingNumBullets();
    }
    public void decreaseNumBullet() {
        Sound sound = Sound.getInstance();
        sound.playSound(SoundsFx.BulletFired);
        this.numBullets--;
    }

    public int getNumBullets() {
        return numBullets;
    }

    public void setNumBullets(int numBullets) {
        this.numBullets = numBullets;
    }

    public double getReloadTime() {
        return strategy.getReloadTime();
    }

}
