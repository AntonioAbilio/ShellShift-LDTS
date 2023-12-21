package com.l06g06.shellshift.controller.game;

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
import net.jqwik.api.ForAll;
import net.jqwik.api.Property;
import net.jqwik.api.constraints.IntRange;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.*;

public class MapControllerTest {
    // Things that happen before the actual game starts.
    private Game game;
    private List<Gui.PressedKey> action;
    private long addedScoreTimer = System.currentTimeMillis();

    // Things that happen after
    private Chell chell;
    private Map map;

    private ChellController chellController;
    private BulletController bulletController;
    private PlatformController platformController;
    private CoinController coinController;
    private EnemyController enemyController;
    private CloudController cloudController;
    private PowerUpController powerUpController;
    private ActivePowerUpController activePowerUpController;
    private MapController mapController;

    private int storeValueSpawn;
    private double storeValueShift;


    @BeforeEach
    public void setup() {
        this.addedScoreTimer = 0;
        this.game = mock(Game.class);
        this.action = new ArrayList<>();

        this.chell = mock(Chell.class);
        when(chell.getPosition()).thenReturn(new Position(50,50));

        this.map = mock(Map.class);
        when(map.getScore()).thenReturn(123);
        when(map.getCoinsCollected()).thenReturn(123);
        when(map.getMonstersKilled()).thenReturn(123);
        when(map.getChell()).thenReturn(chell);

        doAnswer(invocation -> {
            storeValueShift = invocation.getArgument(0);
            return null;
        }).when(map).setShiftCooldown(anyDouble());

        doAnswer(invocation -> {
            storeValueSpawn = invocation.getArgument(0);
            return null;
        }).when(map).setSpawnCooldown(anyInt());

        this.chellController = mock(ChellController.class);
        this.bulletController = mock(BulletController.class);
        this.platformController = mock(PlatformController.class);
        this.coinController = mock(CoinController.class);
        this.enemyController = mock(EnemyController.class);
        this.cloudController = mock(CloudController.class);
        this.powerUpController = mock(PowerUpController.class);
        this.activePowerUpController = mock(ActivePowerUpController.class);

        this.mapController = new MapController(map, chellController, bulletController, platformController,
                coinController, enemyController, cloudController, powerUpController, activePowerUpController,
                1000);
    }

    @Test
    public void updateAccelerationTest() {

        Assertions.assertEquals(false, mapController.isCheckpoint1());
        Assertions.assertEquals(false, mapController.isCheckpoint2());

        long elapsedTimeSinceGameStart = 30;
        mapController.updateAcceleration(elapsedTimeSinceGameStart);
        Assertions.assertEquals(true, mapController.isCheckpoint1());
        Assertions.assertEquals(false, mapController.isCheckpoint2());
        Assertions.assertEquals(0.05, storeValueShift);
        Assertions.assertEquals(4, storeValueSpawn);

        elapsedTimeSinceGameStart = 120;
        mapController.updateAcceleration(elapsedTimeSinceGameStart);
        Assertions.assertEquals(true, mapController.isCheckpoint1());
        Assertions.assertEquals(true, mapController.isCheckpoint2());
        Assertions.assertEquals(0.03, storeValueShift);
        Assertions.assertEquals(3, storeValueSpawn);
    }

    @SuppressWarnings("DirectInvocationOnMock")
    @Test
    public void stepWithoutGameOver(){
        when(chell.getLives()).thenReturn(5);
        try {
            mapController.step(game, action, addedScoreTimer);
            verify(chellController).step(game, action, addedScoreTimer);
            verify(bulletController).step(game, action, addedScoreTimer);
            verify(platformController).step(game, action, addedScoreTimer);
            verify(coinController).step(game, action, addedScoreTimer);
            verify(enemyController).step(game, action, addedScoreTimer);
            verify(cloudController).step(game, action, addedScoreTimer);
            verify(powerUpController).step(game, action, addedScoreTimer);
            verify(activePowerUpController).step(game, action, addedScoreTimer);
            verify(map, Mockito.times(1)).getScore();
            verify(map, Mockito.times(1)).setScore(eq(124));
            verify(game, never()).setState(Mockito.any(GameOverState.class));
            verify(map, never()).stopCloudAddingTask();
        } catch (Exception e){
            System.out.println(e.getMessage());
            fail();
        }
    }

    @SuppressWarnings("DirectInvocationOnMock")
    @Test
    public void stepWithGameOver(){
        when(chell.getLives()).thenReturn(0);
        try {
            mapController.step(game, action, addedScoreTimer);
            verify(chellController).step(game, action, addedScoreTimer);
            verify(bulletController).step(game, action, addedScoreTimer);
            verify(platformController).step(game, action, addedScoreTimer);
            verify(coinController).step(game, action, addedScoreTimer);
            verify(enemyController).step(game, action, addedScoreTimer);
            verify(cloudController).step(game, action, addedScoreTimer);
            verify(powerUpController).step(game, action, addedScoreTimer);
            verify(activePowerUpController).step(game, action, addedScoreTimer);
            verify(map, Mockito.times(2)).getScore();
            verify(map, Mockito.times(1)).setScore(eq(124));
            verify(game).setState(any(GameOverState.class));
            verify(map).stopCloudAddingTask();
        } catch (Exception e){
            System.out.println(e.getMessage());
            fail();
        }
    }

    @Property
    public void gameOverPositionDetectionTest(@ForAll @IntRange(max = 0) int x, @ForAll @IntRange(min = 150) int y){
        Chell chell = mock(Chell.class);
        when(chell.getPosition()).thenReturn(new Position(x,y));

        Map map = new Map();
        map.setChell(chell);

        MapController mapContrl = new MapController(map);

        Assertions.assertTrue(mapContrl.isGameOver());

    }

    @Property
    public void gameOverLivesDetectionTest(@ForAll @IntRange(max = 0) int lives){
        Chell chell = mock(Chell.class);
        when(chell.getPosition()).thenReturn(new Position(50,50));
        when(chell.getLives()).thenReturn(lives);

        Map map = new Map();
        map.setChell(chell);

        MapController mapContrl = new MapController(map);

        Assertions.assertTrue(mapContrl.isGameOver());

    }

    @Property
    public void updateDatabaseTest(@ForAll @IntRange(max = 999999) int score, @ForAll @IntRange(max = 999) int coins, @ForAll @IntRange(max = 19999) int monstersKilled) {
        this.chell = mock(Chell.class);
        when(chell.getPosition()).thenReturn(new Position(50,50));

        this.map = mock(Map.class);
        when(map.getScore()).thenReturn(score);
        when(map.getCoinsCollected()).thenReturn(coins);
        when(map.getMonstersKilled()).thenReturn(monstersKilled);
        when(map.getChell()).thenReturn(chell);

        Database database = mock(Database.class);
        Database.setInstance(database);

        MapController mapCtrl = new MapController(map);
        mapCtrl.updateDatabase();

        verify(database).addScore(score);
        verify(database).addCoins(coins);
        verify(database).addMonstersKilled(monstersKilled);
    }

}
