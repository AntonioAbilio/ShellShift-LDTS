package com.l06g06.shellshift.model.game.elements;

public class SoftMonster extends Monster {
    public SoftMonster(Position position) {
        super(position, 50);
    }

    @Override
    public void update() {
        HP += 15;
    }
}
