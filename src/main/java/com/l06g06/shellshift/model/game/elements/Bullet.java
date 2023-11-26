package com.l06g06.shellshift.model.game.elements;

public abstract class Bullet {
    protected int damageMultiplier;
    protected Bullet(int damageMultiplier) {
        this.damageMultiplier = damageMultiplier;
    }
}
