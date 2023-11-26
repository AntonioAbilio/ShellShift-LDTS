package com.l06g06.shellshift.model.game.elements.gun;

import com.l06g06.shellshift.model.game.elements.Bullet;
import com.l06g06.shellshift.model.game.elements.Element;
import com.l06g06.shellshift.model.game.elements.Position;

public class Gun extends Element implements FireStrategy {
    private int numBullets = 10;
    private FireStrategy strategy;
    private boolean changedFireStrategy;
    public Gun(Position position, FireStrategy strategy) {
        super(position);
        this.strategy = strategy;
    }

    @Override
    public void fire() {
        strategy.fire();
        numBullets--;
    }

    public void setStrategy(FireStrategy strategy) {
        this.strategy = strategy;
    }
}
