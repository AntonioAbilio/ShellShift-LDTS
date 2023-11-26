package com.l06g06.shellshift.model.game.elements.enemies;

import com.l06g06.shellshift.model.game.elements.Element;
import com.l06g06.shellshift.model.game.elements.Position;

public abstract class Enemy extends Element {
    protected int HP;
    public Enemy(Position position, int HP) {
        super(position);
        this.HP = HP;
    }


}
