package com.l06g06.shellshift.viewer.game;

import com.l06g06.shellshift.gui.Gui;
import com.l06g06.shellshift.model.game.elements.Chell;

public class ChellViewer implements ElementViewer<Chell>{
    /*DarkBrown - #1A1410  - A
    Brown - #30261d - B
    LightBrown - #544233 - C
    VeryLightBrown - #8A6D55 - D

    Blue - #405A5D - E
    LightBlue - #8CC5CD - F
    White - #FFFFFF - G
    Black - #000000 - H

    ChellSkin - #f9cdbb - I
    BlackNotBlack - #110C01 - J
    Pink - AF7174 - K
    RoseGold - 664243 - L

    DarkGrey - 202020 - M
    Grey - 828481 - N
    LightGrey - a2a4a1 - O
    VeryLightGrey - d1d6d0 - P

    Orange - ED7C2B - Q
    */

    private static final String[] ChellDraw = new String[]{
            " AAAA          ",
            "ABBDCAAAAAAAA  ",
            "ABBDDCCCCCCCCA ",
            "ABBBDDDDDDDDDCA",
            " ABBACCCCCCCCCA",
            "ABBABBBBBBBBBBA",
            "ABBABBJJIBBJJBA",
            "ABBABJGEIIBGEJA",
            " AAAKIGFIIIGFIA",
            "   MLIIIIIIIIL ",
            "  MONLLLLLLLL  ",
            " MGPMNGGGGPNMJJ",
            " MIMOPGGGGGPIJ ",
            "  MQQQJJJJQQJ  ",
            "   JJJ    JJJ  "
    };

    @Override
    public void draw(Chell chell, Gui gui){
        gui.drawChell(chell.getPosition());
    }
}