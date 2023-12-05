package com.l06g06.shellshift.model.game.elements;

import com.l06g06.shellshift.model.game.gun.Gun;

public class Chell extends Element {
    private Gun gun;
    private int lives;
    private float velocity = 200F;
    private int gravity = 1000;

    private final static int height = 15;
    private final static int width = 15;

    public static int getHeight(){
        return Chell.height;
    }

    public static int getWidth(){
        return Chell.width;
    }

    public float getVelocity() {
        return velocity;
    }

    public void setVelocity(int velocity) {
        this.velocity = velocity;
    }

    public int getGravity() {
        return gravity;
    }

    public void setGravity(int gravity) {
        this.gravity = gravity;
    }

    public Chell(Position position) {
        super(position);
    }

    public int getLives() {
        return lives;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }

    public void decreaseLives() {
        this.lives--;
    }

    public void increaseLives() {
        this.lives++;
    }

    public Gun getGun() {
        return this.gun;
    }
    public void setGun(Gun gun) {
        this.gun = gun;
    }
}
