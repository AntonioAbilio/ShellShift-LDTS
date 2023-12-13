package com.l06g06.shellshift.controller;

import com.l06g06.shellshift.controller.game.elements.ChellController;
import com.l06g06.shellshift.model.game.elements.Chell;
import com.l06g06.shellshift.model.game.elements.Platform;
import com.l06g06.shellshift.model.game.elements.Position;
import com.l06g06.shellshift.model.game.map.Map;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;


import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

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



}
