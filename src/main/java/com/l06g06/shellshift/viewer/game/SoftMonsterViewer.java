package com.l06g06.shellshift.viewer.game;

import com.l06g06.shellshift.Components;
import com.l06g06.shellshift.gui.Gui;
import com.l06g06.shellshift.model.game.elements.Position;
import com.l06g06.shellshift.model.game.elements.enemies.Enemy;
import com.l06g06.shellshift.model.game.elements.enemies.SoftMonster;

public class SoftMonsterViewer extends EnemyViewer {

    @Override
    public void draw(Enemy enemy, Gui gui) {
        if (enemy instanceof SoftMonster) {
            gui.drawImageASCII(Components.SoftMonster.getImage(), enemy.getPosition());
            for (int i = 0; i < enemy.getHP() / 25; i++)
                gui.drawImageASCII(Components.HealthBar.getImage(), new Position(enemy.getPosition().getX() + 3 + i * 3, enemy.getPosition().getY() - 6));

        }
    }
}
