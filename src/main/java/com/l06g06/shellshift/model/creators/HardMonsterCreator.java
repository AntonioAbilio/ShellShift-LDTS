package com.l06g06.shellshift.model.creators;

import com.l06g06.shellshift.model.game.elements.Element;
import com.l06g06.shellshift.model.game.elements.Position;
import com.l06g06.shellshift.model.game.elements.enemies.Enemy;
import com.l06g06.shellshift.model.game.elements.enemies.HardMonster;

import java.util.Random;

public class HardMonsterCreator extends Creator {
    @Override
    public Element create(Position position) {
        Random rn = new Random();
        int maximum = 50;
        int minimum = 30;
        int n = maximum - minimum + 1;
        int i = rn.nextInt() % n;
        int new_y = minimum + i;
        return new HardMonster(new Position(position.getX(), new_y)) {
        };
    }
}
