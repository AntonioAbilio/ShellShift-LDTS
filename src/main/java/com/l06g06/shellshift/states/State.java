package com.l06g06.shellshift.states;

import com.l06g06.shellshift.Game;

import java.io.IOException;

public abstract class State<T> {
    private final T model;
    private int i = 0;

    public State(T model) {
        this.model = model;
    }

    public T getModel() {
        return model;
    }

    public void step(Game game) throws IOException {
        System.out.println(i);
        i++;
    }
}
