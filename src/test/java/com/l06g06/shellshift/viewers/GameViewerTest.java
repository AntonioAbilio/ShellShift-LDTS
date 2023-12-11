package com.l06g06.shellshift.viewers;

import com.l06g06.shellshift.Components;
import com.l06g06.shellshift.gui.Gui;
import com.l06g06.shellshift.model.game.elements.Bullet;
import com.l06g06.shellshift.model.game.elements.Coin;
import com.l06g06.shellshift.model.game.elements.Platform;
import com.l06g06.shellshift.model.game.elements.Position;
import com.l06g06.shellshift.model.game.map.Map;
import com.l06g06.shellshift.model.mainmenu.MainMenu;
import com.l06g06.shellshift.viewer.game.GameViewer;
import com.l06g06.shellshift.viewer.mainMenu.MainMenuViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

public class GameViewerTest {
    private Map map;
    private GameViewer gameViewer;
    private Gui gui;
    private List<Bullet> bullets;
    List<Platform> platforms;
    List<Coin> coins;

    @BeforeEach
    void setUp(){
        map = Mockito.mock(Map.class);
        gameViewer = new GameViewer(map);
        gui = Mockito.mock(Gui.class);

        this.bullets = Arrays.asList(new Bullet(new Position(1, 2)), new Bullet(new Position(12, 22)));
        this.platforms = Arrays.asList(new Platform(new Position(1, 5)), new Platform((new Position(4, 6))));
        this.coins = Arrays.asList(new Coin(new Position(7, 1)), new Coin(new Position(0, 0)));

        when(map.getBullets()).thenReturn(bullets);
        when(map.getPlatforms()).thenReturn(platforms);
        when(map.getCoins()).thenReturn(coins);
        // ToDo: more elements

    }

    @Test
    void drawElementsTest() {
        /*gameViewer.drawElements(gui);

        // Verify that the draw method was called for each element type
        verify(gui, times(bullets.size())).drawImageASCII(any(), any());
        verify(gui, times(platforms.size())).drawImageASCII(any(), any());
        verify(gui, times(coins.size())).drawImageASCII(any(), any());*/
        // ToDo: more elements
    }
}
