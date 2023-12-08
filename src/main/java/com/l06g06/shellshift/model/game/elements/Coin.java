package com.l06g06.shellshift.model.game.elements;

import java.awt.*;

public class Coin extends Element{
    public final int value = 10;
    private final static int width = 10;
    private final static int height = 15;

    public Coin(Position position) {
        super(position);

        Polygon chellHitbox = new Polygon();

        int x = position.getX();
        int y = position.getY();

        chellHitbox.addPoint(x+1,y+1);
        chellHitbox.addPoint(x+width-1,y+1);
        chellHitbox.addPoint(x+1, y+height-1);
        chellHitbox.addPoint(x+width-1, y+height-1);
        this.hitbox = chellHitbox;
    }

    public int getValue() {
        return this.value;
    }
}
