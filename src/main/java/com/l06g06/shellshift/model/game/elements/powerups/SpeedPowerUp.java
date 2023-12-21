package com.l06g06.shellshift.model.game.elements.powerups;

import com.l06g06.shellshift.model.game.elements.Position;
import com.l06g06.shellshift.model.game.map.Map;

public class SpeedPowerUp extends PowerUp{
    public SpeedPowerUp(Position position) {
        super(position);
        this.setType("Speed");
    }

    @Override
    public void activate(Map map) {
        map.getActivePowerUp().addOrUpdateActivePowerUp(this.getType(),10000L);
        map.getChell().setHorizontalSpeedWithTimer(10000,2);
    }
}
