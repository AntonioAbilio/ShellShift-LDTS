package com.l06g06.shellshift.viewers;

import com.l06g06.shellshift.Components;
import com.l06g06.shellshift.Database;
import com.l06g06.shellshift.gui.Gui;
import com.l06g06.shellshift.model.game.elements.Position;
import com.l06g06.shellshift.model.game.elements.enemies.SoftMonster;
import com.l06g06.shellshift.model.game.elements.enemies.moveStrategies.MoveStrategy;
import com.l06g06.shellshift.viewer.game.SoftMonsterViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class SoftMonsterViewerTest {
    private SoftMonster softMonster;
    private MoveStrategy moveStrategy;
    private SoftMonsterViewer softMonsterViewer;
    private Gui gui;

    @BeforeEach
    void setUp(){
        Database.getInstance().setSound(true);
        softMonster = new SoftMonster(new Position(10, 10), moveStrategy);
        softMonsterViewer = new SoftMonsterViewer();
        gui = Mockito.mock(Gui.class);
    }

    @Test
    void drawSoftMonster(){
        softMonsterViewer.draw(softMonster, gui);
        Mockito.verify(gui, Mockito.times(1)).drawImageASCII(eq(Components.SoftMonster.getImage()), eq(softMonster.getPosition()));
        verify(gui, times(softMonster.getHP()/25)).drawImageASCII(eq(Components.HealthBar.getImage()), any(Position.class));
    }
}
