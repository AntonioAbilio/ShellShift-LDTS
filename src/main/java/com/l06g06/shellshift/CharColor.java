package com.l06g06.shellshift;

public enum CharColor {
    DarkBrown("#1A1410", 'A'),
    Brown("#30261d", 'B'),
    LightBrown("#544233", 'C'),
    VeryLightBrown("#8A6D55", 'D'),
    Blue("#405A5D", 'E'),
    LightBlue("#8CC5CD", 'F'),
    White("#FFFFFF", 'G'),
    Black("#000000", 'H'),
    ChellSkin("#F9CDBB", 'I'),
    BlackNotBlack("#110C01", 'J'),
    Pink("#AF7174", 'K'),
    RoseGold("#664243", 'L'),
    DarkGrey("#202020", 'M'),
    Grey("#828481", 'N'),
    LightGrey("#a2a4a1", 'O'),
    VeryLightGrey("#d1d6d0", 'P'),
    Orange("#ED7C2B", '*'),
    LightOrange("#ffc20e", 'Q'),
    DarkOrange("#792d01", 'R'),
    Red("#FF4433", 'S'),
    Yellow("#FFD700", 'y');

    private final String color;
    private final char c;

    CharColor(String color, char c){
        this.color = color;
        this.c = c;
    }

    public char getChar() {
        return c;
    }

    public String getColor(){
        return color;
    }

    public static CharColor getCharColor(char c){
        for (CharColor color : CharColor.values()){
            if (c == color.getChar()) return color;
        }
        return Black; // If the color isn't in the enum, return Black
    }

}