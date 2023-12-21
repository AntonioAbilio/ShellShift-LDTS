package com.l06g06.shellshift.viewers;

import com.l06g06.shellshift.Components;
import com.l06g06.shellshift.gui.Gui;
import com.l06g06.shellshift.model.game.elements.*;
import com.l06g06.shellshift.model.game.elements.enemies.Enemy;
import com.l06g06.shellshift.model.game.elements.enemies.HardMonster;
import com.l06g06.shellshift.model.game.elements.enemies.SoftMonster;
import com.l06g06.shellshift.model.game.elements.enemies.moveStrategies.HorizontalMoveStrategy;
import com.l06g06.shellshift.model.game.elements.enemies.moveStrategies.VerticalMoveStrategy;
import com.l06g06.shellshift.model.game.gun.Gun;
import com.l06g06.shellshift.model.game.gun.NormalFireStrategy;
import com.l06g06.shellshift.model.tutorial.TutorialMap;
import com.l06g06.shellshift.viewer.tutorial.TutorialViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.*;
public class TutorialViewerTest {
    private TutorialMap tutorial;
    private TutorialViewer tutorialViewer;
    private Gui gui;

    @BeforeEach
    void setUp(){
        tutorial = Mockito.mock(TutorialMap.class);
        tutorialViewer = new TutorialViewer(tutorial);
        gui = Mockito.mock(Gui.class);

        Position pos = new Position(0,0);
        Chell chell = new Chell(pos);
        Platform platform = new Platform(pos);
        Gun gun = new Gun(new NormalFireStrategy());

        when(tutorial.getClouds()).thenReturn(Collections.emptyList());
        when(tutorial.getChell()).thenReturn(chell);
        when(tutorial.getGun()).thenReturn(gun);
        when(tutorial.getPlatform()).thenReturn(platform);
    }

    @Test
    void drawHUD() {
        tutorialViewer.drawElements(gui);

        verify(gui, times(1)).setBackground(Mockito.any(String.class));
        verify(gui, times(1)).drawImageASCII(eq(Components.Chell.getImage()), Mockito.any(Position.class));
        verify(gui, times(1)).drawImageASCII(eq(Components.Platform.getImage()), Mockito.any(Position.class));

        verify(gui, times(1)).drawImageASCII(eq(Components.Bullet.getImage()), Mockito.any(Position.class));
        verify(gui, times(2)).numToASCII(anyInt(), anyInt(), anyInt());

        verify(gui, times(1)).drawImageASCII(eq(Components.Coin.getImageSelected()), Mockito.any(Position.class));
        //verify(gui, times(1)).numToASCII(eq(tutorial.getCoinsCollected()), anyInt(), anyInt());
    }

    @Test
    void drawKeysNonSelected() {
        when(tutorial.isSelectedArrowUp()).thenReturn(false);
        when(tutorial.isSelectedArrowLeft()).thenReturn(false);
        when(tutorial.isSelectedArrowRight()).thenReturn(false);
        when(tutorial.isSelectedSpace()).thenReturn(false);

        tutorialViewer.drawElements(gui);


        verify(gui, times(1)).drawImageASCII(eq(Components.ArrowUp.getImage()), Mockito.any(Position.class));
        verify(gui, times(1)).drawImageASCII(eq(Components.ArrowLeft.getImage()), Mockito.any(Position.class));
        verify(gui, times(1)).drawImageASCII(eq(Components.ArrowRight.getImage()), Mockito.any(Position.class));
        verify(gui, times(1)).drawImageASCII(eq(Components.SpaceBar.getImage()), Mockito.any(Position.class));

    }

    @Test
    void drawKeysSelected() {
        when(tutorial.isSelectedArrowUp()).thenReturn(true);
        when(tutorial.isSelectedArrowLeft()).thenReturn(true);
        when(tutorial.isSelectedArrowRight()).thenReturn(true);
        when(tutorial.isSelectedSpace()).thenReturn(true);

        tutorialViewer.drawElements(gui);

        verify(gui, times(1)).drawImageASCII(eq(Components.ArrowUp.getImageSelected()), Mockito.any(Position.class));
        verify(gui, times(1)).drawImageASCII(eq(Components.ArrowLeft.getImageSelected()), Mockito.any(Position.class));
        verify(gui, times(1)).drawImageASCII(eq(Components.ArrowRight.getImageSelected()), Mockito.any(Position.class));
        verify(gui, times(1)).drawImageASCII(eq(Components.SpaceBar.getImageSelected()), Mockito.any(Position.class));
    }
}
