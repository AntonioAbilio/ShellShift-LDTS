package com.l06g06.shellshift.model.game.elements;

import java.awt.*;

public class Bullet extends Element {
    private int damageMultiplier = 1;

    private final static int height = 3;
    private final static int width = 4;

    public Bullet(Position position) {
        super(position);

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
}
