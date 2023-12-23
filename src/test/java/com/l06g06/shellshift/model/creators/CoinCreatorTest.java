package com.l06g06.shellshift.model.creators;


import com.l06g06.shellshift.Database;
import com.l06g06.shellshift.model.game.elements.Coin;
import com.l06g06.shellshift.model.game.elements.Element;
import com.l06g06.shellshift.model.game.elements.Position;
import net.jqwik.api.ForAll;
import net.jqwik.api.Property;
import org.junit.jupiter.api.Assertions;

public class CoinCreatorTest {
    private CoinCreator coinCreator;

    @Property
    void testCreateMethodWithAllSeeds(@ForAll int x, @ForAll int y) {
        Database.getInstance().setSound(true);
        coinCreator = new CoinCreator();
        Element coin = coinCreator.create(new Position(x, y));
        Assertions.assertNotNull(coin);
        Assertions.assertTrue(coin instanceof Coin);
        Assertions.assertEquals(x, coin.getPosition().getX());
        Assertions.assertEquals(y, coin.getPosition().getY());

    }
}
