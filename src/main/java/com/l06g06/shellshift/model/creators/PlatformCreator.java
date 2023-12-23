package com.l06g06.shellshift.model.creators;

import com.google.common.annotations.VisibleForTesting;
import com.l06g06.shellshift.model.game.elements.Element;
import com.l06g06.shellshift.model.game.elements.Platform;
import com.l06g06.shellshift.model.game.elements.Position;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

public class PlatformCreator extends Creator {
    private Position lastPosition = new Position(-1, -1);
    SecureRandom rn = new SecureRandom();
    private int last_level = 4;
    private int nextLevel = 0;

    public PlatformCreator() {
        lastPosition = new Position(-1, -1);
        rn = new SecureRandom();
        last_level = 4;
        nextLevel = 0;
    }

    @VisibleForTesting
    public void setLastLevel(int lastLevel) {
        this.last_level = lastLevel;
    }

    @VisibleForTesting
    public int getLastLevel() {
        return this.last_level;
    }

    @VisibleForTesting
    public int getNextLevel() {
        return nextLevel;
    }

    @VisibleForTesting
    public void setSecureRandom(SecureRandom secureRandom) {
        this.rn = secureRandom;
    }

    @Override
    public Element create(Position position) {
        // The platforms added represent y levels and only one platform is chosen at a time
        List<List<Integer>> possiblePlatforms = new ArrayList<>(0);

        List<Integer> Platform_1 = new ArrayList<>(0);
        Platform_1.add(position.getX());
        Platform_1.add(97);
        possiblePlatforms.add(Platform_1);

        List<Integer> Platform_2 = new ArrayList<>(0);
        Platform_2.add(position.getX());
        Platform_2.add(78);
        possiblePlatforms.add(Platform_2);

        List<Integer> Platform_3 = new ArrayList<>(0);
        Platform_3.add(position.getX());
        Platform_3.add(59);
        possiblePlatforms.add(Platform_3);

        List<Integer> Platform_4 = new ArrayList<>(0);
        Platform_4.add(position.getX());
        Platform_4.add(42);
        possiblePlatforms.add(Platform_4);

        List<Integer> Platform_5 = new ArrayList<>(0);
        Platform_5.add(position.getX());
        Platform_5.add(25);
        possiblePlatforms.add(Platform_5);

        int x = 300;

        // maximum distance between a lower level to a higher level
        nextLevel = rn.nextInt(last_level + 2);
        if (nextLevel > 4) nextLevel = rn.nextInt(last_level + 1);

        if (last_level == nextLevel && nextLevel != 4) {
            nextLevel++;
        }

        int y = possiblePlatforms.get(nextLevel).get(1);
        last_level = nextLevel;

        lastPosition = new Position(x, y);

        return new Platform(lastPosition);
    }


}
