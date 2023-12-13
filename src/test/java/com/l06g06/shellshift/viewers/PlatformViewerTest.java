package com.l06g06.shellshift.viewers;

import com.l06g06.shellshift.gui.Gui;
import com.l06g06.shellshift.model.game.elements.Platform;
import com.l06g06.shellshift.model.game.elements.Position;
import com.l06g06.shellshift.viewer.game.PlatformViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

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
        // Method does not exist.
        //Mockito.verify(gui, Mockito.times(1)).drawPlatform(platform.getPosition());
    }


}
