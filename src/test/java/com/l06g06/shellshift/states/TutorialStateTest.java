package com.l06g06.shellshift.states;

import com.l06g06.shellshift.Database;
import com.l06g06.shellshift.controller.Controller;
import com.l06g06.shellshift.controller.menus.TutorialController;
import com.l06g06.shellshift.model.tutorial.TutorialMap;
import com.l06g06.shellshift.viewer.View;
import com.l06g06.shellshift.viewer.tutorial.TutorialViewer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;

public class TutorialStateTest {

    private TutorialState tutorialState;
    private TutorialMap tutorialMap;

    @BeforeEach
    public void setUp(){
        Database.getInstance().setSound(true);
        tutorialMap = mock(TutorialMap.class);
        tutorialState = new TutorialState(tutorialMap);
    }

    @Test
    public void viewerGetter(){
        View<TutorialMap> tutorialViewer = tutorialState.getViewer();
        Assertions.assertTrue(tutorialViewer instanceof TutorialViewer);
        Assertions.assertNotNull(tutorialViewer);
    }

    @Test
    public void controllerGetter(){
        Controller<TutorialMap> tutorialController = tutorialState.getController();
        Assertions.assertTrue(tutorialController instanceof TutorialController);
        Assertions.assertNotNull(tutorialController);
    }
}
