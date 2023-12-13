package com.l06g06.shellshift.model.game.map;

import com.l06g06.shellshift.model.creators.*;
import com.l06g06.shellshift.model.game.elements.Platform;
import com.l06g06.shellshift.model.game.elements.Position;
import com.l06g06.shellshift.model.game.elements.enemies.Enemy;

import java.util.List;

public class EnemySpawner {
    private EnemyCreator enemyCreator;
    private RandomEnemyFactory randomEnemyFactory;
    private List<Enemy> enemies;

    public EnemySpawner(List<Enemy> enemies){
        this.enemies = enemies;
        this.enemyCreator = new EnemyCreator();
        this.randomEnemyFactory = new RandomEnemyFactory();
    }

    public void spawn(Position position){
        //Enemy spawned_enemy = (Enemy) enemyCreator.create(position);
        Enemy spawned_enemy = randomEnemyFactory.create(position);
        enemies.add(spawned_enemy);
        for (int i = 0; i < enemies.size(); i++){
            if (enemies.get(i).getPosition().getX() <= -30) enemies.remove(i);
        }
    }

}
