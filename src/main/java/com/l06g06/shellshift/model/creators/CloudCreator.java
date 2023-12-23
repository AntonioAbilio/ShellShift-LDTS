package com.l06g06.shellshift.model.creators;

import com.l06g06.shellshift.model.game.elements.Cloud;
import com.l06g06.shellshift.model.game.elements.Element;
import com.l06g06.shellshift.model.game.elements.Position;

import java.util.Random;

public class CloudCreator extends Creator {
    @Override
    public Element create(Position position) {
        Random random = new Random();
        Position pos = new Position(position.getX(), 2 + random.nextInt(70));
        return new Cloud(pos);
    }
}
