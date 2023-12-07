package com.l06g06.shellshift.model.game.map;

import com.l06g06.shellshift.model.creators.CoinCreator;
import com.l06g06.shellshift.model.creators.SoftMonsterCreator;
import com.l06g06.shellshift.model.game.elements.Coin;
import com.l06g06.shellshift.model.game.elements.Position;
import com.l06g06.shellshift.model.game.elements.enemies.Enemy;
import com.l06g06.shellshift.model.game.elements.enemies.SoftMonster;

import java.util.List;

public class SoftMonsterSpawner {
    int i = 0;

    private SoftMonsterCreator softMonsterCreator;
    private List<Enemy> enemies ;

    public SoftMonsterSpawner(List<Enemy> enemies){
        this.enemies = enemies;
        this.softMonsterCreator = new SoftMonsterCreator();
    }

    public void spawn(Position position){
        Enemy spawned_softMonster = (Enemy) softMonsterCreator.create(position);
        if (spawned_softMonster instanceof SoftMonster) enemies.add(spawned_softMonster);

        // ToDo: Implement this in the Enemy Creator (maybe)
        /*if (i >= 3) {
            i = 3;
            enemies.remove(0);
        }
        else{
            i++;
        }*/
    }

}
