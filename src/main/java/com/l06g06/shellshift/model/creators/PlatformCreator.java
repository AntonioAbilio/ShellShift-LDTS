package com.l06g06.shellshift.model.creators;

import com.l06g06.shellshift.Game;
import com.l06g06.shellshift.model.game.elements.Element;
import com.l06g06.shellshift.model.game.elements.Platform;
import com.l06g06.shellshift.model.game.elements.Position;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

public class PlatformCreator extends Creator {

    private int X_SPAWN = 160;
    private Position lastPosition = new Position(-1,-1);

    public Element create(Position position) {
        SecureRandom rn = new SecureRandom();
        int nextPlatform = rn.nextInt(5);
        int offsetX = rn.nextInt(10);
        int positiveOrNegative = rn.nextInt(2);

        List<List<Integer>> possiblePlatforms = new ArrayList<>(0);

        List<Integer> Platform_1 = new ArrayList<>(0);
        Platform_1.add(X_SPAWN);
        Platform_1.add(97);
        possiblePlatforms.add(Platform_1);

        List<Integer> Platform_2 = new ArrayList<>(0);
        Platform_2.add(X_SPAWN);
        Platform_2.add(78);
        possiblePlatforms.add(Platform_2);

        List<Integer> Platform_3 = new ArrayList<>(0);
        Platform_3.add(X_SPAWN);
        Platform_3.add(59);
        possiblePlatforms.add(Platform_3);

        List<Integer> Platform_4 = new ArrayList<>(0);
        Platform_4.add(X_SPAWN);
        Platform_4.add(42);
        possiblePlatforms.add(Platform_4);

        List<Integer> Platform_5 = new ArrayList<>(0);
        Platform_5.add(X_SPAWN);
        Platform_5.add(25);
        possiblePlatforms.add(Platform_5);

        int x;
        if (positiveOrNegative == 0) x = possiblePlatforms.get(nextPlatform).get(0) + offsetX;
        else x = possiblePlatforms.get(nextPlatform).get(0) - offsetX;

        int y = possiblePlatforms.get(nextPlatform).get(1);

        //System.out.println("Current X: " + x + " Y: " + y);
        //System.out.println("Last X: " + x + " Y: " + y);

        if (lastPosition.getY() == y){
            nextPlatform = rn.nextInt(5);
            y = possiblePlatforms.get(nextPlatform).get(1);
        }

        lastPosition = new Position(x,y);



        return new Platform(lastPosition);
    }


}
