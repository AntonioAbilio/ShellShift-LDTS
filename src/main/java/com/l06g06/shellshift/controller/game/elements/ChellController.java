package com.l06g06.shellshift.controller.game.elements;

import com.l06g06.shellshift.Game;
import com.l06g06.shellshift.controller.game.GameController;
import com.l06g06.shellshift.gui.Gui;
import com.l06g06.shellshift.model.game.elements.Platform;
import com.l06g06.shellshift.model.game.elements.Position;
import com.l06g06.shellshift.model.game.elements.enemies.Enemy;
import com.l06g06.shellshift.model.game.map.Map;

import java.util.ArrayList;
import java.util.List;


public class ChellController extends GameController {
    boolean isJumping;
    boolean ignore_standingOnPlatform;
    long jumpStartTime=0;
    int groundY;
    int previousY;

    public ChellController(Map map) {
        super(map);
        this.isJumping = false;
        this.ignore_standingOnPlatform = false;
        this.groundY = getModel().getChell().getPosition().getY();
        this.previousY = this.groundY;
    }

    private boolean EnemyColision(){
        boolean colided = false;
        List<Enemy> original_enemies = getModel().getEnemies();
        /*List<Enemy> new_enemies = original_enemies;*/
        for (int i = 0; i < original_enemies.size(); i++){
            if (this.getModel().getChell().getPolygon().intersects(original_enemies.get(i).getPolygon().getBounds2D())){
                colided = true;
                original_enemies.remove(i);
                this.getModel().getChell().setLives(this.getModel().getChell().getLives() - 1);
                if (this.getModel().getChell().getLives() <= 0){
                    // game over;
                }
            }
        }

        /*for (Enemy enemy : new_enemies){
            if (this.getModel().getChell().getPolygon().intersects(enemy.getPolygon().getBounds2D())){
                colided = true;
                original_enemies.remove(enemy);
                this.getModel().getChell().setLives(this.getModel().getChell().getLives() - 1);
                if (this.getModel().getChell().getLives() <= 0){
                    // game over;
                }
            }
        }*/
        /*this.getModel().setEnemies(new_enemies);*/
        return colided;
    }

    private boolean standingOnPlatform(){
        boolean onPlatform = true; // Let's assume Chell is in a platform.

        for (Platform platform : getModel().getPlatforms()){
            // First condition of colision, Chell's hitbox must intersect the platform's hitbox.
            if (getModel().getChell().getPolygon().intersects(platform.getPolygon().getBounds2D())){

                // Second condition for colision, Chell's real position must be directly above the platform for any x coor.

                onPlatform = platform.getPolygon().getBounds().getMinY() == getModel().getChell().getPosition().getY();
                break;


            } else {
                onPlatform = false;
            }
        }


        return onPlatform;
    }

    private void lookForColisions(){
        for (Platform platform : getModel().getPlatforms()) {
            if (getModel().getChell().getPolygon().intersects(platform.getPolygon().getBounds2D())) {
                groundY = (int) platform.getPolygon().getBounds().getMinY();
                getModel().getChell().setPosition(new Position(getModel().getChell().getPosition().getX(), groundY));
                isJumping = false;
                EnemyColision();
                break; // Exit the loop after the first collision
            }
        }
    }

    @Override
    public void step(Game game, List<Gui.PressedKey> action, long time) {

        if (!ignore_standingOnPlatform){

            // If chell is not standing on a Platform.
            if (!standingOnPlatform()){

                // If Chell is not jumping.
                if (!isJumping){
                    lookForColisions();
                    int y = (int) (getModel().getChell().getPosition().getY() + (getModel().getChell().getVelocity() * 0.01 - 0.5 * getModel().getChell().getGravity() * 0.01 * 0.01));
                    getModel().getChell().setPosition(new Position(getModel().getChell().getPosition().getX(), y));
                }

            }


        }

        for (Gui.PressedKey gpk : action) {
            switch (gpk) {
                case UP:
                    if (!isJumping) jump(time);
                    break;
/*                case DOWN:
                    //moveDOWN();
                    EnemyColision();
                    break;*/
                case LEFT:
                    moveLEFT();
                    EnemyColision();
                    break;
                case RIGHT:
                    moveRIGHT();
                    EnemyColision();
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

    /*public void jumpUpdate(long time){
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
            EnemyColision();
        }
    }*/

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
            EnemyColision();
        }
    }

/*    public void moveDOWN(){
        int x = getModel().getChell().getPosition().getX();
        int y = getModel().getChell().getPosition().getY();
        getModel().getChell().setPosition(new Position(x,y+1));
    }*/

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


