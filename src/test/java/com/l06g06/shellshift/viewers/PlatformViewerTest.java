package com.l06g06.shellshift.viewers;

import com.l06g06.shellshift.Components;
import com.l06g06.shellshift.gui.Gui;
import com.l06g06.shellshift.model.game.elements.Platform;
import com.l06g06.shellshift.model.game.elements.Position;
import com.l06g06.shellshift.viewer.game.PlatformViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

public class PlatformViewerTest {
    private Platform platform;
    private PlatformViewer viewer;
    private Gui gui;

    @BeforeEach
    void setUp(){
        platform = new Platform(new Position(10,10));
        viewer = new PlatformViewer();
        gui = Mockito.mock(Gui.class);
    }

    @Test
    void drawPlatform(){
        viewer.draw(platform, gui);
        verify(gui, times(1)).drawImageASCII(eq(Components.Platform.getImage()), eq(new Position(10 - Platform.getWidth(), 10)));
    }


}
