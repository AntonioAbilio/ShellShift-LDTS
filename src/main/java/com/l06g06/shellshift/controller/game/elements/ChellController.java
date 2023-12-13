package com.l06g06.shellshift.controller.game.elements;

import com.l06g06.shellshift.Game;
import com.l06g06.shellshift.Sound;
import com.l06g06.shellshift.controller.game.GameController;
import com.l06g06.shellshift.controller.game.MapController;
import com.l06g06.shellshift.gui.Gui;
import com.l06g06.shellshift.model.game.elements.Platform;
import com.l06g06.shellshift.model.game.elements.Position;
import com.l06g06.shellshift.model.game.map.Map;

import java.util.List;


public class ChellController extends GameController {
    boolean isJumping;
    boolean canJump;
    long jumpStartTime = 0;
    int groundY;
    int previousY;
    double lastShiftTime = 0;

    public ChellController(Map map) {
        super(map);
        this.isJumping = false;
        this.canJump = true;
        this.groundY = getModel().getChell().getPosition().getY();
        this.previousY = this.groundY;
    }

    @Override
    public void step(Game game, List<Gui.PressedKey> action, long time) {
        // Check if Chell is inside a Platform before doing anything else.
        //elementInsidePlatform(getModel().getChell()); --> nao faz nada

        // Check where Chell will land.
        if (!isChellStandingOnPlatform() && !isJumping){
            lookForPlatformCollision();
            canJump = false;
            int y = (int) (getModel().getChell().getPosition().getY() + (getModel().getChell().getVelocity() * 0.01 - 0.5 * getModel().getChell().getGravity() * 0.01 * 0.01));
            getModel().getChell().setPosition(new Position(getModel().getChell().getPosition().getX(), y));
        } else {
            canJump = true;
        }

        for (Gui.PressedKey gpk : action) {
            switch (gpk) {
                case UP:
                    if (!isJumping && canJump) jump(time);
                    break;
                case LEFT:
                    moveLEFT();
                    break;
                case RIGHT:
                    moveRIGHT();
                    break;
            }
        }

        if (isJumping) jumpUpdate(time);

        double currentTime = time / 1000.0; // Convert to seconds

        if (currentTime - lastShiftTime >= MapController.getShiftCooldown()){
            lastShiftTime = currentTime;
            left_shift();
        }
    }

    public boolean isChellStandingOnPlatform(){
        boolean onPlatform = false; // Let's assume Element is standing on a platform. -> e melhor ser falso assim nao temos que ter um else
        for (Platform platform : getModel().getPlatforms()){
            // First condition of colision. Element's hitbox must intersect the platform's hitbox.
            if (getModel().getChell().getPolygon().intersects(platform.getPolygon().getBounds2D())){
                // Second condition for colision. Element's real position must be directly above the platform for any x coor.
                onPlatform = platform.getPolygon().getBounds().getMinY() == getModel().getChell().getPosition().getY();
                break;
            }
        }
        return onPlatform;
    }

    public void lookForPlatformCollision(){
        for (Platform platform : getModel().getPlatforms()) {
            if (getModel().getChell().getPolygon().intersects(platform.getPolygon().getBounds2D())) {
                groundY = (int) platform.getPolygon().getBounds().getMinY();
                getModel().getChell().setPosition(new Position(getModel().getChell().getPosition().getX(), groundY-2));
                isJumping = false;
                break; // Exit the loop after the first collision
            }
        }
    }

    public void jump(long time){
        if (!isJumping){
            if (time - jumpStartTime >= 500)
                Sound.playSound(Sound.SoundsFx.Jump);
        }
        System.out.println("ola");
        isJumping = true;
        jumpStartTime = time;
        groundY = getModel().getChell().getPosition().getY();
    }

    public void jumpUpdate(long time) {
        int x = getModel().getChell().getPosition().getX();

        // Calculate the elapsed time since the jump started
        double elapsedTime = (time - jumpStartTime) / 1000.0; // Convert to seconds

        // Calculate the new position using the updated elapsed time
        int y = (int) (groundY - (getModel().getChell().getVelocity() * elapsedTime - 0.5 * getModel().getChell().getGravity() * elapsedTime * elapsedTime));

        // Update Chell's position;
        getModel().getChell().setPosition(new Position(x, y));

        if (y > previousY) lookForPlatformCollision();
        previousY = y; // Update the previous Y position

        // Check if ground already reached
        if (getModel().getChell().getPosition().getY() >= groundY + 1) {
            isJumping = false;
            getModel().getChell().setPosition(new Position(getModel().getChell().getPosition().getX(), groundY)); // Ensure Chell is exactly at the ground level
        }
    }

    public void moveLEFT(){
        getModel().getChell().setDirection(false);
        int x = getModel().getChell().getPosition().getX();
        int y = getModel().getChell().getPosition().getY();
        getModel().getChell().setPosition(new Position(x- getModel().getChell().getHorizontalSpeed(),y));
    }

    public void moveRIGHT(){
        if (getModel().getChell().getPosition().getX() < 160) {
            int x = getModel().getChell().getPosition().getX();
            int y = getModel().getChell().getPosition().getY();
            getModel().getChell().setDirection(true);
            getModel().getChell().setPosition(new Position(x + getModel().getChell().getHorizontalSpeed(), y));
        }
    }

    public void left_shift(){
        int x = getModel().getChell().getPosition().getX();
        int y = getModel().getChell().getPosition().getY();
        getModel().getChell().setPosition(new Position(x - 1, y));
    }

}


