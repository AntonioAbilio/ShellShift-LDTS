package com.l06g06.shellshift.viewers;

import com.l06g06.shellshift.Components;
import com.l06g06.shellshift.Database;
import com.l06g06.shellshift.gui.Gui;
import com.l06g06.shellshift.model.game.elements.Chell;
import com.l06g06.shellshift.model.game.elements.Position;
import com.l06g06.shellshift.viewer.game.ChellViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ChellViewerTest {
    private Chell chell;
    private ChellViewer viewer;
    private Gui gui;

    @BeforeEach
    void setUp(){
        Database.getInstance().setSound(true);
        chell = new Chell(new Position(10,10));
        viewer = new ChellViewer();
        gui = Mockito.mock(Gui.class);
    }

    @Test
    void drawChell(){
        chell.setDirection(true);
        Position new_Pos = new Position(-4, -4); // Due to the drawing offset
        viewer.draw(chell, gui);
        Mockito.verify(gui, Mockito.times(1)).drawImageASCII(Components.Chell.getImage(), new_Pos);
    }
}
