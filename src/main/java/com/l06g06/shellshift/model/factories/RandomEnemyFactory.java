/*
package com.l06g06.shellshift.model.factories;

import com.l06g06.shellshift.model.game.elements.Position;
import com.l06g06.shellshift.model.game.elements.enemies.Enemy;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomEnemyFactory {
    private final Random random = new Random();
    private List<EnemyFactory> availableEnemyFactories;

    public RandomEnemyFactory() {
        availableEnemyFactories = new ArrayList<>();
        availableEnemyFactories.add(new HardMonsterFactory());
        availableEnemyFactories.add(new SoftMonsterFactory());
    }
    public Enemy create(Position position) {
        return (Enemy) this.availableEnemyFactories.get(random.nextInt(availableEnemyFactories.size())).create(position);
    }

}
*/
