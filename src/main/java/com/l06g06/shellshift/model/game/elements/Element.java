package com.l06g06.shellshift.model.game.elements;

import java.awt.*;

public abstract class Element {
    private Position position;
    protected Polygon hitbox;

    public Element(Position position) {
        this.position = position;
        this.hitbox = new Polygon();
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {

        int oldX = this.position.getX();
        int oldY = this.position.getY();

        this.position = position;

        int deltaX = this.position.getX() - oldX;
        int deltaY = this.position.getY() - oldY;

        hitbox.translate(deltaX, deltaY);
    }

    public Polygon getPolygon() {
        return hitbox;
    }
}
