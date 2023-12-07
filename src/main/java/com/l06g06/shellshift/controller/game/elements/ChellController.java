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
    boolean isColidingWithPlataform;
    long jumpStartTime=0;
    int groundY;

    public ChellController(Map map) {
        super(map);
        this.isJumping = false;
        this.groundY = getModel().getChell().getPosition().getY();
    }

    private boolean EnemyColision(){
        boolean colided = false;
        List<Enemy> original_enemies = getModel().getEnemies();
        List<Enemy> new_enemies = new ArrayList<Enemy>(0);
        for (Enemy enemy : original_enemies){
            if (this.getModel().getChell().getPolygon().intersects(enemy.getPolygon().getBounds2D())){
                colided = true;
                this.getModel().getChell().setLives(this.getModel().getChell().getLives() - 1);
                if (this.getModel().getChell().getLives() <= 0){
                    // game over;
                }
            } else {
                new_enemies.add(enemy);
            }
        }
        this.getModel().setEnemies(new_enemies);
        return colided;
    }

    private boolean standingOnPlatform(){
        boolean colided = false;
        List<Platform> platforms = getModel().getPlatforms();
        for (Platform platform : platforms){
            if (this.getModel().getChell().getPolygon().intersects(platform.getPolygon().getBounds2D())){
                colided = true;
            }
        }
        return colided;
    }

    @Override
    public void step(Game game, List<Gui.PressedKey> action, long time) {

        if (standingOnPlatform()){
            for (Gui.PressedKey gpk : action) {
                switch (gpk) {
                    case UP:
                        if (!isJumping) jump(time);
                        break;
                    case DOWN:
                        //moveDOWN();
                        EnemyColision();
                        break;
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



        } else{
            if (isJumping) jumpUpdate(time);
            int y = this.getModel().getChell().getPosition().getY();
            int x = this.getModel().getChell().getPosition().getX();
            y++;
            this.getModel().getChell().setPosition(new Position(x,y));
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
        /*if (PlatformColision()){
            this.isColidingWithPlataform = true;
            System.out.println("Colided.");
            isJumping = false;
            return;
        }*/

        // Check if ground already reached
        if (getModel().getChell().getPosition().getY() >= groundY + 1) {
            System.out.println("True");
            isJumping = false;
            getModel().getChell().setPosition(new Position(getModel().getChell().getPosition().getX(), groundY)); // Ensure Chell is exactly at the ground level
            EnemyColision();
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


