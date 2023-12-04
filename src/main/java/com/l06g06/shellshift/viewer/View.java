package com.l06g06.shellshift.viewer;

import com.l06g06.shellshift.gui.Gui;
import com.l06g06.shellshift.model.game.elements.Position;

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

    public static void ASCII_Drawer(String[] image, Position ElementPos, Gui gui){
        // Get the starting position of the Element
        int y = ElementPos.getY();

        // Iterate over the horizontal line of characters.
        for (String horizontalPixelMatrix : image){

            // Get the starting position of the Element
            int x = ElementPos.getX();
            for (char Pixel : horizontalPixelMatrix.toCharArray()){

                // Get the corresponding color of the character.
                CharColor paint = CharColor.getCharColor(Pixel);

                // Draw the character (Pixel).

                gui.drawText(new Position(x,y), String.valueOf(Pixel), paint.getColor());
                x++;
            }
            y++;
        }
    }

    public void draw(Gui gui) throws IOException {
        gui.clear();
        drawElements(gui);
        gui.refresh();
    }

    protected abstract void drawElements(Gui gui);
}
