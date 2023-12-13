package com.l06g06.shellshift.model.game.gun;

import com.l06g06.shellshift.Database;
import com.l06g06.shellshift.Sound;

public class Gun {
    private int numBullets;
    private FireStrategy strategy;

    public Gun(FireStrategy strategy) {
        this.strategy = Database.getInstance().getFiringStrategy();
        this.numBullets = Database.getInstance().getStartingNumBullets();
    }
    public void decreaseNumBullet() {
        Sound.playSound(Sound.SoundsFx.BulletFired);
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
