package com.l06g06.shellshift.controller.game;

import com.l06g06.shellshift.Database;
import com.l06g06.shellshift.Game;
import com.l06g06.shellshift.controller.game.GameController;
import com.l06g06.shellshift.controller.game.elements.ChellController;
import com.l06g06.shellshift.gui.Gui;
import com.l06g06.shellshift.model.game.elements.Chell;
import com.l06g06.shellshift.model.game.elements.Platform;
import com.l06g06.shellshift.model.game.elements.Position;
import com.l06g06.shellshift.model.game.map.Map;
import com.l06g06.shellshift.model.optionsMenu.OptionsMenu;
import net.jqwik.api.Data;
import net.jqwik.api.ForAll;
import net.jqwik.api.Property;
import net.jqwik.api.constraints.LongRange;
import org.checkerframework.checker.units.qual.A;
import org.checkerframework.checker.units.qual.C;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;


import javax.swing.text.html.Option;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ChellControllerTest {
    private Chell chell;
    private Map map ;
    private ChellController chellController;

    @BeforeEach
    public void setup(){
        this.chell = new Chell(new Position(0, 0));
        this.map = mock(Map.class);
        when(map.getChell()).thenReturn(chell);
        this.chellController = new ChellController(map);

    }

    @Test
    public void moveRightTest(){
        Chell chell = new Chell(new Position(0, 0));
        chell.setDirection(false);
        Mockito.when(map.getChell()).thenReturn(chell);
        ChellController chellController = new ChellController(map);
        chellController.moveRIGHT();

        Position expected = new Position(1, 0);
        assertEquals(expected, chell.getPosition());
        assertTrue(chell.isDirection());

        chell.setPosition(new Position(159, 0));
        chellController.moveRIGHT();
        Assertions.assertEquals(new Position(160, 0), chell.getPosition());

        chell.setPosition(new Position(160, 0));
        chellController.moveRIGHT();
        Assertions.assertEquals(new Position(160, 0), chell.getPosition());

        chell.setPosition(new Position(161, 0));
        chellController.moveRIGHT();
        Assertions.assertEquals(new Position(161, 0), chell.getPosition());
    }

    @Test
    public void moveLeftTest(){
        Chell chell = new Chell(new Position(0, 0));
        Assertions.assertTrue(chell.isDirection());
        Mockito.when(map.getChell()).thenReturn(chell);
        ChellController chellController = new ChellController(map);
        chellController.moveLEFT();

        Position expected = new Position(-1, 0);
        assertEquals(expected, chell.getPosition());
        assertFalse(chell.isDirection());
    }

    @Property
    public void jumpTest(@ForAll int time){
        this.chell = new Chell(new Position(0, 0));
        this.map = mock(Map.class);
        when(map.getChell()).thenReturn(chell);
        this.chellController = new ChellController(map);

        chellController.jump(time);
        assertTrue(chellController.isJumping());
        assertEquals(time, chellController.getJumpStartTime());
        assertFalse(chellController.isCanJump());
        assertEquals(chell.getPosition().getY(), chellController.getGroundY());
    }

    @Property
    void jumpUpdateTest(@ForAll @LongRange(min = 1, max = 665) long time)  {
        Map map = new Map();
        Chell chell = map.getChell();
        int initialX = chell.getPosition().getX();
        int initialY = chell.getPosition().getY();
        double velocity = chell.getVelocity();
        double gravity = chell.getGravity();
        long jumpStartTime = System.currentTimeMillis();
        time = jumpStartTime + time;
        chellController = new ChellController(map);
        chellController.setJumpStartTime(jumpStartTime);

        chellController.jumpUpdate(time);

        Assertions.assertEquals(initialX, chell.getPosition().getX());
        double elapsedTime = (time - jumpStartTime) / 1000.0;
        int expectedY = (int) (initialY - (velocity * elapsedTime - 0.5 * gravity * elapsedTime * elapsedTime));
        Assertions.assertEquals(expectedY, chell.getPosition().getY());
    }

    @Test
    void leftShiftTest(){
        chell.setPosition(new Position(20, 20));
        chellController.left_shift();
        assertEquals(new Position(19, 20), chell.getPosition());

        chellController.left_shift();
        chellController.left_shift();
        assertEquals(new Position(17, 20), chell.getPosition());
    }

    @Test
    void lookForPlatformCollisionTest(){
        Map map = new Map();
        List<Platform> platforms = new ArrayList<>(0);
        Platform platform = new Platform(new Position(0, 0));
        platforms.add(platform);
        map.setPlatforms(platforms);    // Map is initialized with one platform

        Chell chell = new Chell(new Position(-11, 16));
        map.setChell(chell);


        chellController = new ChellController(map);

        int groundY = (int) platform.getPolygon().getBounds().getMinY();

        chellController.lookForPlatformCollision();
        assertEquals(groundY - 2, map.getChell().getPosition().getY());
        Assertions.assertFalse(chellController.isJumping());
    }

    @Test
    void stepTest(){
        Game game = mock(Game.class);
        long time = System.currentTimeMillis();

        List<Gui.PressedKey> actions = new ArrayList<>();

        chellController.setJumping(true);
        chellController.setCanJump(false);
        chellController.step(game, actions, time);
        Assertions.assertTrue(chellController.isCanJump());
    }

    @Test
    void inputTest(){
        Game game = mock(Game.class);
        long time = System.currentTimeMillis();

        List<Gui.PressedKey> actions = Arrays.asList(Gui.PressedKey.UP);
        chellController.setJumping(false);
        chellController.setCanJump(true);
        chellController.setGroundY(20);
        chellController.step(game, actions, time);
        Assertions.assertEquals(20, chellController.getGroundY());
        Assertions.assertFalse(chellController.isCanJump());

        actions = Arrays.asList(Gui.PressedKey.LEFT);
        chell.setPosition(new Position(40, 40));
        chellController.step(game, actions, time);
        Assertions.assertEquals(40 - 1 - 1, chell.getPosition().getX()); // Chell moves and shifts to the left

        actions = Arrays.asList(Gui.PressedKey.RIGHT);
        chell.setPosition(new Position(40, 40));
        chellController.step(game, actions, time);
        Assertions.assertEquals(40 + 1 - 1, chell.getPosition().getX()); // Chell moves to the right and shifts to the left
    }

    @Test
    void checkLandingTest(){
        map = new Map();
        chell = new Chell(new Position(20, 20));
        chellController = new ChellController(map);
        chellController.setJumping(false);
        chellController.setCanJump(true);
        chellController.checkLanding();
        map.setChell(chell);

        ChellController chellControllerSpy = spy(chellController);
        chellControllerSpy.checkLanding();
        verify(chellControllerSpy, times(1)).lookForPlatformCollision();
        int y = (int) (map.getChell().getPosition().getY() + (map.getChell().getVelocity() * 0.01 - 0.5 * map.getChell().getGravity() * 0.001));
        Assertions.assertEquals(y - 2, chell.getPosition().getY());  // - 2 due to call to lookForPlatformCollision
        Assertions.assertFalse(chellController.isCanJump());
    }

}
