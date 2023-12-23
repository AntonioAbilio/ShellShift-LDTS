package com.l06g06.shellshift.states;

import com.l06g06.shellshift.Game;
import com.l06g06.shellshift.controller.Controller;
import com.l06g06.shellshift.gui.Gui;
import com.l06g06.shellshift.viewer.View;

import java.io.IOException;
import java.util.List;

public abstract class State<T> {
    private final T model;
    private final View<T> viewer;
    private final Controller<T> controller;

    public State(T model) {
        this.model = model;
        this.viewer = getViewer();
        this.controller = getController();
    }

    public T getModel() {
        return model;
    }

    public void step(Game game, Gui gui, long time) throws IOException {
        List<Gui.PressedKey> action = gui.getNextAction();
        controller.step(game, action, time);
        viewer.draw(gui);

    }

    protected abstract View<T> getViewer();

    protected abstract Controller<T> getController();
}
