package com.l06g06.shellshift.controller;

import com.l06g06.shellshift.Game;
import com.l06g06.shellshift.gui.Gui;

import java.io.IOException;
import java.util.List;

public abstract class Controller<T> {
    private final T model;

    public Controller(T model){
        this.model = model;
    }

    public T getModel() {
        return model;
    }

    public abstract void step(Game game, List<Gui.PressedKey> action, long time) throws IOException;
}
