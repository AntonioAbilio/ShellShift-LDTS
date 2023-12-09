package com.l06g06.shellshift.controller.game.elements;

import com.l06g06.shellshift.Game;
import com.l06g06.shellshift.controller.game.GameController;
import com.l06g06.shellshift.gui.Gui;
import com.l06g06.shellshift.model.game.elements.Platform;
import com.l06g06.shellshift.model.game.elements.Position;
import com.l06g06.shellshift.model.game.map.Map;
import com.l06g06.shellshift.model.gameOver.GameOver;
import com.l06g06.shellshift.states.GameOverState;

import java.util.List;


public class ChellController extends GameController {
    boolean isJumping;
    /*boolean ignore_standingOnPlatform;*/
    boolean canJump;
    long jumpStartTime=0;
    int groundY;
    int previousY;

    public ChellController(Map map) {
        super(map);
        this.isJumping = false;
        /*this.ignore_standingOnPlatform = false;*/
        this.canJump = true;
        this.groundY = getModel().getChell().getPosition().getY();
        this.previousY = this.groundY;
    }


    private void lookForColisions(){
        for (Platform platform : getModel().getPlatforms()) {
            if (getModel().getChell().getPolygon().intersects(platform.getPolygon().getBounds2D())) {
                groundY = (int) platform.getPolygon().getBounds().getMinY();
                getModel().getChell().setPosition(new Position(getModel().getChell().getPosition().getX(), groundY-2));
                isJumping = false;
                break; // Exit the loop after the first collision
            }
        }
    }

    @Override
    public void step(Game game, List<Gui.PressedKey> action, long time) {

        // Check if Chell is dead.
        if (getModel().getChell().getLives() <= 0) game.setState(new GameOverState(new GameOver()));

        // Check if Chell is inside a Platform before doing anything else.
        elementInsidePlatform(getModel().getChell());

        // Cheeck where Chell will land.
        if (/*!ignore_standingOnPlatform && */!elementStandingOnPlatform() && !isJumping){
                lookForColisions();
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
    }

    public void jump(long time){
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

        System.out.println(y);

        // Update Chell's position;
        getModel().getChell().setPosition(new Position(x, y));

        // Check if Chell is moving up or down based on the change in position
        if (y < previousY) {
            System.out.println("Chell is going up");
        } else if (y > previousY) {
            System.out.println("Chell is falling");
            lookForColisions();
        }

        previousY = y; // Update the previous Y position

        // Check if ground already reached
        if (getModel().getChell().getPosition().getY() >= groundY + 1) {
            System.out.println("True");
            isJumping = false;
            getModel().getChell().setPosition(new Position(getModel().getChell().getPosition().getX(), groundY)); // Ensure Chell is exactly at the ground level
        }
    }

    public void moveLEFT(){
        getModel().getChell().setDirection(false);
        int x = getModel().getChell().getPosition().getX();
        int y = getModel().getChell().getPosition().getY();
        getModel().getChell().setPosition(new Position(x-1,y));
    }

    public void moveRIGHT(){
        int x = getModel().getChell().getPosition().getX();
        int y = getModel().getChell().getPosition().getY();
        getModel().getChell().setDirection(true);
        getModel().getChell().setPosition(new Position(x+1,y));
    }

}


