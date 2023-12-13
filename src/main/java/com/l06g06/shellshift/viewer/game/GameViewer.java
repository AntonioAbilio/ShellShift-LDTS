package com.l06g06.shellshift.viewer.game;

// Internelly we decided to call arena Map...
import com.l06g06.shellshift.Components;
import com.l06g06.shellshift.gui.Gui;
import com.l06g06.shellshift.model.game.elements.Position;
import com.l06g06.shellshift.model.game.map.Map;
import com.l06g06.shellshift.viewer.View;
import com.l06g06.shellshift.model.game.elements.Element;

import java.util.List;

public class GameViewer extends View<Map> {
    public GameViewer(Map map){
        super(map);
    }

    @Override
    public void drawElements(Gui gui) /*throws IOException*/ {
        gui.setBackground("#8ec4e8");

        drawElements(gui, getModel().getClouds(), new CloudViewer());
        drawElement(gui, getModel().getChell(), new ChellViewer());
        drawElements(gui, getModel().getPlatforms(), new PlatformViewer());
        drawElements(gui, getModel().getBullets(), new BulletViewer());
        drawElements(gui, getModel().getCoins(), new CoinViewer());
        drawElements(gui, getModel().getEnemies(), new SoftMonsterViewer());
        drawElements(gui, getModel().getEnemies(), new HardMonsterViewer());
        drawElements(gui, getModel().getPowerUps(), new PowerUpViewer());

        // HUD
        //Lives
        for (int i = 0; i < getModel().getChell().getLives(); i++) {
            gui.drawImageASCII(Components.HeartIcon.getImageSelected(), new Position((120 - (getModel().getChell().getLives()-3) * 10) + i * 10,6));
        }

        //Score
        gui.drawImageASCII(Components.Score.getImage(), new Position(5,7));
        gui.numToASCII(getModel().getScore(), 35,7);

        //Bullet Counter
        gui.drawImageASCII(Components.Bullet.getImage(), new Position(135, 91));
        gui.numToASCII(getModel().getGun().getNumBullets(), 142,90);

        //Coins
        gui.drawImageASCII(Components.Coin.getImageSelected(),new Position(8, 90));
        gui.numToASCII(getModel().getCoinsCollected(), 16,90);

    }

    private <T extends Element> void drawElements(Gui gui, List<T> elements, ElementViewer<T> viewer) {
        for (T element : elements)
            drawElement(gui, element, viewer);
    }

    private <T extends Element> void drawElement(Gui gui, T element, ElementViewer<T> viewer) {
        viewer.draw(element, gui);
    }

}
