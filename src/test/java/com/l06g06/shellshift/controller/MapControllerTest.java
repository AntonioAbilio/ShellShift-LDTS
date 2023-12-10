package com.l06g06.shellshift.controller;

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
    private GunController gunController;
    private PlatformController platformController;
    private CoinController coinController;
    private EnemyController enemyController;


    @BeforeEach
    public void setup(){
        this.addedScoreTimer = 0;
        this.map = mock(Map.class);
        this.game = mock(Game.class);
        this.action = new ArrayList<>();
        this.chellController = mock(ChellController.class);
        this.bulletController = mock(BulletController.class);
        this.gunController = mock(GunController.class);
        this.platformController = mock(PlatformController.class);
        this.coinController = mock(CoinController.class);
        this.enemyController = mock(EnemyController.class);

        // ToDo: find a way to inject Controllers into MapController
        //this.mapController = new MapController(map);
    }


    @Test
    public void stepCallTest() throws IOException {
        //mapController.step(game, action, 0);
        //verify(enemyController, Mockito.times(1)).step(game, action, 0);
        // ToDo
        Assertions.assertEquals(1, 2);
    }

}
