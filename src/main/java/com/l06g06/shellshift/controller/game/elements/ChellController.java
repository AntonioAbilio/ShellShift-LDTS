package com.l06g06.shellshift.controller.game.elements;

import com.google.common.annotations.VisibleForTesting;
import com.l06g06.shellshift.Game;
import com.l06g06.shellshift.Sound;
import com.l06g06.shellshift.SoundsFx;
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
        this.canJump = false;
        this.groundY = getModel().getChell().getPosition().getY();
        this.previousY = this.groundY;
    }

    @Override
    public void step(Game game, List<Gui.PressedKey> action, long time) {
        // Check where Chell will land.
        if (!isJumping) checkLanding();
        else canJump = true;

        for (Gui.PressedKey gpk : action) {
            switch (gpk) {
                case UP:
                    if (!isJumping && canJump) {
                        getModel().getChell().setPosition(new Position(getModel().getChell().getPosition().getX(), groundY-1));
                        jump(time);
                    }
                    break;
                case LEFT:
                    moveLEFT();
                    break;
                case RIGHT:
                    moveRIGHT();
                    break;
                default:
            }
        }

        if (isJumping) jumpUpdate(time);

        double currentTime = time / 1000.0; // Convert to seconds

        if (currentTime - lastShiftTime >= getModel().getShiftCooldown()){
            lastShiftTime = currentTime;
            left_shift();
        }
    }

    public void lookForPlatformCollision(){
        for (Platform platform : getModel().getPlatforms()) {
            if (getModel().getChell().getPolygon().intersects(platform.getPolygon().getBounds2D())) {
                groundY = (int) platform.getPolygon().getBounds().getMinY();
                getModel().getChell().setPosition(new Position(getModel().getChell().getPosition().getX(), groundY-2));
                isJumping = false;
                canJump = true;
                break; // Exit the loop after the first collision
            }
        }
    }

    public void checkLanding(){
        canJump = false;
        lookForPlatformCollision();
        int y = (int) (getModel().getChell().getPosition().getY() + (getModel().getChell().getVelocity() * 0.01 - 0.5 * getModel().getChell().getGravity() * 0.001 ));
        getModel().getChell().setPosition(new Position(getModel().getChell().getPosition().getX(), y));
    }

    public void jump(long time){
        //SomAqui Sound.playSound(SoundsFx.Jump);
        Sound sound = Sound.getInstance();
        sound.playSound(SoundsFx.Jump);
        isJumping = true;
        jumpStartTime = time;
        canJump = false;
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


    public boolean isJumping() {
        return isJumping;
    }

    public boolean isCanJump() {
        return canJump;
    }

    public long getJumpStartTime() {
        return jumpStartTime;
    }

    public int getGroundY() {
        return groundY;
    }

    public void setJumpStartTime(long jumpStartTime) {
        this.jumpStartTime = jumpStartTime;
    }

    @VisibleForTesting
    public void setJumping(boolean jumping) {
        isJumping = jumping;
    }

    @VisibleForTesting
    public void setCanJump(boolean canJump) {
        this.canJump = canJump;
    }

    @VisibleForTesting
    public void setGroundY(int groundY) {
        this.groundY = groundY;
    }
}

