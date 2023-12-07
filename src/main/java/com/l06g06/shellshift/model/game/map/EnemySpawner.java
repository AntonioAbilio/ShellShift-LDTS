package com.l06g06.shellshift.model.game.map;

import com.l06g06.shellshift.model.creators.EnemyCreator;
import com.l06g06.shellshift.model.creators.PlatformCreator;
import com.l06g06.shellshift.model.game.elements.Platform;
import com.l06g06.shellshift.model.game.elements.Position;
import com.l06g06.shellshift.model.game.elements.enemies.Enemy;

import java.util.List;

public class EnemySpawner {
    private int i = 0;
    private EnemyCreator enemyCreator;
    private List<Enemy> enemies;

    public EnemySpawner(List<Enemy> enemies){
        this.enemies = enemies;
        this.enemyCreator = new EnemyCreator();
    }

    public void spawn(Position position){
        Enemy spawned_enemy = (Enemy) enemyCreator.create(position);
        enemies.add(spawned_enemy);
        if (i >= 3) {
            i = 3;
            enemies.remove(0);
        }
        else{
            i++;
        }
    }

}
