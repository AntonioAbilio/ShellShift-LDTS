package com.l06g06.shellshift.model.game.elements;

import com.google.common.annotations.VisibleForTesting;
import com.l06g06.shellshift.Database;
import com.l06g06.shellshift.model.game.gun.Gun;

import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Chell extends Element {
    private Gun gun;
    private int lives;
    private float velocity = 250F;
    private int gravity = 1000;
    private int horizontalSpeed = 1;
    private boolean direction = true; // true = right, false = left
    private boolean invincible = false;
    private boolean blink = false; // true = show Chell, false = don't show Chell
    private long invincibilityEndTime = 0;
    private long horizontalSpeedUpEndTime = 0;
    private final static int height = 15;
    private final static int width = 15;

    public static int getHeight(){
        return Chell.height;
    }

    @VisibleForTesting
    public int getActualHorizontalSpeed(){
        return this.horizontalSpeed;
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

    public void setHorizontalSpeedWithTimer(long milliseconds, int speed) {
        this.horizontalSpeedUpEndTime = System.currentTimeMillis() + milliseconds;
        this.horizontalSpeed = speed;
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);
        executorService.scheduleAtFixedRate(() -> {
            Thread.currentThread().setName("HorizontalThread");
            resetHorizontalSpeed();
        }, 0, milliseconds, TimeUnit.MILLISECONDS);

    }

    public boolean isHorizontalSpeedTimerOver() {
        return System.currentTimeMillis() >= horizontalSpeedUpEndTime;
    }

    public void resetHorizontalSpeed() {
        if (isHorizontalSpeedTimerOver())
            this.horizontalSpeed = 1;
    }

    public void setInvincibilityEndTime(long milliseconds) {
        this.invincibilityEndTime = System.currentTimeMillis() + milliseconds;
    }

    @SuppressWarnings("FutureReturnValueIgnored")
    public void activateBlink(long delay) {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);
        executorService.scheduleAtFixedRate(() -> {
            Thread.currentThread().setName("BlinkThread");
            toggleBlink();
        }, 0, 150, TimeUnit.MILLISECONDS);

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                stopBlinking();
                executorService.shutdown();
                timer.cancel();
            }
        }, delay);
    }
    public void toggleBlink() {
        this.blink = !this.blink;
    }
    public void stopBlinking(){
        blink = false;
    }

    public boolean isInvincible() {
        return System.currentTimeMillis() < invincibilityEndTime;
    }

    public boolean getBlink() {
        return blink;
    }
}
