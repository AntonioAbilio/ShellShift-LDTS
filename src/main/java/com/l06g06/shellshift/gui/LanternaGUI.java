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
import com.googlecode.lanterna.terminal.swing.AWTTerminalFontConfiguration;
import com.googlecode.lanterna.terminal.swing.AWTTerminalFrame;
import com.l06g06.shellshift.model.game.elements.Position;
import com.l06g06.shellshift.CharColor;

import java.awt.*;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.List;

public class LanternaGUI implements Gui{
    protected final TerminalScreen screen;
    private List<Integer> buttons = new ArrayList<Integer>(0);

    // Constructor for tests
    public LanternaGUI(TerminalScreen screen){
        this.screen = screen;
    }

    public LanternaGUI(int width, int height) throws IOException, URISyntaxException, FontFormatException {
        AWTTerminalFontConfiguration fontConfig = loadFont();
        Terminal terminal = createTerminal(width, height, fontConfig);
        this.screen = (TerminalScreen) createScreen(terminal);
    }

    private Terminal createTerminal(int width, int height, AWTTerminalFontConfiguration fontConfig) throws IOException {
        TerminalSize terminalSize = new TerminalSize(width, height + 1);
        DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory().setInitialTerminalSize(terminalSize);
        terminalFactory.setForceAWTOverSwing(true);
        terminalFactory.setTerminalEmulatorFontConfiguration(fontConfig);
        Terminal terminal = terminalFactory.createTerminal();

        return terminal;
    }

    private Screen createScreen(Terminal terminal) throws IOException {
        final Screen screen;
        screen = new TerminalScreen(terminal);

        screen.setCursorPosition(null);
        screen.startScreen();
        screen.doResizeIfNecessary();
        return screen;
    }

    private void drawElement(int x, int y, char chr, String color){
        TextGraphics graphics = screen.newTextGraphics();
        graphics.setForegroundColor(TextColor.Factory.fromString(color));
        graphics.putString(x,y, String.valueOf(chr));
    }

    public void addButton(Integer button) {
        if (!this.buttons.contains(button)) this.buttons.add(button);
    }

    public void removeButton(Integer button) {
        this.buttons.remove(button);
    }

    @Override
    public List<PressedKey> getNextAction() throws IOException {

        List<PressedKey> pressedKeyList = new ArrayList<PressedKey>(0);

        if (this.buttons.isEmpty()) return pressedKeyList;

        try {
            for (Integer intg : this.buttons) {
                switch (intg) {
                    case 38:
                        pressedKeyList.add(PressedKey.UP);
                        break;
                    case 40:
                        pressedKeyList.add(PressedKey.DOWN);
                        break;
                    case 37:
                        pressedKeyList.add(PressedKey.LEFT);
                        break;
                    case 39:
                        pressedKeyList.add(PressedKey.RIGHT);
                        break;
                    case 10:
                        pressedKeyList.add(PressedKey.SELECT);
                        break;
                    case 32:
                        pressedKeyList.add(PressedKey.FIRE);
                        break;
                    default:
                        return pressedKeyList;
                }
            }
        } catch (ConcurrentModificationException e){
            getNextAction();
        }

        /*KeyStroke key = this.screen.pollInput();*/

        /*if (key == null)  return PressedKey.NONE;*/

        /*switch (key.getKeyType()){
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
        }*/
        return pressedKeyList;
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
    public void drawPowerup(Position pos) {
        drawElement(pos.getX(), pos.getY(), '=', "#FFFF00");
    }

    @Override
    public void drawText(Position position, String text, String color) {
        TextGraphics textStr = screen.newTextGraphics();
        //textStr.setBackgroundColor(TextColor.ANSI.DEFAULT);
        textStr.setBackgroundColor(TextColor.Factory.fromString(color));
        textStr.setForegroundColor(TextColor.Factory.fromString(color));
        textStr.putString(position.getX(), position.getY(), text);
    }
    @Override
    public void drawASCII(Position position, String color) {
        TextGraphics textStr = screen.newTextGraphics();
        textStr.setBackgroundColor(TextColor.Factory.fromString(color));
        textStr.putString(position.getX(), position.getY(), " ");
    }

    @Override
    public void drawImageASCII(String[] image, Position position) {
        // Get the starting position of the Element
        int y = position.getY();

        // Iterate over the horizontal line of characters.
        for (String horizontalPixelMatrix : image){

            // Get the starting position of the Element
            int x = position.getX();
            for (char Pixel : horizontalPixelMatrix.toCharArray()){

                // Get the corresponding color of the character.
                CharColor paint = CharColor.getCharColor(Pixel);
                if (Pixel != ' ')
                    drawASCII(new Position(x,y), paint.getColor());
                x++;
            }
            y++;
        }
    }

    @Override
    public void clear(){
        this.screen.clear();
    }

    @Override
    public void refresh() throws IOException {
        this.screen.refresh();
    }

    @Override
    public void close() throws IOException {
        screen.close();
    }

    public TerminalScreen getScreen() {
        return screen;
    }

    public void addKeyListenner(KeyListener keyListener){
        ((AWTTerminalFrame)getScreen().getTerminal()).getComponent(0).addKeyListener(keyListener);
    }

    public void removeKeyListenner(KeyListener keyListener){
        ((AWTTerminalFrame)getScreen().getTerminal()).getComponent(0).removeKeyListener(keyListener);
    }

    private AWTTerminalFontConfiguration loadFont() throws URISyntaxException, FontFormatException, IOException {
        URL resource = getClass().getClassLoader().getResource("fonts/square.ttf");
        File fontFile = new File(resource.toURI());
        Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile);

        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.registerFont(font);

        Font loadedFont = font.deriveFont(Font.PLAIN, 8);
        AWTTerminalFontConfiguration fontConfig = AWTTerminalFontConfiguration.newInstance(loadedFont);
        return fontConfig;
    }
    @Override
    public void setGradientBackground(String innerColor, String outerColor) {
        TextGraphics textGraphics = this.screen.newTextGraphics();

        int centerX = this.screen.getTerminalSize().getColumns() / 2;
        int centerY = this.screen.getTerminalSize().getRows() / 2;

        for (int y = 0; y < this.screen.getTerminalSize().getRows(); y++) {
            for (int x = 0; x < this.screen.getTerminalSize().getColumns(); x++) {
                // Calculate distance from the center
                double distance = Math.sqrt(Math.pow(x - centerX, 2) + Math.pow(y - centerY, 2));

                // Calculate gradient factor based on the distance
                double gradientFactor = distance / Math.max(centerX, centerY);

                String gradientColor = calculateGradientColor(innerColor, outerColor, gradientFactor);

                textGraphics.setBackgroundColor(TextColor.Factory.fromString(gradientColor));
                textGraphics.setForegroundColor(TextColor.Factory.fromString(gradientColor));
                textGraphics.putString(x, y, " ");
            }
        }
    }

    private String calculateGradientColor(String startColor, String endColor, double factor) {
        int startRed = Integer.parseInt(startColor.substring(1, 3), 16);
        int startGreen = Integer.parseInt(startColor.substring(3, 5), 16);
        int startBlue = Integer.parseInt(startColor.substring(5, 7), 16);

        int endRed = Integer.parseInt(endColor.substring(1, 3), 16);
        int endGreen = Integer.parseInt(endColor.substring(3, 5), 16);
        int endBlue = Integer.parseInt(endColor.substring(5, 7), 16);

        int red = (int) (startRed + factor * (endRed - startRed));
        int green = (int) (startGreen + factor * (endGreen - startGreen));
        int blue = (int) (startBlue + factor * (endBlue - startBlue));

        return String.format("#%02X%02X%02X", red, green, blue);
    }
}
