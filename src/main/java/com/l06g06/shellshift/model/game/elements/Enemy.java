package com.l06g06.shellshift.model.game.elements;

public abstract class Enemy extends Element {
    protected int HP;
    public Enemy(Position position, int HP) {
        super(position);
        this.HP = HP;
    }
    public abstract void update();

}
