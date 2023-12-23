package com.l06g06.shellshift.model.game.elements.enemies;

import com.l06g06.shellshift.model.game.elements.Element;
import com.l06g06.shellshift.model.game.elements.Position;
import com.l06g06.shellshift.model.game.elements.enemies.moveStrategies.MoveStrategy;

import java.awt.*;

public abstract class Enemy extends Element {
    protected int HP;
    protected int score;

    private final static int width = 15;
    private final static int height = 15;
    private final MoveStrategy moveStrategy;

    public Enemy(Position position, int HP, MoveStrategy moveStrategy, int score) {
        super(position);
        this.HP = HP;
        this.moveStrategy = moveStrategy;
        this.score = score;

        Polygon enemyHitbox = new Polygon();

        int x = position.getX();
        int y = position.getY();

        enemyHitbox.addPoint(x + 1, y + 1);
        enemyHitbox.addPoint(x + width - 1, y + 1);
        enemyHitbox.addPoint(x + 1, y + height - 1);
        enemyHitbox.addPoint(x + width - 1, y + height - 1);
        this.hitbox = enemyHitbox;
    }

    public int getHP() {
        return HP;
    }

    public void decreaseHP(int damage) {
        this.HP -= damage;
    }

    public int getScore() {
        return this.score;
    }

    public MoveStrategy getMoveStrategy() {
        return moveStrategy;
    }
}
