package com.l06g06.shellshift.viewers;

import com.l06g06.shellshift.gui.Gui;
import com.l06g06.shellshift.model.game.elements.Bullet;
import com.l06g06.shellshift.model.game.elements.Position;
import com.l06g06.shellshift.viewer.game.BulletViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class BulletViewerTest {
    private Bullet bullet;
    private BulletViewer viewer;
    private Gui gui;

    @BeforeEach
    void setUp(){
        bullet = new Bullet(new Position(10,10));
        viewer = new BulletViewer();
        gui = Mockito.mock(Gui.class);
    }

    @Test
    void drawBullet(){
        viewer.draw(bullet, gui);
        Mockito.verify(gui, Mockito.times(1)).drawBullet(bullet.getPosition());
    }
}
