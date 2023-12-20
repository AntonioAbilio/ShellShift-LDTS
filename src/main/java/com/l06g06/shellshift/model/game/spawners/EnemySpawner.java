package com.l06g06.shellshift.model.game.spawners;

import com.l06g06.shellshift.model.creators.*;
import com.l06g06.shellshift.model.game.elements.Position;
import com.l06g06.shellshift.model.game.elements.enemies.Enemy;

import java.util.Iterator;
import java.util.List;

public class EnemySpawner {
    private EnemyCreator enemyCreator;
    private List<Enemy> enemies;

    public EnemySpawner(List<Enemy> enemies){
        this.enemies = enemies;
        this.enemyCreator = new EnemyCreator();
    }

    public void spawn(Position position){
        Enemy spawned_enemy = (Enemy) enemyCreator.create(position);
        enemies.add(spawned_enemy);
        enemies.removeIf(enemy -> enemy.getPosition().getX() < -30);
    }

}
