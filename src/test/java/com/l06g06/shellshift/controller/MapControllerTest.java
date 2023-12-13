package com.l06g06.shellshift.controller;

import com.l06g06.shellshift.Database;
import com.l06g06.shellshift.Game;
import com.l06g06.shellshift.controller.game.MapController;
import com.l06g06.shellshift.controller.game.elements.*;
import com.l06g06.shellshift.controller.game.elements.enemies.EnemyController;
import com.l06g06.shellshift.gui.Gui;
import com.l06g06.shellshift.model.game.elements.Chell;
import com.l06g06.shellshift.model.game.elements.Position;
import com.l06g06.shellshift.model.game.map.Map;
import com.l06g06.shellshift.states.GameOverState;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import javax.xml.crypto.Data;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static net.jqwik.time.api.Times.times;
import static org.mockito.Mockito.*;

public class MapControllerTest {
    private MapController mapController;
    private Map map;
    private Game game;
    private List<Gui.PressedKey> action;
    private long addedScoreTimer = System.currentTimeMillis();
    private ChellController chellController;
    private BulletController bulletController;
    private PlatformController platformController;
    private CoinController coinController;
    private EnemyController enemyController;
    private CloudController cloudController;
    private PowerUpController powerUpController;


    @BeforeEach
    public void setup(){
        this.addedScoreTimer = 0;
        this.map = mock(Map.class);
        when(map.getChell()).thenReturn(new Chell(new Position(0, 0)));
        this.game = mock(Game.class);
        this.action = new ArrayList<>();
        this.chellController = new ChellController(map);
        this.bulletController = new BulletController(map);
        this.platformController = new PlatformController(map);
        this.coinController = new CoinController(map);
        this.enemyController = new EnemyController(map);
        this.cloudController = new CloudController(map);
        this.powerUpController = new PowerUpController(map);
        this.mapController = new MapController(map);
    }


    /*@Test
    public void stepCallTest() throws IOException {
        //mapController.step(game, action, 0);
        //verify(enemyController, Mockito.times(1)).step(game, action, 0);
        // ToDo
    }*/

    @Test
    public void updateAccelerationTest() {
        Assertions.assertEquals(false, mapController.isCheckpoint1());
        Assertions.assertEquals(false, mapController.isCheckpoint2());
        long elapsedTimeSinceGameStart = 30;
        mapController.updateAcceleration(elapsedTimeSinceGameStart);
        Assertions.assertEquals(true, mapController.isCheckpoint1());
        Assertions.assertEquals(false, mapController.isCheckpoint2());
        elapsedTimeSinceGameStart = 120;
        mapController.updateAcceleration(elapsedTimeSinceGameStart);
        Assertions.assertEquals(true, mapController.isCheckpoint1());
        Assertions.assertEquals(true, mapController.isCheckpoint2());
    }

}
