package com.l06g06.shellshift.controller;

import com.googlecode.lanterna.input.KeyType;
import com.l06g06.shellshift.controller.game.elements.ChellController;
import com.l06g06.shellshift.gui.ListenForKeys;
import com.l06g06.shellshift.model.game.elements.Chell;
import com.l06g06.shellshift.model.game.elements.Position;
import com.l06g06.shellshift.model.game.map.Map;
import org.checkerframework.checker.units.qual.C;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.invocation.MockHandler;

import javax.swing.*;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;

public class ChellControllerTest {
    private Chell chell;
    private Map map ;
    private ChellController chellController;
    private List<KeyEvent> keyEventList;
    private KeyEvent right;
    private KeyEvent left;
    private KeyEvent up;
    private KeyEvent space;

    @BeforeEach
    public void setup(){
        this.chell = mock(Chell.class);
        this.map = mock(Map.class);
        this.chellController = mock(ChellController.class);
        this.keyEventList = new ArrayList<>();

        // ToDo: change this
        for(int k = 0; k < 256; k++){
            KeyEvent e = new KeyEvent(Mockito.mock(Component.class), 1, 20, 0,
                    k, KeyEvent.CHAR_UNDEFINED);
            keyEventList.add(e);
        }

        this.right = new KeyEvent(Mockito.mock(Component.class), 1, 20, 0,
                KeyEvent.VK_RIGHT, KeyEvent.CHAR_UNDEFINED);
        this.left = new KeyEvent(Mockito.mock(Component.class), 1, 20, 0,
                KeyEvent.VK_LEFT, KeyEvent.CHAR_UNDEFINED);
        this.up = new KeyEvent(Mockito.mock(Component.class), 1, 20, 0,
                KeyEvent.VK_UP, KeyEvent.CHAR_UNDEFINED);
        this.space = new KeyEvent(Mockito.mock(Component.class), 1, 20, 0,
                KeyEvent.VK_SPACE, ' ');
    }

    @Test
    public void moveRightTest(){
        Position position = new Position(0, 0);
        Chell mockedChell = new Chell(position);
        Mockito.when(map.getChell()).thenReturn(mockedChell);
        ChellController chellController = new ChellController(map);
        chellController.moveRIGHT();

        Position expected = new Position(1, 0);
        Assertions.assertEquals(expected, mockedChell.getPosition());
    }

    @Test
    public void moveLeftTest(){
        Position position = new Position(0, 0);
        Chell mockedChell = new Chell(position);
        Mockito.when(map.getChell()).thenReturn(mockedChell);
        ChellController chellController = new ChellController(map);
        chellController.moveLEFT();

        Position expected = new Position(-1, 0);
        Assertions.assertEquals(expected, mockedChell.getPosition());
    }

    @Test
    public void jumpTest(){
        // ToDo
    }

}
