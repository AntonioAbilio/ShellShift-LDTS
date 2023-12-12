package com.l06g06.shellshift.viewer.game;

// Internelly we decided to call arena Map...
import com.l06g06.shellshift.Components;
import com.l06g06.shellshift.gui.Gui;
import com.l06g06.shellshift.model.game.elements.Bullet;
import com.l06g06.shellshift.model.game.elements.Platform;
import com.l06g06.shellshift.model.game.elements.Position;
import com.l06g06.shellshift.model.game.map.Map;
import com.l06g06.shellshift.viewer.View;
import com.l06g06.shellshift.model.game.elements.Element;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GameViewer extends View<Map> {
    public GameViewer(Map map){
        super(map);
    }

    @Override
    public void drawElements(Gui gui) /*throws IOException*/ {

        /*//DEBUG
        System.out.println("Method Call to drawElements of GameViewer\n");*/

        /*drawElements(gui, getModel().getBullets(), new BulletViewer());
        drawElements(gui, getModel().getCoins(), new CoinViewer());
        drawElements(gui, getModel().getEnemies(), new EnemyViewer());
        drawElements(gui, getModel().getPlatforms(), new PlatformViewer());
        drawElements(gui, getModel().getPowerups(), new PowerupViewer());*/

        //DEBUG
        /*List<Platform> platforms = new ArrayList<Platform>();
        platforms.add(new Platform(new Position(10,10)));
        getModel().setPlatforms(platforms);
        drawElements(gui, getModel().getPlatforms(), new PlatformViewer());*/

        /*drawElements(gui, getModel().getCoins(), new CoinViewer());*/
        //drawElements(gui, getModel().getPlatforms(), new PlatformViewer());

        // Clean
        //gui.setBackground("#211300");
        gui.setBackground("#8ec4e8");

        drawElements(gui, getModel().getClouds(), new CloudViewer());
        drawElement(gui, getModel().getChell(), new ChellViewer());
        drawElements(gui, getModel().getPlatforms(), new PlatformViewer());
        drawElements(gui, getModel().getBullets(), new BulletViewer());
        drawElements(gui, getModel().getCoins(), new CoinViewer());
        drawElements(gui, getModel().getEnemies(), new SoftMonsterViewer());
        drawElements(gui, getModel().getEnemies(), new HardMonsterViewer());
        drawElements(gui, getModel().getPowerUps(), new PowerUpViewer());


        //drawElements(gui, getModel().getEnemies(), new SoftMonsterViewer());  // Debug
        //drawElements(gui, getModel().getEnemies(), new HardMonsterViewer());  // Debug

        // HUD
        //Lives
        for (int i = 0; i < getModel().getChell().getLives(); i++) {
            gui.drawImageASCII(Components.HeartIcon.getImageSelected(), new Position((120 - (getModel().getChell().getLives()-3) * 10) + i * 10,6));
        }

        gui.drawImageASCII(Components.Score.getImage(), new Position(5,7));
        gui.numToASCII(getModel().getScore(), 35,7);

        //Bullet Counter
        gui.drawImageASCII(Components.Bullet.getImage(), new Position(135, 91));
        gui.numToASCII(getModel().getGun().getNumBullets(), 142,90);

    }

    private <T extends Element> void drawElements(Gui gui, List<T> elements, ElementViewer<T> viewer) {
        for (T element : elements)
            drawElement(gui, element, viewer);
    }

    private <T extends Element> void drawElement(Gui gui, T element, ElementViewer<T> viewer) {
        viewer.draw(element, gui);
    }

}
