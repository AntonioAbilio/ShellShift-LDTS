package com.l06g06.shellshift.viewer.game;

import com.l06g06.shellshift.Components;
import com.l06g06.shellshift.gui.Gui;
import com.l06g06.shellshift.model.game.elements.enemies.Enemy;
import com.l06g06.shellshift.model.game.elements.enemies.HardMonster;
import com.l06g06.shellshift.viewer.View;

public class HardMonsterViewer extends EnemyViewer{

    @Override
    public void draw(Enemy enemy, Gui gui) {
        //if (enemy instanceof HardMonster) View.ASCII_Drawer(HARDMONSTER, enemy.getPosition(), gui);
        if (enemy instanceof HardMonster) gui.drawImageASCII(Components.HardMonster.getImage(), enemy.getPosition());
    }
}
