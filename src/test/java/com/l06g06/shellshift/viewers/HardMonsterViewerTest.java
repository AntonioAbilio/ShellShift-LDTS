package com.l06g06.shellshift.viewers;

import com.l06g06.shellshift.gui.Gui;
import com.l06g06.shellshift.model.game.elements.Position;
import com.l06g06.shellshift.model.game.elements.enemies.Enemy;
import com.l06g06.shellshift.model.game.elements.enemies.HardMonster;
import com.l06g06.shellshift.viewer.game.EnemyViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class HardMonsterViewerTest {
    private Enemy enemy;
    private EnemyViewer viewer;
    private Gui gui;

    @BeforeEach
    void setUp(){
        enemy = new HardMonster(new Position(10, 10));
        viewer = new EnemyViewer();
        gui = Mockito.mock(Gui.class);
    }

    @Test
    void drawHardMonster(){
        viewer.draw(enemy, gui);
        Mockito.verify(gui, Mockito.times(1)).drawMonster(enemy.getPosition());
    }
}
