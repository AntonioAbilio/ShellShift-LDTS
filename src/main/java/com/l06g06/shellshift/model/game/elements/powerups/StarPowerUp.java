package com.l06g06.shellshift.model.game.elements.powerups;

import com.l06g06.shellshift.model.game.elements.Position;
import com.l06g06.shellshift.model.game.map.Map;

public class StarPowerUp extends PowerUp{
    public StarPowerUp(Position position) {
        super(position);
        this.setType("Star");
    }

    @Override
    public void activate(Map map) {
        map.getActivePowerUp().addOrUpdateActivePowerUp(this.getType(), 10000L);
        map.getChell().setInvincibilityEndTime(10000);
        map.getChell().setHorizontalSpeedWithTimer(10000,2);
        //map.getGun().setNumBullets(map.getGun().getNumBullets() + 50);
    }
}
