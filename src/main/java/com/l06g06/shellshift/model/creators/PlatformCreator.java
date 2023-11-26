package com.l06g06.shellshift.model.creators;

import com.l06g06.shellshift.model.game.elements.Element;
import com.l06g06.shellshift.model.game.elements.Platform;
import com.l06g06.shellshift.model.game.elements.Position;

public class PlatformCreator extends Creator{
    @Override
    public Element create() {
        return new Platform(new Position(0,0));
    }
}
