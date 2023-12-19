package com.l06g06.shellshift.viewers;

import com.l06g06.shellshift.Components;
import com.l06g06.shellshift.gui.Gui;
import com.l06g06.shellshift.model.game.elements.Position;
import com.l06g06.shellshift.model.game.elements.powerups.PowerUp;
import com.l06g06.shellshift.viewer.game.PowerUpViewer;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.ArgumentMatchers.eq;

public class PowerupViewerTest {
    private PowerUp powerup;
    private PowerUpViewer viewer;
    private Gui gui;
    /*
    @BeforeEach
    void setUp(){
        powerup = new PowerUp(new Position(10, 10));
        viewer = new PowerupViewer();
        gui = Mockito.mock(Gui.class);
    }
     */

    @Test
    void drawPowerup(){
        //viewer.draw(powerup, gui);
        // Method does not exist
        //Mockito.verify(gui, Mockito.times(1)).drawPowerup(powerup.getPosition());
    }
}
