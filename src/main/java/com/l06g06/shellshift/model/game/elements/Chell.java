package com.l06g06.shellshift.model.game.elements;

import com.l06g06.shellshift.Database;
import com.l06g06.shellshift.model.game.gun.Gun;

import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

public class Chell extends Element {
    private Gun gun;
    private int lives;
    private float velocity = 250F;
    private int gravity = 1000;
    private int horizontalSpeed = 1;
    private boolean direction = true; // true = anda pa direita, false = anda pa esquerda
    private boolean invincible = false;
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
        this.lives = Database.getInstance().getNumLives();
        Polygon chellHitbox = new Polygon();

        int x = position.getX();
        int y = position.getY();

        chellHitbox.addPoint(x-14,y-14);
        chellHitbox.addPoint(x,y-14);
        chellHitbox.addPoint(x-14, y+1);
        chellHitbox.addPoint(x, y+1);
        this.hitbox = chellHitbox;

    }

    public int getLives() {
        return lives;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }

    public void decreaseLives() {
        if (!invincible)
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

    public boolean isDirection() {
        return direction;
    }

    public void setDirection(boolean direction) {
        this.direction = direction;
    }

    @Override
    public void setPosition(Position position) {
        super.setPosition(new Position(position.getX(), position.getY()/* - 15*/));
    }

    public int getHorizontalSpeed() {
        return horizontalSpeed;
    }

    public void setHorizontalSpeedWithTimer(int speed) {
        this.horizontalSpeed = speed;
        // Schedule a task to reset speed after 3 seconds
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                resetToDefaultSpeed();
                timer.cancel(); // Stop the timer after resetting speed
            }
        }, 10000); // 3000 milliseconds = 3 seconds
    }

    private void resetToDefaultSpeed() {
        this.horizontalSpeed = 1;
    }
    public void activateInvincibility() {
        this.invincible = true;
        // Schedule a task to deactivate invincibility after 10 seconds
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                deactivateInvincibility();
                timer.cancel(); // Stop the timer after deactivating invincibility
            }
        }, 10000); // 10000 milliseconds = 10 seconds
    }

    private void deactivateInvincibility() {
        this.invincible = false;
    }


}
