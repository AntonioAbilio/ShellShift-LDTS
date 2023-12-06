package com.l06g06.shellshift.viewer.game;

import com.l06g06.shellshift.gui.Gui;
import com.l06g06.shellshift.model.game.elements.Coin;
import com.l06g06.shellshift.model.game.elements.Position;
import com.l06g06.shellshift.model.game.elements.enemies.Enemy;
import com.l06g06.shellshift.model.game.elements.enemies.HardMonster;
import com.l06g06.shellshift.model.game.elements.enemies.SoftMonster;
import com.l06g06.shellshift.viewer.View;

public class SoftMonsterViewer extends EnemyViewer {
    public static final String[] SOFTMONSTER={
            "   JJJ   JJJ   ",
            "   JSJ   JSJ   ",
            "    JSJJJSJ    ",
            "JJ JSQQQQQSJ JJ",
            "JSJSQQQQQQQSJSJ",
            "JQQQJJQQQJJQQQJ",
            "JQQJGGJQJGGJQQJ",
            "JQQJGJJQJJGJQQJ",
            " JQQJJQQQJJQQJ ",
            " JQQQQQJQQQQQJ ",
            " JQQQTTTTTQQQJ ",
            " JTQQJJJJJQQTJ ",
            "  JTTJ   JTTJ  ",
            " JTJJ     JJTJ ",
            " JJ         JJ ",
    };

    /*private static final String[] HITBOX = new String[]{
            "P"
    };*/

    @Override
    public void draw(Enemy enemy, Gui gui) {
        if (enemy instanceof SoftMonster){
            View.ASCII_Drawer(SOFTMONSTER, enemy.getPosition(),gui);
            //Uncomment this to see hithox.
            /*for (int i = 0; i < enemy.getPolygon().npoints; i++) {
            int x = enemy.getPolygon().xpoints[i];
            int y = enemy.getPolygon().ypoints[i];
            View.ASCII_Drawer(HITBOX, new Position(x,y), gui);
            System.out.println("Vertex " + (i + 1) + ": (" + x + ", " + y + ")");
        }*/
        }
    }
}
