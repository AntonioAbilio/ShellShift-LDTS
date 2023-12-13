package com.l06g06.shellshift.model.creators;

import com.l06g06.shellshift.model.game.elements.Coin;
import com.l06g06.shellshift.model.game.elements.Element;
import com.l06g06.shellshift.model.game.elements.Position;

public class CoinCreator extends Creator{
    @Override
    public Element create(Position position) {
        return new Coin(position);
    }
}
