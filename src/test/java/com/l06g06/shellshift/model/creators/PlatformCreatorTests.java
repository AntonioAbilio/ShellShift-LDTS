package com.l06g06.shellshift.model.creators;

import com.l06g06.shellshift.Database;
import com.l06g06.shellshift.model.game.elements.Element;
import com.l06g06.shellshift.model.game.elements.Platform;
import com.l06g06.shellshift.model.game.elements.Position;
import net.jqwik.api.ForAll;
import net.jqwik.api.Property;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.security.SecureRandom;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PlatformCreatorTests {

    private PlatformCreator platformCreator;
    private SecureRandom mockSecureRandom;

    @Property
    void testCreateMethodWithAllSeeds(@ForAll int x, @ForAll int y) {
        Database.getInstance().setSound(true);
        platformCreator = new PlatformCreator();
        Element platform = platformCreator.create(new Position(x, y));
        Assertions.assertNotNull(platform);
        assertTrue(platform instanceof Platform);
        assertEquals(300, platform.getPosition().getX());

        // Additional assertions to check if the returned platform is one of the specified platforms
        int platformY = platform.getPosition().getY();
        assertTrue(platformY == 97 || platformY == 78 || platformY == 59 || platformY == 42 || platformY == 25);
    }

    @BeforeEach
    public void setUp(){
        Database.getInstance().setSound(true);
        platformCreator = new PlatformCreator();
    }

    @Test
    public void caseWhereNextLevelLessThan4(){
        mockSecureRandom = mock(SecureRandom.class);
        when(mockSecureRandom.nextInt(anyInt())).thenReturn(0);
        platformCreator.setSecureRandom(mockSecureRandom);
        platformCreator.setLastLevel(999);

        int ExpectedX = 300;
        int ExpectedY = 97;
        int ExpectedLastLevel = 0;
        int ExpectedNextLevel = 0;

        Platform platform = (Platform) platformCreator.create(new Position(0,0));

        Assertions.assertNotNull(platform);
        Assertions.assertEquals(ExpectedX, platform.getPosition().getX());
        Assertions.assertEquals(ExpectedY, platform.getPosition().getY());
        Assertions.assertEquals(ExpectedLastLevel, platformCreator.getLastLevel());
        Assertions.assertEquals(ExpectedNextLevel, platformCreator.getNextLevel());
    }

    @Test
    public void caseWhereNextLevelLessThan4IfCoverage(){
        mockSecureRandom = mock(SecureRandom.class);
        when(mockSecureRandom.nextInt(anyInt())).thenReturn(3);
        platformCreator.setSecureRandom(mockSecureRandom);
        platformCreator.create(new Position(0,0));
        platformCreator.setLastLevel(3);

        int ExpectedX = 300;
        int ExpectedY = 25;
        int ExpectedLastLevel = 4;
        int ExpectedNextLevel = 4;

        Platform platform = (Platform) platformCreator.create(new Position(0,0));

        Assertions.assertNotNull(platform);
        Assertions.assertEquals(ExpectedX, platform.getPosition().getX());
        Assertions.assertEquals(ExpectedY, platform.getPosition().getY());
        Assertions.assertEquals(ExpectedLastLevel, platformCreator.getLastLevel());
        Assertions.assertEquals(ExpectedNextLevel, platformCreator.getNextLevel());

    }

    @Test
    public void checkForPITReplacementsPt1(){
        platformCreator.setLastLevel(2);
        int ExpectedX = 300;
        int ExpectedY = 25;
        int ExpectedLastLevel = 4;
        int ExpectedNextLevel = 4;

        mockSecureRandom = mock(SecureRandom.class);
        when(mockSecureRandom.nextInt(anyInt())).thenAnswer(invocation -> {
            int argumentValue = invocation.getArgument(0);
            return argumentValue;
        });
        platformCreator.setSecureRandom(mockSecureRandom);

        Platform platform = (Platform) platformCreator.create(new Position(0,0));

        Assertions.assertNotNull(platform);
        Assertions.assertEquals(ExpectedLastLevel, platformCreator.getLastLevel());
        Assertions.assertEquals(ExpectedNextLevel, platformCreator.getNextLevel());
        Assertions.assertEquals(ExpectedX, platform.getPosition().getX());
        Assertions.assertEquals(ExpectedY, platform.getPosition().getY());
    }

    @Test
    public void checkForPITReplacementsPt2(){
        platformCreator.setLastLevel(3);
        int ExpectedX = 300;
        int ExpectedY = 25;
        int ExpectedLastLevel = 4;
        int ExpectedNextLevel = 4;

        mockSecureRandom = mock(SecureRandom.class);
        when(mockSecureRandom.nextInt(anyInt())).thenAnswer(invocation -> {
            int argumentValue = invocation.getArgument(0);
            return argumentValue;
        });
        platformCreator.setSecureRandom(mockSecureRandom);

        Platform platform = (Platform) platformCreator.create(new Position(0,0));

        Assertions.assertNotNull(platform);
        Assertions.assertEquals(ExpectedLastLevel, platformCreator.getLastLevel());
        Assertions.assertEquals(ExpectedNextLevel, platformCreator.getNextLevel());
        Assertions.assertEquals(ExpectedX, platform.getPosition().getX());
        Assertions.assertEquals(ExpectedY, platform.getPosition().getY());
    }
}
