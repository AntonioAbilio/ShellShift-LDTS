package com.l06g06.shellshift.model.creators;

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


public class EnemyCreatorTests {
    private EnemyCreator enemycreator;

    @Property
    void testCreateMethod(@ForAll int x, @ForAll int y) {
        enemycreator = new EnemyCreator();
        Element enemy = enemycreator.create(new Position(x, y));
        Assertions.assertNotNull(enemy);
        Assertions.assertTrue((enemy instanceof SoftMonster) || (enemy instanceof HardMonster));
        Assertions.assertEquals(x, enemy.getPosition().getX());
        Assertions.assertEquals(y, enemy.getPosition().getY());
    }

    @Property
    void testMoveStrategiesOfAllMonsters(@ForAll int x, @ForAll int y) {
        enemycreator = new EnemyCreator();
        Element enemy = enemycreator.create(new Position(x, y));
        Assertions.assertTrue((((Enemy) enemy).getMoveStrategy() instanceof VerticalMoveStrategy) || ((Enemy) enemy).getMoveStrategy() instanceof HorizontalMoveStrategy);
    }

}
