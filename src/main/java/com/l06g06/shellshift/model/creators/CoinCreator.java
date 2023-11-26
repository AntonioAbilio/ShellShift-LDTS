package com.l06g06.shellshift.model.creators;

import com.l06g06.shellshift.model.game.elements.Coin;
import com.l06g06.shellshift.model.game.elements.Element;
import com.l06g06.shellshift.model.game.elements.Position;

public class CoinCreator extends Creator{
    @Override
    public Element create() {
        return new Coin(new Position(0,0));
    }
}
