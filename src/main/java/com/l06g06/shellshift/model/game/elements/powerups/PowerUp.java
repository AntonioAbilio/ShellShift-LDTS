package com.l06g06.shellshift.model.game.elements.powerups;

import com.l06g06.shellshift.model.game.elements.Element;
import com.l06g06.shellshift.model.game.elements.Position;

public abstract class PowerUp extends Element {
    public PowerUp(Position position) {
        super(position);
    }
    public abstract void activate();

}
