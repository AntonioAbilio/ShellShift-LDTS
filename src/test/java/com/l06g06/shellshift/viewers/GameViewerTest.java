package com.l06g06.shellshift.viewers;

import com.l06g06.shellshift.Components;
import com.l06g06.shellshift.Database;
import com.l06g06.shellshift.gui.Gui;
import com.l06g06.shellshift.model.game.elements.*;
import com.l06g06.shellshift.model.game.elements.enemies.Enemy;
import com.l06g06.shellshift.model.game.elements.enemies.HardMonster;
import com.l06g06.shellshift.model.game.elements.enemies.SoftMonster;
import com.l06g06.shellshift.model.game.elements.enemies.moveStrategies.HorizontalMoveStrategy;
import com.l06g06.shellshift.model.game.elements.powerups.ActivePowerUp;
import com.l06g06.shellshift.model.game.elements.powerups.PowerUp;
import com.l06g06.shellshift.model.game.elements.powerups.StarPowerUp;
import com.l06g06.shellshift.model.game.gun.Gun;
import com.l06g06.shellshift.model.game.gun.NormalFireStrategy;
import com.l06g06.shellshift.model.game.map.Map;
import com.l06g06.shellshift.viewer.game.GameViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

public class GameViewerTest {
    private Map map;
    private GameViewer gameViewer;
    private Gui gui;
    @BeforeEach
    void setUp() {
        Database.getInstance().setSound(true);
        map = mock(Map.class);
        gui = mock(Gui.class);

        Position pos = new Position(0,0);
        Chell chell = new Chell(pos);
        Gun gun = new Gun(new NormalFireStrategy());

        when(map.getChell()).thenReturn(chell);
        when(map.getGun()).thenReturn(gun);
        when(map.getActivePowerUp()).thenReturn(new ActivePowerUp());
        gameViewer = new GameViewer(map);

    }

    @Test
    @SuppressWarnings("DirectInvocationOnMock")
    void drawHUD() {
        gameViewer.drawElements(gui);
        int numLives = map.getChell().getLives();

        verify(gui, times(1)).setBackground(any(String.class));

        verify(gui, times(numLives)).drawImageASCII(eq(Components.HeartIcon.getImageSelected()), any(Position.class));

        verify(gui, times(1)).drawImageASCII(eq(Components.Score.getImage()), any(Position.class));
        verify(gui, times(1)).drawImageASCII(eq(Components.Bullet.getImage()), any(Position.class));
        verify(gui, times(1)).drawImageASCII(eq(Components.Coin.getImageSelected()), any(Position.class));
        verify(gui, times(3)).numToASCII(anyInt(),anyInt(),anyInt());
    }

    @Test
    void drawActiveStarPowerUp() {
        ActivePowerUp activePowerUp = new ActivePowerUp();
        activePowerUp.addOrUpdateActivePowerUp("Star", 10000L);
        when(map.getActivePowerUp()).thenReturn(activePowerUp);

        gameViewer.drawElements(gui);

        verify(gui, times(1)).drawImageASCII(eq(Components.ReducedStarComponent.getImage()), any(Position.class));
    }

    @Test
    void drawActiveSpeedPowerUp() {
        ActivePowerUp activePowerUp = new ActivePowerUp();
        activePowerUp.addOrUpdateActivePowerUp("Speed", 10000L);
        when(map.getActivePowerUp()).thenReturn(activePowerUp);

        gameViewer.drawElements(gui);

        verify(gui, times(1)).drawImageASCII(eq(Components.ReducedSpeedComponent.getImage()), any(Position.class));
    }

    @Test
    void drawActiveStarAndSpeedPowerUp() {
        ActivePowerUp mockActivePowerUp = new ActivePowerUp();
        mockActivePowerUp.addOrUpdateActivePowerUp("Speed", 10000L);
        mockActivePowerUp.addOrUpdateActivePowerUp("Star", 10000L);
        when(map.getActivePowerUp()).thenReturn(mockActivePowerUp);

        gameViewer.drawElements(gui);

        verify(gui, times(1)).drawImageASCII(eq(Components.ReducedSpeedComponent.getImage()), eq(new Position(71,89)));
        verify(gui, times(1)).drawImageASCII(eq(Components.ReducedStarComponent.getImage()),  eq(new Position(81,89)));

    }

    @Test
    void testDrawElements() {
        Position position = new Position(10, 10);
        Chell chell = new Chell(position);
        List<Cloud> clouds = List.of(new Cloud(position));
        List<Platform> platforms = List.of(new Platform(position));
        List<Bullet> bullets = List.of(new Bullet(position));
        List<Coin> coins = List.of(new Coin(position));
        List<PowerUp> powerUps = List.of(new StarPowerUp(position));
        List<Enemy> enemies = Arrays.asList(new SoftMonster(position, new HorizontalMoveStrategy()), new HardMonster(position, new HorizontalMoveStrategy()));

        when(map.getChell()).thenReturn(chell);
        when(map.getClouds()).thenReturn(clouds);
        when(map.getPlatforms()).thenReturn(platforms);
        when(map.getBullets()).thenReturn(bullets);
        when(map.getCoins()).thenReturn(coins);
        when(map.getPowerUps()).thenReturn(powerUps);
        when(map.getEnemies()).thenReturn(enemies);

        gameViewer.drawElements(gui);

        verify(gui,times(1)).drawImageASCII(eq(Components.Chell.getImage()), any(Position.class));
        verify(gui,times(1)).drawImageASCII(eq(Components.Cloud.getImage()), any(Position.class));
        verify(gui,times(1)).drawImageASCII(eq(Components.Platform.getImage()), any(Position.class));
        verify(gui,times(2)).drawImageASCII(eq(Components.Bullet.getImage()), any(Position.class)); // bullet adicionada + bullet counter
        verify(gui,times(1)).drawImageASCII(eq(Components.Coin.getImage()), any(Position.class));
        verify(gui,times(1)).drawImageASCII(eq(Components.StarPowerUp.getImage()), any(Position.class));
        verify(gui,times(1)).drawImageASCII(eq(Components.SoftMonster.getImage()), any(Position.class));
        verify(gui,times(1)).drawImageASCII(eq(Components.HardMonster.getImage()), any(Position.class));
    }
}

