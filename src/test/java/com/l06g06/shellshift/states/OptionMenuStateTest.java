package com.l06g06.shellshift.states;

import com.l06g06.shellshift.Database;
import com.l06g06.shellshift.controller.Controller;
import com.l06g06.shellshift.controller.menus.OptionsMenuController;
import com.l06g06.shellshift.model.optionsMenu.OptionsMenu;
import com.l06g06.shellshift.viewer.View;
import com.l06g06.shellshift.viewer.optionsMenu.OptionsMenuViewer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;

public class OptionMenuStateTest {

    private OptionsMenu optionsMenu;
    private OptionsMenuState optionsMenuState;

    @BeforeEach
    public void setUp(){
        Database.getInstance().setSound(true);
        optionsMenu = mock(OptionsMenu.class);
        optionsMenuState = new OptionsMenuState(optionsMenu);
    }

    @Test
    public void viewerGetter(){
        View<OptionsMenu> tutorialViewer = optionsMenuState.getViewer();
        Assertions.assertTrue(tutorialViewer instanceof OptionsMenuViewer);
        Assertions.assertNotNull(tutorialViewer);
    }

    @Test
    public void controllerGetter(){
        Controller<OptionsMenu> tutorialController = optionsMenuState.getController();
        Assertions.assertTrue(tutorialController instanceof OptionsMenuController);
        Assertions.assertNotNull(tutorialController);
    }

}
