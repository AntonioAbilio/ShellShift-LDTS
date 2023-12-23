package com.l06g06.shellshift.states;

import com.l06g06.shellshift.Database;
import com.l06g06.shellshift.controller.Controller;
import com.l06g06.shellshift.controller.menus.MainMenuController;
import com.l06g06.shellshift.model.mainmenu.MainMenu;
import com.l06g06.shellshift.viewer.View;
import com.l06g06.shellshift.viewer.mainMenu.MainMenuViewer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class MainMenuStateTest {
    private MainMenu mainMenu;
    private MainMenuState mainMenuState;

    @BeforeEach
    void setup(){
        Database.getInstance().setSound(true);
        mainMenu = Mockito.mock(MainMenu.class);
        mainMenuState = new MainMenuState(mainMenu);
    }

    @Test
    void getViewerTest(){
        View<MainMenu> viewer = mainMenuState.getViewer();
        Assertions.assertEquals(MainMenuViewer.class, viewer.getClass());
    }

    @Test
    void getControllerTest(){
        Controller<MainMenu> controller = mainMenuState.getController();
        Assertions.assertEquals(MainMenuController.class, controller.getClass());
    }
}
