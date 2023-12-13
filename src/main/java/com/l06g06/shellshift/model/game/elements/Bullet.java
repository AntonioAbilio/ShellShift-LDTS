package com.l06g06.shellshift.model.game.elements;

import com.l06g06.shellshift.Database;

import java.awt.*;

public class Bullet extends Element {
    private final int damage = 50;
    private int damageMultiplier;
    private boolean direction = true; // true = direita, false = esquerda

    private final static int height = 4;
    private final static int width = 4;

    public Bullet(Position position) {
        super(position);
        this.damageMultiplier = Database.getInstance().getDamageMultiplier();

        Polygon bulletHitbox = new Polygon();
        int x = position.getX();
        int y = position.getY();
        bulletHitbox.addPoint(x,y);
        bulletHitbox.addPoint(x+width-1,y);
        bulletHitbox.addPoint(x, y+height-1);
        bulletHitbox.addPoint(x+width-1, y+height-1);
        this.hitbox = bulletHitbox;
    }

    public void setDamageMultiplier(int damageMultiplier) {
        this.damageMultiplier = damageMultiplier;
    }

    public int getDamageMultiplier() {
        return damageMultiplier;
    }

    public boolean isDirection() {
        return direction;
    }

    public void setDirection(boolean direction) {
        this.direction = direction;
    }

    public int getDamage() {
        return damage * damageMultiplier;
    }
}
