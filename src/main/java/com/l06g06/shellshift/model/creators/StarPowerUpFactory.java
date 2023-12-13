package com.l06g06.shellshift.model.creators;

import com.l06g06.shellshift.model.game.elements.Element;
import com.l06g06.shellshift.model.game.elements.Position;
import com.l06g06.shellshift.model.game.elements.powerups.StarPowerUp;

public class StarPowerUpFactory extends PowerUpFactory{
    @Override
    public Element create(Position position) {
        return new StarPowerUp(position);
    }
}
