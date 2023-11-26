package com.l06g06.shellshift.model.game.elements;

public class Bullet extends Element {
    private int damageMultiplier = 1;

    public Bullet(Position position) {
        super(position);
    }

    public void setDamageMultiplier(int damageMultiplier) {
        this.damageMultiplier = damageMultiplier;
    }

    public int getDamageMultiplier() {
        return damageMultiplier;
    }
}
