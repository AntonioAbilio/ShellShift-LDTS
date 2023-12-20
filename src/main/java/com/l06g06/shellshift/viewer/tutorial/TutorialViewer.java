package com.l06g06.shellshift.viewer.tutorial;

import com.l06g06.shellshift.Components;
import com.l06g06.shellshift.gui.Gui;
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

        drawElements(gui, getModel().getClouds(), new CloudViewer());
        drawElement(gui, getModel().getChell(), new ChellViewer());
        drawElement(gui, getModel().getPlatform(), new PlatformViewer());
        drawElements(gui, getModel().getBullets(), new BulletViewer());
        drawElements(gui, getModel().getCoins(), new CoinViewer());
        drawElements(gui, getModel().getEnemies(), new SoftMonsterViewer());
        drawElements(gui, getModel().getEnemies(), new HardMonsterViewer());

        gui.drawImageASCII(getModel().isSelectedArrowUp() ? Components.ArrowUp.getImageSelected() : Components.ArrowUp.getImage(), new Position(55, 70));
        gui.drawImageASCII(getModel().isSelectedArrowLeft() ? Components.ArrowLeft.getImageSelected() : Components.ArrowLeft.getImage(), new Position(40, 85));
        gui.drawImageASCII(getModel().isSelectedArrowRight() ? Components.ArrowRight.getImageSelected() : Components.ArrowRight.getImage(), new Position(70, 85));
        gui.drawImageASCII(getModel().isSelectedSpace() ? Components.SpaceBar.getImageSelected() : Components.SpaceBar.getImage(), new Position(90, 77));

        //Bullet Counter
        gui.drawImageASCII(Components.Bullet.getImage(), new Position(135, 91));
        gui.numToASCII(getModel().getGun().getNumBullets(), 142,90);

        //Coins Collected Counter
        gui.drawImageASCII(Components.Coin.getImageSelected(),new Position(8, 90));
        gui.numToASCII(getModel().getCoinsCollected(),16,91);

    }

    private <T extends Element> void drawElements(Gui gui, List<T> elements, ElementViewer<T> viewer) {
        for (T element : elements)
            drawElement(gui, element, viewer);
    }

    private <T extends Element> void drawElement(Gui gui, T element, ElementViewer<T> viewer) {
        viewer.draw(element, gui);
    }

}
