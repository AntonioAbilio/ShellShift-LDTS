package com.l06g06.shellshift.viewer.game;

import com.l06g06.shellshift.Components;
import com.l06g06.shellshift.gui.Gui;
import com.l06g06.shellshift.model.game.elements.Coin;
import com.l06g06.shellshift.model.game.elements.Position;
import com.l06g06.shellshift.model.game.elements.enemies.Enemy;
import com.l06g06.shellshift.model.game.elements.enemies.HardMonster;
import com.l06g06.shellshift.model.game.elements.enemies.SoftMonster;
import com.l06g06.shellshift.viewer.View;

public class SoftMonsterViewer extends EnemyViewer {

    @Override
    public void draw(Enemy enemy, Gui gui) {
        if (enemy instanceof SoftMonster) gui.drawImageASCII(Components.SoftMonster.getImage(), enemy.getPosition());
    }
}
