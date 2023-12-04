package com.l06g06.shellshift.viewer.game;

import com.l06g06.shellshift.gui.Gui;
import com.l06g06.shellshift.model.game.elements.Chell;
import com.l06g06.shellshift.model.game.elements.Position;
import com.l06g06.shellshift.viewer.CharColor;
import com.l06g06.shellshift.viewer.View;
import org.w3c.dom.Text;

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
        View.ASCII_Drawer(CHELL, chell.getPosition(), gui);

        /*// Move chell ... DEBUG
        chell.setPosition(new Position(chellPos.getX()+1, chellPos.getY()));*/

    }
}