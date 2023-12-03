package com.l06g06.shellshift.viewer;

import com.googlecode.lanterna.TextColor;

public enum CharColor {
    DarkBrown(TextColor.Factory.fromString("#1A1410"), 'A'),
    Brown(TextColor.Factory.fromString("#30261d"), 'B'),
    LightBrown(TextColor.Factory.fromString("#544233"), 'C'),
    VeryLightBrown(TextColor.Factory.fromString("#8A6D55"), 'D'),
    Blue(TextColor.Factory.fromString("#405A5D"), 'E'),
    LightBlue(TextColor.Factory.fromString("#8CC5CD"), 'F'),
    White(TextColor.Factory.fromString("#FFFFFF"), 'G'),
    Black(TextColor.Factory.fromString("#000000"), 'H');


    private final TextColor color;
    private final char c;

    CharColor(TextColor color, char c){
        this.color = color;
        this.c = c;
    }

    public char getChar() {
        return c;
    }

    public TextColor getColor() {
        return color;
    }

    public static CharColor getCharColor(char c){
        for (CharColor color : CharColor.values()){
            if (c == color.getChar()) return color;
        }
        return Black; // If the color isn't in the enum, return Black
    }

}