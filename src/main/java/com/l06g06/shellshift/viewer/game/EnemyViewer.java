package com.l06g06.shellshift.viewer.game;

import com.l06g06.shellshift.gui.Gui;
import com.l06g06.shellshift.model.game.elements.enemies.Enemy;
import com.l06g06.shellshift.viewer.View;

public class EnemyViewer implements ElementViewer<Enemy>{
    @Override
    public void draw(Enemy enemy, Gui gui){
        //gui.drawMonster(enemy.getPosition());
        //View.ASCII_Drawer(ENEMY, enemy.getPosition(),gui);
    }
}
