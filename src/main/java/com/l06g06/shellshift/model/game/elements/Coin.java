package com.l06g06.shellshift.model.game.elements;

import java.awt.*;

public class Coin extends Element{
    public final int value = 10;
    private final static int width = 10;
    private final static int height = 15;

    public Coin(Position position) {
        super(position);

        Polygon coinHitbox = new Polygon();

        int x = position.getX();
        int y = position.getY();

        coinHitbox.addPoint(x+1,y+1);
        coinHitbox.addPoint(x+width-1,y+1);
        coinHitbox.addPoint(x+1, y+height-1);
        coinHitbox.addPoint(x+width-1, y+height-1);
        this.hitbox = coinHitbox;
    }

    public int getValue() {
        return this.value;
    }
}
