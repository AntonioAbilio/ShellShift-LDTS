package com.l06g06.shellshift.viewer.game;

import com.l06g06.shellshift.Components;
import com.l06g06.shellshift.gui.Gui;
import com.l06g06.shellshift.model.game.elements.Bullet;

public class BulletViewer implements ElementViewer<Bullet>{
    @Override
    public void draw(Bullet bullet, Gui gui){
        gui.drawImageASCII(Components.Bullet.getImage(), bullet.getPosition());
    }
}
