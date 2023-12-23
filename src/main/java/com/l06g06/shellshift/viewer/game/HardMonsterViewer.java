package com.l06g06.shellshift.viewer.game;

import com.l06g06.shellshift.Components;
import com.l06g06.shellshift.gui.Gui;
import com.l06g06.shellshift.model.game.elements.Position;
import com.l06g06.shellshift.model.game.elements.enemies.Enemy;
import com.l06g06.shellshift.model.game.elements.enemies.HardMonster;

public class HardMonsterViewer extends EnemyViewer {

    @Override
    public void draw(Enemy enemy, Gui gui) {
        if (enemy instanceof HardMonster) {
            gui.drawImageASCII(Components.HardMonster.getImage(), enemy.getPosition());
            for (int i = 0; i < enemy.getHP() / 25; i++)
                gui.drawImageASCII(Components.HealthBar.getImage(), new Position(enemy.getPosition().getX() + 1 + i * 3, enemy.getPosition().getY() - 6));

        }
    }
}
