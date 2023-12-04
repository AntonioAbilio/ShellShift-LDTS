package com.l06g06.shellshift.model.game.elements;

public class Coin extends Element{
    public final static int value = 1;

    private final static int width = 4;
    private final static int height = 7;

    public Coin(Position position) {
        super(position);
    }
}
