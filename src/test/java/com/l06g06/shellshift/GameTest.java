/*
package com.l06g06.shellshift;

import com.l06g06.shellshift.gui.LanternaGUI;
import com.l06g06.shellshift.states.State;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

class GameTest {

    @Mock
    private State mockState;

    @Mock
    private LanternaGUI mockGui;

    @Mock
    private Sound mockSound;

    private Game game;

    @BeforeEach
    void setUp() throws IOException, URISyntaxException, FontFormatException {

         mockState = mock(State.class);
         mockGui = mock(LanternaGUI.class);
         mockSound = mock(Sound.class);

        game = new Game();
        game.setState(mockState);
        game.setGui(mockGui);
        Sound.setInstance(mockSound);
    }

    @Test
    void sleepTimeMS() {
        long sleepTime = 100; // milliseconds
        long tolerance = 10; // tolerance in milliseconds for sleep duration

        long startTime = System.currentTimeMillis();
        game.sleepTimeMS(sleepTime);
        long elapsedTime = System.currentTimeMillis() - startTime;

        assertTrue(elapsedTime >= sleepTime - tolerance);
        assertTrue(elapsedTime <= sleepTime + tolerance);

    }
}
*/
