package com.l06g06.shellshift.viewer.tutorial;

import com.l06g06.shellshift.Components;
import com.l06g06.shellshift.gui.Gui;
import com.l06g06.shellshift.model.game.elements.Cloud;
import com.l06g06.shellshift.model.game.elements.Element;
import com.l06g06.shellshift.model.game.elements.Position;
import com.l06g06.shellshift.model.tutorial.TutorialMap;
import com.l06g06.shellshift.viewer.View;
import com.l06g06.shellshift.viewer.game.*;

import java.util.List;

public class TutorialViewer extends View<TutorialMap> {
    public TutorialViewer(TutorialMap model) {
        super(model);
    }

    @Override
    public void drawElements(Gui gui) {
        gui.setBackground("#8ec4e8");

        for (Cloud cloud : getModel().getClouds()) {
            gui.drawImageASCII(Components.Cloud.getImage(), cloud.getPosition());
        }

        drawElement(gui, getModel().getChell(), new ChellViewer());
        drawElement(gui, getModel().getPlatform(), new PlatformViewer());

        drawElements(gui, getModel().getBullets(), new BulletViewer());
        drawElements(gui, getModel().getCoins(), new CoinViewer());
        drawElements(gui, getModel().getEnemies(), new SoftMonsterViewer());
        drawElements(gui, getModel().getEnemies(), new HardMonsterViewer());

        gui.drawImageASCII(getModel().isSelectedArrowUp() ? Components.ArrowUp.getImageSelected() : Components.ArrowUp.getImage(), new Position(20, 5));
        gui.drawImageASCII(getModel().isSelectedArrowLeft() ? Components.ArrowLeft.getImageSelected() : Components.ArrowLeft.getImage(), new Position(5, 20));
        gui.drawImageASCII(getModel().isSelectedArrowRight() ? Components.ArrowRight.getImageSelected() : Components.ArrowRight.getImage(), new Position(35, 20));
        gui.drawImageASCII(getModel().isSelectedSpace() ? Components.SpaceBar.getImageSelected() : Components.SpaceBar.getImage(), new Position(55, 10));

        //Bullet Counter
        gui.drawImageASCII(Components.Bullet.getImage(), new Position(135, 91));
        String numBullets = Integer.toString(getModel().getGun().getNumBullets());
        for (int i = 0; i < numBullets.length(); i++) {
            char digit = numBullets.charAt(i);
            gui.drawImageASCII(Components.getNumbers().get(Character.getNumericValue(digit)).getImage(), new Position( 142 + i * 6, 90));
        }

        //Coins Collected Counter
        gui.drawImageASCII(Components.Coin.getImageSelected(),new Position(8, 90));
        String coinsCollected = Integer.toString(getModel().getCoinsCollected());
        for (int i = 0; i < coinsCollected.length(); i++) {
            char digit = coinsCollected.charAt(i);
            gui.drawImageASCII(Components.getNumbers().get(Character.getNumericValue(digit)).getImage(), new Position( 16 + i * 6, 90));
        }

        //gui.drawImageASCII(Components.StarPowerUp.getImage(), new Position(100, 80));
        //gui.drawImageASCII(Components.BulletPowerUp.getImage(), new Position(30, 80));
        //gui.drawImageASCII(Components.SpeedPowerUp.getImage(), new Position(10, 80));
    }

    private <T extends Element> void drawElements(Gui gui, List<T> elements, ElementViewer<T> viewer) {
        for (T element : elements)
            drawElement(gui, element, viewer);
    }

    private <T extends Element> void drawElement(Gui gui, T element, ElementViewer<T> viewer) {
        viewer.draw(element, gui);
    }

}
