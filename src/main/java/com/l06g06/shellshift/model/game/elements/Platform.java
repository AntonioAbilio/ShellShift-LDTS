package com.l06g06.shellshift.model.game.elements;

import java.awt.*;

public class Platform extends Element{

    private final static int height = 4;
    private final static int width = 66;

    public Platform(Position position) {
        super(position);

        Polygon chellHitbox = new Polygon();

        int x = position.getX();
        int y = position.getY();

        chellHitbox.addPoint(x,y);
        chellHitbox.addPoint(x+width,y);
        chellHitbox.addPoint(x, y+height-1);
        chellHitbox.addPoint(x+width, y+height-1);
        this.hitbox = chellHitbox;
    }
}
