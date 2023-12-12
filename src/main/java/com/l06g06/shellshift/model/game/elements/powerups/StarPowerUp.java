package com.l06g06.shellshift.model.game.elements.powerups;

import com.l06g06.shellshift.model.game.elements.Position;
import com.l06g06.shellshift.model.game.map.Map;

public class StarPowerUp extends PowerUp{
    public StarPowerUp(Position position) {
        super(position);
    }

    @Override
    public void activate(Map map) {
        map.getChell().activateInvincibility();
        map.getChell().setHorizontalSpeedWithTimer(2);
        map.getGun().setNumBullets(map.getGun().getNumBullets() + 50);
    }
}