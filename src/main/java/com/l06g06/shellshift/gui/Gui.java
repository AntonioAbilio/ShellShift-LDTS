package com.l06g06.shellshift.gui;

import com.l06g06.shellshift.model.game.elements.Position;

import java.io.IOException;
import java.util.List;

public interface Gui {
    List<PressedKey> getNextAction() throws IOException;
    void drawASCII(Position position, String color);
    void drawImageASCII(String[] image, Position position);
    void clear();
    void refresh() throws IOException;
    void close() throws IOException;
    void setGradientBackground(String innerColor, String outerColor);
    void setBackground(String color);
    void numToASCII(int num, int x, int y);
    enum PressedKey{UP,DOWN,LEFT,RIGHT,SELECT,FIRE,EXIT,NONE};
}
