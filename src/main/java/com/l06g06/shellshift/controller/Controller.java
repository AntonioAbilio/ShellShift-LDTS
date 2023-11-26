package com.l06g06.shellshift.controller;

import com.l06g06.shellshift.Game;

import java.io.IOException;

public abstract class Controller<T> {
    private final T model;

    public Controller(T model){
        this.model = model;
    }

    public T getModel() {
        return model;
    }

    //public abstract void step(Game game, GUI.ACTION action, long time) throws IOException;
}
