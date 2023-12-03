package com.l06g06.shellshift.viewer;

import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import com.l06g06.shellshift.gui.Gui;
import com.l06g06.shellshift.model.game.elements.Coin;

import java.io.IOException;

public abstract class NewView { // This class is a substitute for the ElementViewer Class
    TextGraphics graphics;
    Screen screen;

    protected NewView(TextGraphics graphics, Screen screen) {
        this.graphics = graphics;
        this.screen = screen;
    }


    public void drawTest(Gui gui) throws IOException {
        //drawElements(gui);
    }

    public void draw(Gui gui) throws IOException {
        gui.clear();
        //drawElements(gui);
        gui.refresh();
    }

    //protected abstract void drawElements(Gui gui);
}
