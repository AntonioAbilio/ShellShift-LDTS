package com.l06g06.shellshift.viewer.game;

import com.l06g06.shellshift.gui.Gui;
import com.l06g06.shellshift.model.game.elements.enemies.Enemy;
import com.l06g06.shellshift.viewer.View;

public abstract class EnemyViewer implements ElementViewer<Enemy>{
    public abstract void draw(Enemy enemy, Gui gui);
}
