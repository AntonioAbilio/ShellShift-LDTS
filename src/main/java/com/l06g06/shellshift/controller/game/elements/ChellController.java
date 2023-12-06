package com.l06g06.shellshift.controller.game.elements;

import com.l06g06.shellshift.Game;
import com.l06g06.shellshift.controller.game.GameController;
import com.l06g06.shellshift.gui.Gui;
import com.l06g06.shellshift.model.game.elements.Position;
import com.l06g06.shellshift.model.game.map.Map;

import java.util.List;


public class ChellController extends GameController {
    boolean isJumping;
    long jumpStartTime=0;
    int groundY;

    public ChellController(Map map) {
        super(map);
        this.isJumping = false;
        this.groundY = getModel().getChell().getPosition().getY();
    }

    @Override
    public void step(Game game, List<Gui.PressedKey> action, long time) {
        for (Gui.PressedKey gpk : action) {
            switch (gpk) {
                case UP:
                    if (!isJumping) jump(time);
                    break;
                case DOWN:
                    moveDOWN();
                    break;
                case LEFT:
                    moveLEFT();
                    break;
                case RIGHT:
                    moveRIGHT();
                    break;
            }
        }

        if (isJumping){
            jumpUpdate(time);
        }
    }

    public void jump(long time){
        isJumping = true;
        jumpStartTime = time;
        groundY = getModel().getChell().getPosition().getY();
    }

    public void jumpUpdate(long time){
        int x = getModel().getChell().getPosition().getX();

        // Calculate the elapsed time since the jump started
        double elapsedTime = (time - jumpStartTime) / 1000.0; // Convert to seconds

        // Calculate the new position using the updated elapsed time
        int y = (int) (groundY - (getModel().getChell().getVelocity() * elapsedTime - 0.5 * getModel().getChell().getGravity() * elapsedTime * elapsedTime)); // y(t) = y0 + v0t - 0.5gt^2

        System.out.println(y);

        // Update Chell's position;
        getModel().getChell().setPosition(new Position(x, y));

        // Check if ground already reached
        if (getModel().getChell().getPosition().getY() >= groundY + 1) {
            System.out.println("True");
            isJumping = false;
            getModel().getChell().setPosition(new Position(getModel().getChell().getPosition().getX(), groundY)); // Ensure Chell is exactly at the ground level
        }
    }

    public void moveDOWN(){
        int x = getModel().getChell().getPosition().getX();
        int y = getModel().getChell().getPosition().getY();
        getModel().getChell().setPosition(new Position(x,y+1));
    }

    public void moveLEFT(){
        int x = getModel().getChell().getPosition().getX();
        int y = getModel().getChell().getPosition().getY();
        getModel().getChell().setPosition(new Position(x-1,y));
    }

    public void moveRIGHT(){
        int x = getModel().getChell().getPosition().getX();
        int y = getModel().getChell().getPosition().getY();
        getModel().getChell().setPosition(new Position(x+1,y));
    }

}


