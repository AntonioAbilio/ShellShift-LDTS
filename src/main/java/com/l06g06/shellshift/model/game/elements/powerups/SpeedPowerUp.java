package com.l06g06.shellshift.model.game.elements.powerups;

import com.l06g06.shellshift.model.game.elements.Position;

public class SpeedPowerUp extends PowerUp{
    public SpeedPowerUp(Position position) {
        super(position);
    }

    @Override
    public void activate() {
        System.out.println("+SPEED");
    }
}
