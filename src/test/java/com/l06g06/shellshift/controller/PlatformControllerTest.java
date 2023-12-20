package com.l06g06.shellshift.controller;

import com.l06g06.shellshift.Game;
import com.l06g06.shellshift.controller.game.MapController;
import com.l06g06.shellshift.controller.game.elements.PlatformController;
import com.l06g06.shellshift.gui.Gui;
import com.l06g06.shellshift.model.game.elements.*;
import com.l06g06.shellshift.model.game.map.Map;
import net.jqwik.api.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;

public class PlatformControllerTest {
    private Map map ;
    private Platform platform;
    private List<Platform>  platforms;
    private PlatformController platformController;

    private Game game;
    private List<Gui.PressedKey> action;
    private long timeMillis;


    @BeforeEach
    public void setup(){
        this.map = mock(Map.class);
        this.platform = mock(Platform.class);
        this.platforms = new ArrayList<>();
        Mockito.when(map.getPlatforms()).thenReturn(platforms);
        this.platformController = new PlatformController(map);

        game = mock(Game.class);
        this.action = new ArrayList<>();
        timeMillis = 0;

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
    public void step(){

    }
}
