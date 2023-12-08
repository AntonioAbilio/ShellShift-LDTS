package com.l06g06.shellshift.model.game.elements;

import com.l06g06.shellshift.Database;

import javax.xml.crypto.Data;

public class Bullet extends Element {
    private double damageMultiplier;
    private boolean direction = true; // true = direita, false = esquerda

    public Bullet(Position position) {
        super(position);
        this.damageMultiplier = Database.getInstance().getDamageMultiplier();
    }

    public void setDamageMultiplier(int damageMultiplier) {
        this.damageMultiplier = damageMultiplier;
    }

    public double getDamageMultiplier() {
        return damageMultiplier;
    }

    public boolean isDirection() {
        return direction;
    }

    public void setDirection(boolean direction) {
        this.direction = direction;
    }
}
