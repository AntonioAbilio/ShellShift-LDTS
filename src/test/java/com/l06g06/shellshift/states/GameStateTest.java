package com.l06g06.shellshift.states;

import com.l06g06.shellshift.controller.Controller;
import com.l06g06.shellshift.controller.game.GameController;
import com.l06g06.shellshift.controller.game.MapController;
import com.l06g06.shellshift.gui.Gui;
import com.l06g06.shellshift.model.game.elements.*;
import com.l06g06.shellshift.model.game.elements.enemies.Enemy;
import com.l06g06.shellshift.model.game.elements.enemies.moveStrategies.HorizontalMoveStrategy;
import com.l06g06.shellshift.model.game.elements.enemies.moveStrategies.VerticalMoveStrategy;
import com.l06g06.shellshift.model.game.gun.Gun;
import com.l06g06.shellshift.model.game.map.Map;
import com.l06g06.shellshift.viewer.View;
import com.l06g06.shellshift.viewer.game.GameViewer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.when;

public class GameStateTest {
    private Map map;
    private Chell chell;
    private GameState gameState;

    @BeforeEach
    void setup(){
        map = Mockito.mock(Map.class);
        chell = new Chell(new Position(0,0));
        when(map.getChell()).thenReturn(chell);
        gameState = new GameState(map);
    }

    @Test
    void getViewerTest(){
        View<Map> viewer = gameState.getViewer();

        Assertions.assertEquals(GameViewer.class, viewer.getClass());

    }

    @Test
    void getControllerTest(){
        Controller<Map> controller = gameState.getController();

        Assertions.assertEquals(MapController.class, controller.getClass());
    }

}
