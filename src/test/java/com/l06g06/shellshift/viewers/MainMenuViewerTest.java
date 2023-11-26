package com.l06g06.shellshift.viewers;

import com.l06g06.shellshift.gui.Gui;
import com.l06g06.shellshift.model.game.elements.Position;
import com.l06g06.shellshift.model.mainmenu.MainMenu;
import com.l06g06.shellshift.viewer.mainMenu.MainMenuViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.fail;

public class MainMenuViewerTest {
    private MainMenu mainmenu;
    private MainMenuViewer viewer;
    private Gui gui;

    @BeforeEach
    void setUp(){
        mainmenu = Mockito.mock(MainMenu.class);
        viewer = new MainMenuViewer(mainmenu);
        gui = Mockito.mock(Gui.class);
    }

    @Test
    void drawMainMenu() {

        try {
            viewer.drawTest(gui);
            Mockito.verify(gui, Mockito.times(1)).drawText(Mockito.any(Position.class), Mockito.eq("ShellShift"), Mockito.eq("#FFFFFF"));
        } catch (IOException ioe) {
            fail("Caught the IOException: " + ioe.getMessage());
        }

    }
}
