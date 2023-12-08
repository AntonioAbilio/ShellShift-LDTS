package com.l06g06.shellshift.model.creators;

import com.l06g06.shellshift.model.game.elements.Element;
import com.l06g06.shellshift.model.game.elements.Position;
import com.l06g06.shellshift.model.game.elements.PowerUp;

public class PowerUpCreator extends Creator{
    @Override
    public Element create(Position position) {
        return new PowerUp(new Position(0,0));
    }
}
