package com.l06g06.shellshift.states;

import com.l06g06.shellshift.Game;
import com.l06g06.shellshift.gui.Gui;
import com.l06g06.shellshift.viewer.View;

import java.io.IOException;

public abstract class State<T> {
    private final T model;
    private int i = 0;
    private View<T> viewer;
    //private Controller<T> controller;

    public State(T model) {
        this.model = model;
        this.viewer = getViewer();
    }

    public T getModel() {
        return model;
    }

    public void step(Game game, Gui gui) throws IOException {
        System.out.println(i);
        viewer.draw(gui);
        i++;
    }

    protected abstract View<T> getViewer();
}
