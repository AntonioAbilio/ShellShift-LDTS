package com.l06g06.shellshift.controller.game.elements.enemies;

import com.l06g06.shellshift.Game;
import com.l06g06.shellshift.Sound;
import com.l06g06.shellshift.controller.game.GameController;
import com.l06g06.shellshift.controller.game.MapController;
import com.l06g06.shellshift.gui.Gui;
import com.l06g06.shellshift.model.game.elements.Platform;
import com.l06g06.shellshift.model.game.elements.Position;
import com.l06g06.shellshift.model.game.elements.enemies.Enemy;
import com.l06g06.shellshift.model.game.map.Map;

import java.util.Iterator;
import java.util.List;


public class EnemyController extends GameController {
    double lastSpawnTime = 0;
    double lastShiftTime = 0;
    int spawnX = 110;
    int offsetY = 15;
    int distBetweenEnemy = 15;
    public EnemyController(Map map) {
        super(map);
    }

    @Override
    public void step(Game game, List<Gui.PressedKey> action, long time) {

        double currentTime = time / 1000.0; // Convert to seconds

        // Spawn enemy logic
        if (currentTime - lastSpawnTime >= getModel().getSpawnCooldown()+2){
            lastSpawnTime = currentTime;
            spawnOnPlatform();
        }

        // Shift enemy logic
        if (currentTime - lastShiftTime >= getModel().getShiftCooldown()){
            lastShiftTime = currentTime;
            left_shift();
        }

        for (Enemy enemy : getModel().getEnemies()){
            enemy.setPosition(enemy.getMoveStrategy().move(enemy.getPosition()));  // Make Enemy move according to MoveStrategy
        }

        enemyChellCollision();

    }

    public void left_shift(){
        for (Enemy enemy : getModel().getEnemies()){
            int x = enemy.getPosition().getX();
            int y = enemy.getPosition().getY();
            enemy.setPosition(new Position(x - 1, y));
        }
    }

    public void spawnOnPlatform(){
        for (Platform platform : getModel().getPlatforms()){
            if (platform.getPosition().getX() >= spawnX - 30){
                Position spawnPos = new Position(platform.getPosition().getX()  + platform.getWidth()/2,
                        platform.getPosition().getY() - offsetY);
                if (noEnemyInPos(spawnPos)) getModel().getEnemySpawner().spawn(spawnPos);
            }
        }
    }

    public boolean noEnemyInPos(Position spawnPos){
        int diffX = 0;
        for (Enemy enemy : getModel().getEnemies()){
            diffX = spawnPos.getX() - enemy.getPosition().getX();
            if (diffX < 0) diffX = -diffX;
            if (diffX < distBetweenEnemy) return false;
        }
        return true;
    }

    public void enemyChellCollision() {
        List<Enemy> enemies = getModel().getEnemies();
        Iterator<Enemy> enemiesIterator = enemies.iterator();
        while(enemiesIterator.hasNext()) {
            Enemy enemy = enemiesIterator.next();
            if (getModel().getChell().getPolygon().intersects(enemy.getPolygon().getBounds2D())) {
                enemiesIterator.remove();
                if (!getModel().getChell().isInvincible()) {
                    getModel().getChell().decreaseLives();
                    Sound.playSound(Sound.SoundsFx.MonsterCollision);
                    getModel().getChell().activateBlink(1000);
                    getModel().getChell().activateInvincibilityTimer(2000);
                }
            }
        }
    }
}
