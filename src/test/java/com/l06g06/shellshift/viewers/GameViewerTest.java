/*
package com.l06g06.shellshift.viewers;

import com.l06g06.shellshift.Components;
import com.l06g06.shellshift.gui.Gui;
import com.l06g06.shellshift.model.game.elements.*;
import com.l06g06.shellshift.model.game.elements.enemies.Enemy;
import com.l06g06.shellshift.model.game.elements.enemies.HardMonster;
import com.l06g06.shellshift.model.game.elements.enemies.SoftMonster;
import com.l06g06.shellshift.model.game.elements.enemies.moveStrategies.HorizontalMoveStrategy;
import com.l06g06.shellshift.model.game.elements.enemies.moveStrategies.VerticalMoveStrategy;
import com.l06g06.shellshift.model.game.gun.FireStrategy;
import com.l06g06.shellshift.model.game.gun.Gun;
import com.l06g06.shellshift.model.game.map.Map;
import com.l06g06.shellshift.model.mainmenu.MainMenu;
import com.l06g06.shellshift.viewer.game.GameViewer;
import com.l06g06.shellshift.viewer.mainMenu.MainMenuViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.awt.*;
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
    private List<Platform> platforms;
    private List<Coin> coins;
    private List<Enemy> enemies;
    private VerticalMoveStrategy moveVerticallyStrategy;
    private HorizontalMoveStrategy moveHorizontallyStrategy;
    private Chell chell;
    private Gun gun;

    @BeforeEach
    void setUp(){
        map = Mockito.mock(Map.class);
        gui = Mockito.mock(Gui.class);

        gun = Mockito.mock(Gun.class);
        when(gun.getNumBullets()).thenReturn(10000);
        when(gun.getReloadTime()).thenReturn(0.0);
        when(gun.getFireStrategy()).thenReturn(Mockito.mock(FireStrategy.class));



        Position mockPosition = Mockito.mock(Position.class);
        chell = Mockito.mock(chell);
        when(chell.getGun()).thenReturn(gun);
        when(chell.getLives()).thenReturn(5);
        when(chell.isDirection()).thenReturn(true);
        when(chell.getPosition()).thenReturn(new Position(80,80));
        //when(chell.getVelocity()).thenReturn(200F);
        //when(chell.getPolygon()).thenReturn(new Polygon());
        chell = new Chell(mockPosition);




        moveVerticallyStrategy = Mockito.mock(VerticalMoveStrategy.class);
        moveHorizontallyStrategy = Mockito.mock(HorizontalMoveStrategy.class);

        gameViewer = new GameViewer(map);

        this.bullets = Arrays.asList(
                new Bullet(new Position(1, 2)),
                new Bullet(new Position(12, 22))
        );

        this.platforms = Arrays.asList(
                new Platform(new Position(1, 5)),
                new Platform((new Position(4, 6)))
        );

        this.coins = Arrays.asList(
                new Coin(new Position(7, 1)),
                new Coin(new Position(0, 0))
        );

        this.enemies = Arrays.asList(
                new SoftMonster(new Position(1,2), moveVerticallyStrategy),
                new SoftMonster(new Position(5,6), moveHorizontallyStrategy),
                new HardMonster(new Position(20,20), moveVerticallyStrategy),
                new HardMonster(new Position(30,30), moveHorizontallyStrategy)
        );

        map.setEnemies(enemies);
        map.setPlatforms(platforms);
        map.setBullets(bullets);
        map.setChell(chell);
        map.setGun(gun);
        //map.setPowerups();
        //map.setScore();

        // Powerups

        when(map.getBullets()).thenReturn(bullets);
        when(map.getPlatforms()).thenReturn(platforms);
        when(map.getCoins()).thenReturn(coins);
        when(map.getEnemies()).thenReturn(enemies);
        when(map.getChell()).thenReturn(chell);
        when(map.getGun()).thenReturn(gun);
        //when(mockPosition.getX()).thenReturn(60);
        //when(mockPosition.getY()).thenReturn(60);
        // ToDo: more elements

    }

@Test
    void drawElementsTest() {

        GameViewer spyGameViewer = spy(gameViewer);
        spyGameViewer.drawElements(gui);

        // Verify that the draw method was called for each element type
        verify(gui, times(bullets.size())).drawImageASCII(any(), any());
        verify(gui, times(platforms.size())).drawImageASCII(any(), any());
        verify(gui, times(coins.size())).drawImageASCII(any(), any());
        verify(gui, times(enemies.size())).drawImageASCII(any(),any());



        // ToDo: more elements
    }

}
*/
