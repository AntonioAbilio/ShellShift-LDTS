package com.l06g06.shellshift.viewer.game;

import com.l06g06.shellshift.Components;
import com.l06g06.shellshift.gui.Gui;
import com.l06g06.shellshift.model.game.elements.Position;
import com.l06g06.shellshift.model.game.elements.powerups.BulletPowerUp;
import com.l06g06.shellshift.model.game.elements.powerups.PowerUp;
import com.l06g06.shellshift.model.game.elements.powerups.SpeedPowerUp;
import com.l06g06.shellshift.model.game.elements.powerups.StarPowerUp;

public class PowerUpViewer implements ElementViewer<PowerUp>{

    @Override
    public void draw(PowerUp element, Gui gui) {
        if (element instanceof SpeedPowerUp) gui.drawImageASCII(Components.SpeedPowerUp.getImage(), element.getPosition());
        if (element instanceof StarPowerUp) gui.drawImageASCII(Components.StarPowerUp.getImage(), element.getPosition());
        if (element instanceof BulletPowerUp) gui.drawImageASCII(Components.BulletPowerUp.getImage(), element.getPosition());
    }
}
