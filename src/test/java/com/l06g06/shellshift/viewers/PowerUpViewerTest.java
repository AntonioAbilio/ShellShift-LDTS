package com.l06g06.shellshift.viewers;
import com.l06g06.shellshift.Components;
import com.l06g06.shellshift.gui.Gui;
import com.l06g06.shellshift.model.game.elements.Position;
import com.l06g06.shellshift.model.game.elements.powerups.BulletPowerUp;
import com.l06g06.shellshift.model.game.elements.powerups.PowerUp;
import com.l06g06.shellshift.model.game.elements.powerups.SpeedPowerUp;
import com.l06g06.shellshift.model.game.elements.powerups.StarPowerUp;
import com.l06g06.shellshift.viewer.game.PowerUpViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

public class PowerUpViewerTest {
    private PowerUpViewer powerUpViewer;
    private Gui gui;

    @BeforeEach
    void setUp() {
        powerUpViewer = new PowerUpViewer();
        gui = Mockito.mock(Gui.class);
    }

    @Test
    void drawSpeedPowerUp() {
        Position pos = new Position(0,0);
        PowerUp speedPowerUp = new SpeedPowerUp(pos);
        powerUpViewer.draw(speedPowerUp, gui);

        verify(gui, times(1)).drawImageASCII(eq(Components.SpeedPowerUp.getImage()), eq(speedPowerUp.getPosition()));
        verify(gui, times(0)).drawImageASCII(eq(Components.StarPowerUp.getImage()), Mockito.any(Position.class));
        verify(gui, times(0)).drawImageASCII(eq(Components.BulletPowerUp.getImage()), Mockito.any(Position.class));
    }

    @Test
    void drawStarPowerUp() {
        Position pos = new Position(0,0);
        PowerUp starPowerUp = new StarPowerUp(pos);
        powerUpViewer.draw(starPowerUp, gui);

        verify(gui, times(0)).drawImageASCII(eq(Components.SpeedPowerUp.getImage()), Mockito.any(Position.class));
        verify(gui, times(1)).drawImageASCII(eq(Components.StarPowerUp.getImage()), eq(starPowerUp.getPosition()));
        verify(gui, times(0)).drawImageASCII(eq(Components.BulletPowerUp.getImage()), Mockito.any(Position.class)); }

    @Test
    void drawBulletPowerUp() {
        Position pos = new Position(0,0);
        PowerUp bulletPowerUp = new BulletPowerUp(pos);
        powerUpViewer.draw(bulletPowerUp, gui);

        verify(gui, times(0)).drawImageASCII(eq(Components.SpeedPowerUp.getImage()), Mockito.any(Position.class));
        verify(gui, times(0)).drawImageASCII(eq(Components.StarPowerUp.getImage()), Mockito.any(Position.class));
        verify(gui, times(1)).drawImageASCII(eq(Components.BulletPowerUp.getImage()), eq(bulletPowerUp.getPosition()));
    }

}
