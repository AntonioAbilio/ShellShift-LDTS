package com.l06g06.shellshift.model.game.elements;

import com.l06g06.shellshift.model.game.gun.FireStrategy;
import com.l06g06.shellshift.model.game.gun.Gun;
import com.l06g06.shellshift.model.game.elements.Position;
import net.jqwik.api.ForAll;
import net.jqwik.api.Property;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ChellTest {

    private Chell chell;
    private Position mockpos;

    @BeforeEach
    void setup(){
        mockpos = Mockito.mock(Position.class);

        Mockito.when(mockpos.getX()).thenReturn(5);
        Mockito.when(mockpos.getY()).thenReturn(5);

        chell = new Chell(mockpos);
    }

    @Test
    void set_get_gun(){

        class mockFireStrategy implements FireStrategy {
            @Override
            public void fire() {}
        }

        Gun gun = new Gun(new mockFireStrategy());

        chell.setGun(gun);
        Assertions.assertEquals(gun,chell.getGun());
    }

    @Test
    void get_width_height(){
        Assertions.assertEquals(15, Chell.getWidth());
        Assertions.assertEquals(15, Chell.getHeight());
    }

    @Property
    void chell_lives(@ForAll int lives) {

        mockpos = Mockito.mock(Position.class);
        Mockito.when(mockpos.getX()).thenReturn(5);
        Mockito.when(mockpos.getY()).thenReturn(5);
        chell = new Chell(mockpos);

        // Get and set lives.
        chell.setLives(lives);
        Assertions.assertEquals(lives, chell.getLives());

        // Test for increaseLives() method.
        chell.setLives(lives);
        chell.increaseLives();
        Assertions.assertEquals(lives + 1, chell.getLives());

        // Test for decreaseLives() method.
        chell.setLives(lives);
        chell.decreaseLives();
        Assertions.assertEquals(lives - 1, chell.getLives());
    }

}
