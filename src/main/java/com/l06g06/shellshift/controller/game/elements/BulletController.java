package com.l06g06.shellshift.controller.game.elements;

import com.google.common.annotations.VisibleForTesting;
import com.l06g06.shellshift.Game;
import com.l06g06.shellshift.controller.game.GameController;
import com.l06g06.shellshift.gui.Gui;
import com.l06g06.shellshift.model.game.elements.Bullet;
import com.l06g06.shellshift.model.game.elements.Position;
import com.l06g06.shellshift.model.game.elements.enemies.Enemy;
import com.l06g06.shellshift.model.game.map.Map;

import java.util.Iterator;
import java.util.List;
import java.util.Objects;


public class BulletController extends GameController {

    long reloadStartTime = 0;
    public BulletController(Map map) {
        super(map);
    }

    @Override
    public void step(Game game, List<Gui.PressedKey> action, long time) {
        for (Gui.PressedKey gpk : action) {
            if (Objects.requireNonNull(gpk) == Gui.PressedKey.FIRE) {
                fire(time);
            }
        }
        bulletUpdate();
        bulletCollision();
        removeOutOfBoundsBullets();
    }

    private void fire(long time) {
        if (time - reloadStartTime >= getModel().getGun().getReloadTime() && getModel().getGun().getNumBullets() > 0){
            int x = getModel().getChell().getPosition().getX();
            int y = getModel().getChell().getPosition().getY();
            Bullet bullet = new Bullet(new Position(getModel().getChell().isDirection() ? x : x - 16, y - 6));
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

            bullet.setPosition(new Position(bullet.isDirection() ? x + 3 : x - 3, y));
        }
    }

    public void bulletCollision() {
        List<Bullet> bullets = getModel().getBullets();
        List<Enemy> enemies = getModel().getEnemies();

        Iterator<Enemy> enemyIterator = enemies.iterator();
        while (enemyIterator.hasNext()) {
            Enemy enemy = enemyIterator.next();

            Iterator<Bullet> bulletIterator = bullets.iterator();
            while (bulletIterator.hasNext()) {
                Bullet bullet = bulletIterator.next();
                if (bullet.getPolygon().intersects(enemy.getPolygon().getBounds2D())) {
                    bulletIterator.remove();
                    enemy.decreaseHP(bullet.getDamage());
                    if (enemy.getHP() <= 0) {
                        getModel().addMonsterKilled();
                        enemyIterator.remove();
                        getModel().setScore(getModel().getScore() + enemy.getScore());
                    }
                }
            }
        }
    }

    public void removeOutOfBoundsBullets(){
        List<Bullet> bullets = getModel().getBullets();
        Iterator<Bullet> it = bullets.iterator();
        while (it.hasNext()){
            Bullet bullet = it.next();
            if (bullet.getPosition().getX() < -5 || bullet.getPosition().getX() > 190){
                it.remove();
            }
        }
    }

    @VisibleForTesting
    public void setReloadStartTime(long reloadStartTime) {
        this.reloadStartTime = reloadStartTime;
    }

    @VisibleForTesting
    public long getReloadStartTime() {
        return reloadStartTime;
    }
}
