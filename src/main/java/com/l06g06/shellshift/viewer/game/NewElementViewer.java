package com.l06g06.shellshift.viewer.game;

import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import com.l06g06.shellshift.gui.Gui;

import java.io.IOException;

// ToDo: Substitute Element Viewer by this class
public abstract class NewElementViewer { // This class is a substitute for the ElementViewer Class
    TextGraphics graphics;

    protected NewElementViewer(TextGraphics graphics) {
        this.graphics = graphics;
    }

    public void draw() throws IOException {
        //gui.clear();
        //drawElements(gui);
        //gui.refresh();
    }

    //protected abstract void drawElements(Gui gui);
}
