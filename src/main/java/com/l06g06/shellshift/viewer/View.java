package com.l06g06.shellshift.viewer;

import com.l06g06.shellshift.gui.Gui;

import java.io.IOException;

public abstract class View<T> {
    private final T model;

    protected View(T model) {
        this.model = model;
    }

    public T getModel() {
        return model;
    }

    public void drawTest(Gui gui) throws IOException {
        drawElements(gui);
    }

    public void draw(Gui gui) throws IOException {
        gui.clear();
        drawElements(gui);
        gui.refresh();
    }

    protected abstract void drawElements(Gui gui);
}
