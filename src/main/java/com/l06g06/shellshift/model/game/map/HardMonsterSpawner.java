package com.l06g06.shellshift.model.game.map;

import com.l06g06.shellshift.model.creators.CoinCreator;
import com.l06g06.shellshift.model.creators.HardMonsterCreator;
import com.l06g06.shellshift.model.game.elements.Coin;
import com.l06g06.shellshift.model.game.elements.Position;
import com.l06g06.shellshift.model.game.elements.enemies.Enemy;
import com.l06g06.shellshift.model.game.elements.enemies.HardMonster;
import com.l06g06.shellshift.model.game.elements.enemies.SoftMonster;

import java.util.List;

public class HardMonsterSpawner {
    int i = 0;

    private HardMonsterCreator hardMonsterCreator;
    private List<Enemy> enemies;

    public HardMonsterSpawner(List<Enemy> enemies){
        this.enemies = enemies;
        this.hardMonsterCreator = new HardMonsterCreator();
    }

    public void spawn(Position position){
        Enemy spawned_hardMonster = (Enemy) hardMonsterCreator.create(position);
        if (spawned_hardMonster instanceof HardMonster) enemies.add(spawned_hardMonster);


        // ToDo: Do this in the EnemyCreator (maybe)
        /*if (i >= 3) {
            i = 3;
            hardMonsters.remove(0);
        }
        else{
            i++;
        }*/
    }
}
