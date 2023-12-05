package com.l06g06.shellshift.viewer.game;

import com.l06g06.shellshift.gui.Gui;
import com.l06g06.shellshift.model.game.elements.enemies.Enemy;
import com.l06g06.shellshift.model.game.elements.enemies.HardMonster;
import com.l06g06.shellshift.viewer.View;

public class HardMonsterViewer extends EnemyViewer{

    public static final String[] HARDMONSTER={
            "   JJJ   JJJ   ",
            "   JUJ   JUJ   ",
            "    JUJJJUJ    ",
            "JJ JUFFFFFUJ JJ",
            "JUJUFFFFFFFUJUJ",
            "JFFJJFFFFFJJFFJ",
            "JFFJGJFFFJGJFFJ",
            "JFFJGTJFJTGJFFJ",
            " JFFJJFFFJJFFJ ",
            " JFFFFFJFFFFFJ ",
            " JFFFEEEEEFFFJ ",
            " JEFFJJJJJFFEJ ",
            "  JEEJ   JEEJ  ",
            " JEJJ     JJEJ ",
            " JJ         JJ ",
    };

    @Override
    public void draw(Enemy enemy, Gui gui) {
        if (enemy instanceof HardMonster) View.ASCII_Drawer(HARDMONSTER, enemy.getPosition(), gui);
    }
}
