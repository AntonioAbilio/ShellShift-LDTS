package com.l06g06.shellshift.model.creators;

import com.l06g06.shellshift.model.game.elements.Element;
import com.l06g06.shellshift.model.game.elements.Platform;
import com.l06g06.shellshift.model.game.elements.Position;
import net.jqwik.api.ForAll;
import net.jqwik.api.Property;
import org.junit.jupiter.api.Assertions;

public class PlatformCreatorTests {

    private PlatformCreator platformCreator;

    @Property
    void testCreateMethodWithAllSeeds(@ForAll int x, @ForAll int y) {
        platformCreator = new PlatformCreator();
        Element platform = platformCreator.create(new Position(x, y));
        Assertions.assertNotNull(platform);
        Assertions.assertTrue(platform instanceof Platform);
        Assertions.assertEquals(300, platform.getPosition().getX());

        // Additional assertions to check if the returned platform is one of the specified platforms
        int platformY = platform.getPosition().getY();
        Assertions.assertTrue(platformY == 97 || platformY == 78 || platformY == 59 || platformY == 42 || platformY == 25);
    }
}
