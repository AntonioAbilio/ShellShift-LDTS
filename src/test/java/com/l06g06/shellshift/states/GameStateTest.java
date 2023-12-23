package com.l06g06.shellshift.states;

import com.l06g06.shellshift.Database;
import com.l06g06.shellshift.controller.Controller;
import com.l06g06.shellshift.controller.game.MapController;
import com.l06g06.shellshift.model.game.elements.Chell;
import com.l06g06.shellshift.model.game.elements.Position;
import com.l06g06.shellshift.model.game.map.Map;
import com.l06g06.shellshift.viewer.View;
import com.l06g06.shellshift.viewer.game.GameViewer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.when;

public class GameStateTest {
    private Map map;
    private Chell chell;
    private GameState gameState;

    @BeforeEach
    void setup(){
        Database.getInstance().setSound(true);
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
