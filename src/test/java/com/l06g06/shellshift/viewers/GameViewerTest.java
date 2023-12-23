package com.l06g06.shellshift.viewers;

import com.l06g06.shellshift.Components;
import com.l06g06.shellshift.gui.Gui;
import com.l06g06.shellshift.model.game.elements.Chell;
import com.l06g06.shellshift.model.game.elements.Position;
import com.l06g06.shellshift.model.game.elements.powerups.ActivePowerUp;
import com.l06g06.shellshift.model.game.gun.Gun;
import com.l06g06.shellshift.model.game.gun.NormalFireStrategy;
import com.l06g06.shellshift.model.game.map.Map;
import com.l06g06.shellshift.viewer.game.GameViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.mockito.Mockito.*;

public class GameViewerTest {
    private Map map;
    private GameViewer gameViewer;
    private Gui gui;
    @BeforeEach
    void setUp() {
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

        //acho q e preciso por @SuppressWarnings("DirectInvocationOnMock") nao acho q isto seja error prone neste caso
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
        ActivePowerUp activePowerUp = new ActivePowerUp();
        activePowerUp.addOrUpdateActivePowerUp("Speed", 10000L);
        activePowerUp.addOrUpdateActivePowerUp("Star", 10000L);
        when(map.getActivePowerUp()).thenReturn(activePowerUp);

        gameViewer.drawElements(gui);

        verify(gui, times(1)).drawImageASCII(eq(Components.ReducedStarComponent.getImage()), any(Position.class));
        verify(gui, times(1)).drawImageASCII(eq(Components.ReducedSpeedComponent.getImage()), any(Position.class));
    }

}

