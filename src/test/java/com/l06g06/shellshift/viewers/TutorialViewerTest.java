package com.l06g06.shellshift.viewers;

import com.l06g06.shellshift.Components;
import com.l06g06.shellshift.gui.Gui;
import com.l06g06.shellshift.model.game.elements.Chell;
import com.l06g06.shellshift.model.game.elements.Cloud;
import com.l06g06.shellshift.model.game.elements.Platform;
import com.l06g06.shellshift.model.game.elements.Position;
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
    }

    @Test
    void drawBasicElements() {
        Position pos = new Position(0,0);
        Chell chell = new Chell(pos);
        Platform platform = new Platform(pos);
        Gun gun = new Gun(new NormalFireStrategy());

        when(tutorial.getClouds()).thenReturn(Collections.emptyList());
        when(tutorial.getChell()).thenReturn(chell);
        when(tutorial.getGun()).thenReturn(gun);
        when(tutorial.getPlatform()).thenReturn(platform);
        when(tutorial.getBullets()).thenReturn(Collections.emptyList());
        when(tutorial.getCoins()).thenReturn(Collections.emptyList());
        when(tutorial.getEnemies()).thenReturn(Collections.emptyList());
        when(tutorial.isSelectedArrowUp()).thenReturn(true);
        when(tutorial.isSelectedArrowLeft()).thenReturn(true);
        when(tutorial.isSelectedArrowRight()).thenReturn(true);
        when(tutorial.isSelectedSpace()).thenReturn(true);
        //when(tutorial.getGun().getNumBullets()).thenReturn(10);
        //when(tutorial.getCoinsCollected()).thenReturn(5);

        tutorialViewer.drawElements(gui);

        verify(gui, times(1)).setBackground(Mockito.any(String.class));
        verify(gui, times(1)).drawImageASCII(Components.ArrowUp.getImageSelected(), Mockito.any(Position.class));
        verify(gui, times(1)).drawImageASCII(Components.ArrowLeft.getImageSelected(), Mockito.any(Position.class));
        verify(gui, times(1)).drawImageASCII(Components.ArrowRight.getImageSelected(), Mockito.any(Position.class));
        verify(gui, times(1)).drawImageASCII(Components.SpaceBar.getImageSelected(), Mockito.any(Position.class));
        verify(gui, times(1)).drawImageASCII(Components.Bullet.getImage(), Mockito.any(Position.class));
        //verify(gui, times(1)).numToASCII(eq(10), eq(142), eq(90));
        //verify(gui, times(1)).drawImageASCII(/* expected image for Coin */, eq(new Position(8, 90)));
        //verify(gui, times(1)).numToASCII(eq(5), eq(16), eq(91));
    }
}
