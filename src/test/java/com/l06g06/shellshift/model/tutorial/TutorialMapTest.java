package com.l06g06.shellshift.model.tutorial;

import com.l06g06.shellshift.Database;
import com.l06g06.shellshift.model.game.elements.Cloud;
import com.l06g06.shellshift.model.game.elements.Platform;
import com.l06g06.shellshift.model.game.elements.PlatformTest;
import com.l06g06.shellshift.model.game.elements.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TutorialMapTest {
    private TutorialMap tutorialMap;

    @BeforeEach
    void setup(){
        Database.getInstance().setSound(true);
        this.tutorialMap = new TutorialMap();
    }

    @Test
    void getterTest(){
        List<Cloud> clouds = Arrays.asList(new Cloud(new Position(20, 20)));
        tutorialMap.setClouds(clouds);
        assertEquals(clouds, tutorialMap.getClouds());

        tutorialMap.setSelectedArrowLeft(false);
        assertFalse(tutorialMap.isSelectedArrowLeft());
        tutorialMap.setSelectedArrowRight(false);
        assertFalse(tutorialMap.isSelectedArrowRight());
        tutorialMap.setSelectedArrowUp(false);
        assertFalse(tutorialMap.isSelectedArrowUp());
        tutorialMap.setSelectedSpace(false);
        assertFalse(tutorialMap.isSelectedSpace());

        tutorialMap.setSelectedArrowLeft(true);
        assertTrue(tutorialMap.isSelectedArrowLeft());
        tutorialMap.setSelectedArrowRight(true);
        assertTrue(tutorialMap.isSelectedArrowRight());
        tutorialMap.setSelectedArrowUp(true);
        assertTrue(tutorialMap.isSelectedArrowUp());
        tutorialMap.setSelectedSpace(true);
        assertTrue(tutorialMap.isSelectedSpace());

        Platform platform = new Platform(new Position(20, 21));
        tutorialMap.setPlatform(platform);
        assertEquals(platform, tutorialMap.getPlatform());

        assertEquals(50, tutorialMap.getGun().getNumBullets());
    }
}
