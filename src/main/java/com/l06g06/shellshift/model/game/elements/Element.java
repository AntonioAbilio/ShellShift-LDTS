package com.l06g06.shellshift.model.game.elements;

public abstract class Element {
    private Position position;
    public Element(Position position) {
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

}
