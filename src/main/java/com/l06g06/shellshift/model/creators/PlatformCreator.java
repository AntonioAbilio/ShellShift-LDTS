package com.l06g06.shellshift.model.creators;

import com.l06g06.shellshift.model.game.elements.Element;
import com.l06g06.shellshift.model.game.elements.Platform;
import com.l06g06.shellshift.model.game.elements.Position;

import java.util.Random;

public class PlatformCreator extends Creator{

    public Element create(Position position) {
        Random rn = new Random();
        int maximum = 100;
        int minimum = 0;
        int n = maximum - minimum + 1;
        int i = rn.nextInt() % n;
        int new_y = minimum + i;
        System.out.println(new_y);
        return new Platform(new Position(position.getX(), new_y));
    }
}
