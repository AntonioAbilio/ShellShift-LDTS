package com.l06g06.shellshift.viewer.game;

import com.l06g06.shellshift.Components;
import com.l06g06.shellshift.gui.Gui;
import com.l06g06.shellshift.model.game.elements.Chell;
//import com.l06g06.shellshift.model.game.elements.Position;
//import com.l06g06.shellshift.viewer.CharColor;
//import com.l06g06.shellshift.viewer.View;
//import org.w3c.dom.Text;

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

    /*private static final String[] HITBOX = new String[]{
            "P"
    };*/

    @Override
    public void draw(Chell chell, Gui gui){


        /*View.ASCII_Drawer(CHELL, new Position(chell.getPosition().getX()-14, chell.getPosition().getY()-14), gui);
        gui.drawChell(chell.getPosition());

        //Uncomment this to see hithox.
        for (int i = 0; i < chell.getPolygon().npoints; i++) {
            int x = chell.getPolygon().xpoints[i];
            int y = chell.getPolygon().ypoints[i];
            View.ASCII_Drawer(HITBOX, new Position(x,y), gui);
            *//*System.out.println("Vertex " + (i + 1) + ": (" + x + ", " + y + ")");*//*
        }*/

        // Use this to draw the coin in ASCII Art.
       gui.drawImageASCII(chell.isDirection() ? Components.Chell.getImage() : Components.Chell.getImageSelected(), new Position(chell.getPosition().getX()-14, chell.getPosition().getY()-14));

        /*// Move chell ... DEBUG
        chell.setPosition(new Position(chellPos.getX()+1, chellPos.getY()));*/

    }
}