package com.l06g06.shellshift.model.game.elements.powerups;

import com.l06g06.shellshift.model.game.elements.Element;
import com.l06g06.shellshift.model.game.elements.Position;
import com.l06g06.shellshift.model.game.map.Map;

import java.awt.*;

public abstract class PowerUp extends Element {
    private final static int size = 12;
    private String type;

    public PowerUp(Position position) {
        super(position);

        Polygon powerUpHitbox = new Polygon();

        int x = position.getX();
        int y = position.getY();

        powerUpHitbox.addPoint(x+1,y+1);
        powerUpHitbox.addPoint(x+size-1,y+1);
        powerUpHitbox.addPoint(x+1, y+size-1);
        powerUpHitbox.addPoint(x+size-1, y+size-1);
        this.hitbox = powerUpHitbox;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public abstract void activate(Map map);
}
