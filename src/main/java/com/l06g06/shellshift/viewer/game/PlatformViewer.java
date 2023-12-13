package com.l06g06.shellshift.viewer.game;

import com.l06g06.shellshift.Components;
import com.l06g06.shellshift.gui.Gui;
import com.l06g06.shellshift.model.game.elements.Platform;
import com.l06g06.shellshift.model.game.elements.Position;

public class PlatformViewer implements ElementViewer<Platform>{
    @Override
    public void draw(Platform platform, Gui gui){
        gui.drawImageASCII(Components.Platform.getImage(), new Position(platform.getPosition().getX() - Platform.getWidth(), platform.getPosition().getY()));
    }
}
