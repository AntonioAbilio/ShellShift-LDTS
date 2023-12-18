package com.l06g06.shellshift.viewer.game;

import com.l06g06.shellshift.gui.Gui;
import com.l06g06.shellshift.model.game.elements.enemies.Enemy;

public abstract class EnemyViewer implements ElementViewer<Enemy>{
    @Override
    public abstract void draw(Enemy enemy, Gui gui);
}
