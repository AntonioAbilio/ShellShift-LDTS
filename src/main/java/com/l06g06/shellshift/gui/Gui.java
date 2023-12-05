package com.l06g06.shellshift.gui;

import com.l06g06.shellshift.model.game.elements.Position;

import java.io.IOException;
import java.util.List;

public interface Gui {

    List<PressedKey> getNextAction() throws IOException;

    void drawCoin(Position pos);

    void drawChell(Position pos);

    void drawBullet(Position pos);

    void drawPlatform(Position pos);

    void drawMonster(Position pos);

    void drawPowerup(Position pos);

    void drawText(Position pos, String text, String color);

    void clear();

    void refresh() throws IOException;

    void close() throws IOException;

    enum PressedKey{UP,DOWN,LEFT,RIGHT,SELECT,FIRE,EXIT,NONE};
}
