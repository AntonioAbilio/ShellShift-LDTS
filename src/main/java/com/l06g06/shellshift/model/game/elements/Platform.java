package com.l06g06.shellshift.model.game.elements;

import java.awt.*;

public class Platform extends Element {

    private final static int height = 4;
    private final static int width = 66;

    public Platform(Position position) {
        super(position);

        Polygon platformHitbox = new Polygon();

        int x = position.getX();
        int y = position.getY();

        platformHitbox.addPoint(x, y);
        platformHitbox.addPoint(x - width, y);
        platformHitbox.addPoint(x, y + height - 1);
        platformHitbox.addPoint(x - width, y + height - 1);
        this.hitbox = platformHitbox;
    }

    public static int getHeight() {
        return height;
    }

    public static int getWidth() {
        return width;
    }
}
