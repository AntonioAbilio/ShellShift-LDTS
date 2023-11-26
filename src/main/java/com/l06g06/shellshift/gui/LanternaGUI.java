package com.l06g06.shellshift.gui;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;


import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.l06g06.shellshift.model.game.elements.Position;

import java.io.IOException;

public class LanternaGUI implements Gui{
    protected final Screen screen;

    // Constructor for tests
    public LanternaGUI(Screen screen){
        this.screen = screen;
    }

    public LanternaGUI(int width, int height) throws IOException{
        TerminalSize terminalSize = new TerminalSize(width, height);
        DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory().setInitialTerminalSize(terminalSize);
        Terminal terminal = terminalFactory.createTerminal();
        this.screen = new TerminalScreen(terminal);
    }

    private void drawElement(int x, int y, char chr, String color){
        TextGraphics graphics = screen.newTextGraphics();
        graphics.setForegroundColor(TextColor.Factory.fromString(color));
        graphics.putString(x,y, String.valueOf(chr));
    }


    @Override
    public PressedKey getNextAction() throws IOException {
        // non-blocking version, does not wait for an input alternative -> this.screen.pollInput();
        KeyStroke key = this.screen.readInput();

        if (key.getKeyType() == KeyType.EOF)  return PressedKey.EXIT;
        switch (key.getKeyType()){
            case ArrowUp:
                return PressedKey.UP;
            case ArrowDown:
                return PressedKey.DOWN;
            case ArrowLeft:
                return PressedKey.LEFT;
            case ArrowRight:
                return PressedKey.RIGHT;
            case Enter:
                return PressedKey.SELECT;
            case Character:
                if (key.getCharacter() == ' '){
                    return PressedKey.FIRE;
                } else if (key.getCharacter() == 'q'){
                    return PressedKey.EXIT;
                } else {
                    return PressedKey.NONE;
                }
            default:
                return PressedKey.NONE;
        }
    }

    @Override
    public void drawCoin(Position pos){
        drawElement(pos.getX(), pos.getY(), 'c', "#FFFF00");
    }

    @Override
    public void drawChell(Position pos){
        drawElement(pos.getX(), pos.getY(), 'P', "#FFFF00");
    }

    @Override
    public void drawBullet(Position pos){
        drawElement(pos.getX(), pos.getY(), '*', "#FFFF00");
    }

    @Override
    public void drawPlatform(Position pos){
        drawElement(pos.getX(), pos.getY(), '-', "#FFFF00");
    }

    @Override
    public void drawMonster(Position pos){
        drawElement(pos.getX(), pos.getY(), 'M', "#FFFF00");
    }

    @Override
    public void drawText(Position position, String text, String color) {
        TextGraphics textStr = screen.newTextGraphics();
        textStr.setForegroundColor(TextColor.Factory.fromString(color));
        textStr.putString(position.getX(), position.getY(), text);
    }

    @Override
    public void clear(){
        this.screen.clear();
    }

    @Override
    public void refresh() throws IOException {
        this.screen.refresh();
    }


}
