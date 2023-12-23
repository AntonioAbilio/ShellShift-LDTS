package com.l06g06.shellshift.viewers;

import com.l06g06.shellshift.Components;
import com.l06g06.shellshift.Database;
import com.l06g06.shellshift.gui.Gui;
import com.l06g06.shellshift.model.game.elements.Cloud;
import com.l06g06.shellshift.model.game.elements.Position;
import com.l06g06.shellshift.viewer.game.CloudViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

public class CloudViewerTest {
    private CloudViewer cloudViewer;
    private Gui gui;

    @BeforeEach
    void setUp() {
        Database.getInstance().setSound(true);
        cloudViewer = new CloudViewer();
        gui = Mockito.mock(Gui.class);
    }

    @Test
    void drawCloud() {
        Position pos = new Position(0,0);
        Cloud cloud = new Cloud(pos);
        cloudViewer.draw(cloud, gui);

        verify(gui, times(1)).drawImageASCII(eq(Components.Cloud.getImage()), eq(cloud.getPosition()));
    }
}
