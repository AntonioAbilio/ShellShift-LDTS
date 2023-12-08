package com.l06g06.shellshift.viewer.game;

import com.l06g06.shellshift.Components;
import com.l06g06.shellshift.gui.Gui;
import com.l06g06.shellshift.model.game.elements.Chell;

public class ChellViewer implements ElementViewer<Chell>{

    private static final String[] CHELL = new String[]{
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
        /*gui.drawChell(chell.getPosition());*/

        // Use this to draw the coin in ASCII Art.
       gui.drawImageASCII(chell.isDirection() ? Components.Chell.getImage() : Components.Chell.getImageSelected(), chell.getPosition());

        /*// Move chell ... DEBUG
        chell.setPosition(new Position(chellPos.getX()+1, chellPos.getY()));*/

    }
}