package com.l06g06.shellshift.controller.game;

import com.l06g06.shellshift.Database;
import com.l06g06.shellshift.Game;
import com.l06g06.shellshift.controller.game.MapController;
import com.l06g06.shellshift.controller.game.elements.PlatformController;
import com.l06g06.shellshift.gui.Gui;
import com.l06g06.shellshift.model.game.elements.*;
import com.l06g06.shellshift.model.game.map.Map;
import com.l06g06.shellshift.model.game.spawners.PlatformSpawner;
import net.jqwik.api.*;
import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.annotation.meta.When;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

public class PlatformControllerTest {
    private Map map ;
    private List<Platform>  platforms;
    private PlatformController platformController;

    private Game game;
    private List<Gui.PressedKey> action;

    @BeforeEach
    public void setup(){
        Database.getInstance().setSound(false);  // ToDo: Turn off sound on every test class
        this.map = mock(Map.class);
        this.platforms = new ArrayList<>();
        Mockito.when(map.getPlatforms()).thenReturn(platforms);
        this.platformController = new PlatformController(map);

        game = mock(Game.class);
        this.action = new ArrayList<>();

        Platform platform1 = new Platform(new Position(1,  0));
        Platform platform2 = new Platform(new Position(5, 5));
        Platform platform3 = new Platform(new Position(2, 9));
        platforms.add(platform1);
        platforms.add(platform2);
        platforms.add(platform3);
    }

    @Test
    public void leftShiftTest(){
        // Check if platforms are left shifting correctly
        platformController.left_shift();
        Position expectedPos1 = new Position(0, 0);
        Position expectedPos2 = new Position(4, 5);
        Position expectedPos3 = new Position(1, 9);
        Assertions.assertEquals(expectedPos1, platforms.get(0).getPosition());
        Assertions.assertEquals(expectedPos2, platforms.get(1).getPosition());
        Assertions.assertEquals(expectedPos3, platforms.get(2).getPosition());
    }

    @Test
    void stepShiftConditionTest(){
        Position chellPosition = new Position(3, 1);
        Chell chell = new Chell(chellPosition);
        Mockito.when(map.getChell()).thenReturn(chell);
        PlatformSpawner platformSpawner = mock(PlatformSpawner.class);
        when(map.getPlatformSpawner()).thenReturn(platformSpawner);
        long time1 = 79;
        long time2 = 80;
        long time3 = 81;
        platformController.setLastShiftTime(0);
        Mockito.when(map.getShiftCooldown()).thenReturn(0.08);

        try {
            platformController.step(game, action, time1);
            Assertions.assertEquals(0, platformController.getLastShiftTime());
            platformController.step(game, action, time2);
            Assertions.assertEquals(0.08, platformController.getLastShiftTime());
            PlatformController platformControllerSpy = spy(platformController);
            platformControllerSpy.setLastShiftTime(0);
            platformControllerSpy.step(game, action, time2);
            verify(platformControllerSpy, times(1)).left_shift();
            platformController.step(game, action, time3);
            Assertions.assertEquals(0.08, platformController.getLastShiftTime());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void stepSpawnConditionTest(){
        map = mock(Map.class);
        platformController = new PlatformController(map);
        Chell chell = new Chell(new Position(3, 1));
        when(map.getChell()).thenReturn(chell);
        PlatformSpawner platformSpawner = mock(PlatformSpawner.class);
        when(map.getPlatformSpawner()).thenReturn(platformSpawner);
        long time1 = 5999;
        long time2 = 6000;
        long time3 = 6001;
        platformController.setLastSpawnTime(0);
        when(map.getSpawnCooldown()).thenReturn(6);

        try {
            platformController.step(game, action, time1);
            Assertions.assertEquals(0, platformController.getLastSpawnTime());
            platformController.step(game, action, time2);
            Assertions.assertEquals(6, platformController.getLastSpawnTime());
            verify(platformSpawner, times(1)).spawn(any(Position.class));
            platformController.step(game, action, time3);
            Assertions.assertEquals(6, platformController.getLastSpawnTime());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
