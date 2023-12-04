package com.l06g06.shellshift.viewer.game;

// Internelly we decided to call arena Map...
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

        /*//DEBUG
        System.out.println("Method Call to drawElements of GameViewer\n");*/

        drawElements(gui, getModel().getBullets(), new BulletViewer());
        drawElements(gui, getModel().getCoins(), new CoinViewer());
        drawElements(gui, getModel().getEnemies(), new EnemyViewer());
        drawElements(gui, getModel().getPlatforms(), new PlatformViewer());
        drawElements(gui, getModel().getPowerups(), new PowerupViewer());
        drawElement(gui, getModel().getChell(), new ChellViewer());


        gui.drawText(new Position(0, 0), "Lives: " + getModel().getChell().getLives(), "#FFFFFF");
    }

    private <T extends Element> void drawElements(Gui gui, List<T> elements, ElementViewer<T> viewer) {
        for (T element : elements)
            drawElement(gui, element, viewer);
    }

    private <T extends Element> void drawElement(Gui gui, T element, ElementViewer<T> viewer) {
        viewer.draw(element, gui);
    }

}
