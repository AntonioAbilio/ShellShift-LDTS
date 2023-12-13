package com.l06g06.shellshift.model.factories;

import com.l06g06.shellshift.model.game.elements.Element;
import com.l06g06.shellshift.model.game.elements.Position;
import com.l06g06.shellshift.model.game.elements.powerups.BulletPowerUp;

public class BulletPowerUpFactory extends PowerUpFactory{
    @Override
    public Element create(Position position) {
        return new BulletPowerUp(position);
    }
}
