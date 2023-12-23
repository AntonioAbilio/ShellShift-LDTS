package com.l06g06.shellshift.model.game.elements.powerups;

import com.l06g06.shellshift.model.game.elements.Position;
import com.l06g06.shellshift.model.game.map.Map;

public class BulletPowerUp extends PowerUp {
    public BulletPowerUp(Position position) {
        super(position);
        this.setType("Bullet");
    }

    @Override
    public void activate(Map map) {
        map.getGun().setNumBullets(map.getGun().getNumBullets() + 20);
    }
}
