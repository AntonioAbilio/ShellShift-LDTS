package com.l06g06.shellshift.controller.menus;

import com.l06g06.shellshift.Game;
import com.l06g06.shellshift.Sound;
import com.l06g06.shellshift.controller.Controller;
import com.l06g06.shellshift.gui.Gui;
import com.l06g06.shellshift.model.game.elements.Bullet;
import com.l06g06.shellshift.model.game.elements.Cloud;
import com.l06g06.shellshift.model.game.elements.Coin;
import com.l06g06.shellshift.model.game.elements.Position;
import com.l06g06.shellshift.model.game.elements.enemies.Enemy;
import com.l06g06.shellshift.model.mainmenu.MainMenu;
import com.l06g06.shellshift.model.tutorial.TutorialMap;
import com.l06g06.shellshift.states.MainMenuState;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class TutorialController extends Controller<TutorialMap> {
    boolean isJumping;
    long jumpStartTime=0;
    int groundY;
    int previousY;
    long reloadStartTime = 0;
    double lastShiftTime = 0;
    double shiftCooldown = 0.08;
    boolean coinCheckpoint = false;
    boolean delayBackground = false;

    public TutorialController(TutorialMap model) {
        super(model);
    }
    @Override
    public void step(Game game, List<Gui.PressedKey> action, long time) throws IOException {
        for (Gui.PressedKey gpk : action) {
            switch (gpk) {
                case UP:
                    getModel().setSelectedArrowUp(true);
                    if (!isJumping) jump(time);
                    break;
                case LEFT:
                    getModel().setSelectedArrowLeft(true);
                    moveLeft();
                    break;
                case RIGHT:
                    getModel().setSelectedArrowRight(true);
                    moveRight();
                    break;
                case FIRE:
                    getModel().setSelectedSpace(true);
                    fire(time);
                    break;
            }
        }

        double currentTime = time / 1000.0; // Convert to seconds

        if (currentTime - lastShiftTime >= shiftCooldown){
            lastShiftTime = currentTime;
            leftShift();
        }
        if (isJumping) jumpUpdate(time);
        bulletUpdate();

        coinCollision();

        if (coinCheckpoint) {
            for (Enemy enemy : getModel().getEnemies()) {
                enemy.setPosition(enemy.getMoveStrategy().move(enemy.getPosition()));
            }

            bulletCollision();
        }

        if (getModel().getEnemies().size() <= 0){
            getModel().stopCloudAddingTask();
            Game.sleepTimeMS(100);
            game.setState(new MainMenuState(new MainMenu()));
        }
    }
    public void jump(long time){
        isJumping = true;
        jumpStartTime = time;
        groundY = getModel().getChell().getPosition().getY();
        Sound.playSound(Sound.SoundsFx.Jump);
    }

    public void jumpUpdate(long time) {
        int x = getModel().getChell().getPosition().getX();

        // Calculate the elapsed time since the jump started
        double elapsedTime = (time - jumpStartTime) / 1000.0; // Convert to seconds

        // Calculate the new position using the updated elapsed time
        int y = (int) (groundY - (getModel().getChell().getVelocity() * elapsedTime - 0.5 * getModel().getChell().getGravity() * elapsedTime * elapsedTime));

        System.out.println(y);

        // Update Chell's position;
        getModel().getChell().setPosition(new Position(x, y));

        // Check if Chell is moving up or down based on the change in position
        if (y < previousY) {
            System.out.println("Chell is going up");
        } else if (y > previousY) {
            System.out.println("Chell is falling");
        }

        previousY = y; // Update the previous Y position

        // Check if ground already reached
        if (getModel().getChell().getPosition().getY() >= groundY + 1) {
            System.out.println("True");
            isJumping = false;
            getModel().getChell().setPosition(new Position(getModel().getChell().getPosition().getX(), groundY)); // Ensure Chell is exactly at the ground level
        }
    }

    public void moveLeft(){
        getModel().getChell().setDirection(false);
        int x = getModel().getChell().getPosition().getX();
        int y = getModel().getChell().getPosition().getY();
        if (x > 25)
            getModel().getChell().setPosition(new Position(x-1,y));
    }

    public void moveRight(){
        int x = getModel().getChell().getPosition().getX();
        int y = getModel().getChell().getPosition().getY();
        getModel().getChell().setDirection(true);
        if (x < 81)
            getModel().getChell().setPosition(new Position(x+1,y));
    }

    private void fire(long time) {
        if (time - reloadStartTime >= getModel().getGun().getReloadTime() && getModel().getGun().getNumBullets() > 0) {
            int x = getModel().getChell().getPosition().getX();
            int y = getModel().getChell().getPosition().getY();
            Bullet bullet = new Bullet(new Position(getModel().getChell().isDirection() ? x : x - 16, y - 5));
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
                       enemyIterator.remove();
                    }
                }
            }
        }
    }

    public void leftShift() {
        if (!delayBackground) delayBackground = true;
        else {
            List<Cloud> clouds = getModel().getClouds();
            Iterator<Cloud> cloudIterator = clouds.iterator();
            while (cloudIterator.hasNext()) {
                Cloud cloud = cloudIterator.next();
                if (cloud.getPosition().getX() < -30) {
                    cloudIterator.remove();
                }
                else cloud.setPosition(new Position(cloud.getPosition().getX()-1,cloud.getPosition().getY()));
            }

            delayBackground = false;
        }

        for (Coin coin : getModel().getCoins()) {
            int x = coin.getPosition().getX();
            int y = coin.getPosition().getY();
            coin.setPosition(new Position(x - 1, y));
        }

        if (coinCheckpoint) {
            List<Enemy> enemies = getModel().getEnemies();
            Iterator<Enemy> enemiesIterator = enemies.iterator();
            while(enemiesIterator.hasNext()) {
                Enemy enemy = enemiesIterator.next();
                int x = enemy.getPosition().getX();
                int y = enemy.getPosition().getY();
                if (x < -20) enemiesIterator.remove();
                else enemy.setPosition(new Position(x - 1, y));
            }
        }
    }

    public void coinCollision() {
        List<Coin> coins = getModel().getCoins();
        Iterator<Coin> coinsIterator = coins.iterator();
        while (coinsIterator.hasNext()) {
            Coin coin = coinsIterator.next();

            if (getModel().getChell().getPolygon().intersects(coin.getPolygon().getBounds2D()) | coin.getPosition().getX() < -10) {
                coinsIterator.remove();
                getModel().addCoin();
                Sound.playSound(Sound.SoundsFx.Coin);
                this.coinCheckpoint = true;
            }
        }
    }
}
