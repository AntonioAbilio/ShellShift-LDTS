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
        Position position = new Position(0, 0);
        Chell mockedChell = new Chell(position);
        Mockito.when(map.getChell()).thenReturn(mockedChell);
        ChellController chellController = new ChellController(map);
        chellController.moveRIGHT();

        Position expected = new Position(1, 0);
        assertEquals(expected, mockedChell.getPosition());
    }

    @Test
    public void moveLeftTest(){
        Position position = new Position(0, 0);
        Chell mockedChell = new Chell(position);
        Mockito.when(map.getChell()).thenReturn(mockedChell);
        ChellController chellController = new ChellController(map);
        chellController.moveLEFT();

        Position expected = new Position(-1, 0);
        assertEquals(expected, mockedChell.getPosition());
    }

    @Property
    public void jumpTest(@ForAll int time){
        OptionsMenu options = new OptionsMenu();
        options.setSound(true);   // ToDo: uncomment

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
        // Arrange
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

        // Act
        chellController.jumpUpdate(time);

        // Assert
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


        System.out.println("is intersecting: " +  chellController.getModel().getChell().getPolygon().intersects(platform.getPolygon().getBounds2D()));

        // ToDo: remove
        /*
        int test_x_inf = -20;
        int test_x_sup = 20;
        int test_y_inf = -30;
        int test_y_sup = 30;

        for (int i = test_x_inf; i <= test_x_sup; i++) {
            for (int j = test_y_inf; j <= test_y_sup; j++) {
                // Update Chell's position
                chellController.getModel().getChell().setPosition(new Position(i, j));

                // Check for intersection
                if (chellController.getModel().getChell().getPolygon().intersects(chellController.getModel().getPlatforms().get(0).getPolygon().getBounds2D())) {
                    System.out.println("Intersection found at x: " + i + " y: " + j);
                }
            }
        }*/

        int groundY = (int) platform.getPolygon().getBounds().getMinY();

        chellController.lookForPlatformCollision();
        assertEquals(groundY - 2, map.getChell().getPosition().getY());
    }

    /*@Test
    void stepTest(){
        Game game = mock(Game.class);
        long time = System.currentTimeMillis();

        List<Gui.PressedKey> actions = Arrays.asList(Gui.PressedKey.UP);
        chellController.step(game, actions, time);

    }*/

}
