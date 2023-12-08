package com.l06g06.shellshift.controller.game.elements;

import com.l06g06.shellshift.Game;
import com.l06g06.shellshift.controller.game.GameController;
import com.l06g06.shellshift.gui.Gui;
import com.l06g06.shellshift.model.game.elements.Bullet;
import com.l06g06.shellshift.model.game.elements.Position;
import com.l06g06.shellshift.model.game.map.Map;

import java.util.List;


public class BulletController extends GameController {

    boolean isShooting;
    long reloadStartTime = 0;
    public BulletController(Map map) {
        super(map);
    }

    @Override
    public void step(Game game, List<Gui.PressedKey> action, long time) {
        for (Gui.PressedKey gpk : action) {
            switch (gpk) {
                case FIRE:
                    fire(time);
                    break;
            }
        }
        bulletUpdate();
    }

    private void fire(long time) {
        if (time - reloadStartTime >= getModel().getGun().getReloadTime() && getModel().getGun().getNumBullets() > 0){
            int x = getModel().getChell().getPosition().getX();
            int y = getModel().getChell().getPosition().getY();
            Bullet bullet = new Bullet(new Position(getModel().getChell().isDirection() ? x : x - 2, y - 8));
            bullet.setDirection(getModel().getChell().isDirection());
            getModel().addBullet(bullet);

            getModel().getGun().decreaseNumBullet();
            reloadStartTime = time;
        }
    }

    public void bulletUpdate(){
        for (Bullet bullet : getModel().getBullets()){
            int x = bullet.getPosition().getX();
            int y = bullet.getPosition().getY();

            bullet.setPosition(new Position(bullet.isDirection() ? x + 2 : x - 2, y));

        }
    }
}
