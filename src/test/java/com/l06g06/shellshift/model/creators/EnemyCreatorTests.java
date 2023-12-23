package com.l06g06.shellshift.model.creators;

import com.l06g06.shellshift.Database;
import com.l06g06.shellshift.model.game.elements.Element;
import com.l06g06.shellshift.model.game.elements.Position;
import com.l06g06.shellshift.model.game.elements.enemies.Enemy;
import com.l06g06.shellshift.model.game.elements.enemies.HardMonster;
import com.l06g06.shellshift.model.game.elements.enemies.SoftMonster;
import com.l06g06.shellshift.model.game.elements.enemies.moveStrategies.HorizontalMoveStrategy;
import com.l06g06.shellshift.model.game.elements.enemies.moveStrategies.VerticalMoveStrategy;
import net.jqwik.api.ForAll;
import net.jqwik.api.Property;
import org.junit.jupiter.api.Assertions;

import java.util.Random;


public class EnemyCreatorTests {
    private EnemyCreator enemycreator;

    @Property
    void testCreateMethod(@ForAll int x, @ForAll int y) {
        Database.getInstance().setSound(true);
        enemycreator = new EnemyCreator();
        Random rn = new Random();
        long seed = rn.nextInt();
        rn = new Random(seed);
        enemycreator.setRandomSeed(seed);

        Element enemy = enemycreator.create(new Position(x, y));

        int detemineTypeOfMonster = rn.nextInt(2);
        detemineTypeOfMonster = rn.nextInt(2);
        if (detemineTypeOfMonster == 0){
            Assertions.assertEquals(50, ((Enemy) enemy).getScore());
        } else {
            Assertions.assertEquals(20, ((Enemy) enemy).getScore());
        }


        Assertions.assertNotNull(enemy);
        Assertions.assertTrue((enemy instanceof SoftMonster) || (enemy instanceof HardMonster));
        Assertions.assertEquals(x, enemy.getPosition().getX());
        Assertions.assertEquals(y, enemy.getPosition().getY());
    }

    @Property
    void testMoveStrategiesOfAllMonsters(@ForAll int x, @ForAll int y) {
        Database.getInstance().setSound(true);
        enemycreator = new EnemyCreator();
        Random rn = new Random();
        long seed = rn.nextInt();
        rn.setSeed(seed);
        enemycreator.setRandomSeed(seed);

        Element enemy = enemycreator.create(new Position(x, y));

        int detemineTypeOfMoveStrategy = rn.nextInt(2);
        if (detemineTypeOfMoveStrategy == 0){
            Assertions.assertTrue(((Enemy) enemy).getMoveStrategy() instanceof HorizontalMoveStrategy);
        } else {
            Assertions.assertTrue((((Enemy) enemy).getMoveStrategy() instanceof VerticalMoveStrategy));
        }
    }

}
