package com.l06g06.shellshift.controller.game.elements.enemies;

import com.l06g06.shellshift.Game;
import com.l06g06.shellshift.controller.game.GameController;
import com.l06g06.shellshift.controller.game.MapController;
import com.l06g06.shellshift.gui.Gui;
import com.l06g06.shellshift.model.game.elements.Element;
import com.l06g06.shellshift.model.game.elements.Platform;
import com.l06g06.shellshift.model.game.elements.Position;
import com.l06g06.shellshift.model.game.elements.enemies.Enemy;
import com.l06g06.shellshift.model.game.elements.enemies.HardMonster;
import com.l06g06.shellshift.model.game.map.Map;

import java.util.List;


public class EnemyController extends GameController {
    double spawnCooldown = 3; // Spawn every 3 seconds
    double shiftCooldown = 0.1; // Shift every 0.1 seconds
    double lastSpawnTime = 0;
    double lastShiftTime = 0;
    int spawnX = 110;
    int offsetX = 0;
    int offsetY = 15;
    int distBetweenEnemy = 15;
    public EnemyController(Map map) {
        super(map);
    }

    @Override
    public void step(Game game, List<Gui.PressedKey> action, long time) {

        double currentTime = time / 1000.0; // Convert to seconds

        // Spawn coin logic
        if (currentTime - lastSpawnTime >= spawnCooldown){
            lastSpawnTime = currentTime;
            spawnOnPlatform();
        }

        // Shift coin logic
        if (currentTime - lastShiftTime >= MapController.getShiftCooldown()){
            lastShiftTime = currentTime;
            left_shift();
        }

        for (Enemy enemy : getModel().getEnemies()){
            enemy.setPosition(enemy.getMoveStrategy().move(enemy.getPosition()));  // Make Enemy move according to MoveStrategy
        }

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
                Position spawnPos = new Position(platform.getPosition().getX() + offsetX + platform.getWidth()/2,
                        platform.getPosition().getY() /*- platform.getHeight()*/ - offsetY);
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
}
