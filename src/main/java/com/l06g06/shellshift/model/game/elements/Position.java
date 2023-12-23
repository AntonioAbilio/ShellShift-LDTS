package com.l06g06.shellshift.model.game.elements;

import java.time.Instant;
import java.util.Objects;
import java.util.Random;

public class Position {
    Random random;
    private final int x;
    private final int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
        random = new Random();
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !(o instanceof Position position)) return false;
        return x == position.x && y == position.y;
    }

    @Override
    public int hashCode() {
        int rand = (int) Instant.now().getEpochSecond();
        return (Objects.hash(x, y) + rand) % 1333;
    }

}
