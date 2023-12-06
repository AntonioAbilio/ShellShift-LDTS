package com.l06g06.shellshift.viewer.game;

import com.l06g06.shellshift.gui.Gui;
import com.l06g06.shellshift.model.game.elements.Bullet;
import com.l06g06.shellshift.model.game.elements.Position;
import com.l06g06.shellshift.viewer.View;

public class BulletViewer implements ElementViewer<Bullet>{

    private static final String[] BULLET = new String[]{
            "RRR",
            "R**R",
            "RRR"
    };

    /*private static final String[] HITBOX = new String[]{
            "P"
    };*/

    @Override
    public void draw(Bullet bullet, Gui gui){
        View.ASCII_Drawer(BULLET, bullet.getPosition(), gui);
        //gui.drawBullet(bullet.getPosition());
        //Uncomment this to see hithox.
        /*for (int i = 0; i < bullet.getPolygon().npoints; i++) {
            int x = bullet.getPolygon().xpoints[i];
            int y = bullet.getPolygon().ypoints[i];
            View.ASCII_Drawer(HITBOX, new Position(x,y), gui);
            System.out.println("Vertex " + (i + 1) + ": (" + x + ", " + y + ")");
        }*/
    }
}
