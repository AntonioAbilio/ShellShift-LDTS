package com.l06g06.shellshift.model.game.elements;

import com.l06g06.shellshift.model.game.gun.Gun;

public class Chell extends Element {
    private Gun gun;
    private int lives;

    private final static int height = 15;
    private final static int width = 15;

    public static int getHeight(){
        return Chell.height;
    }

    public static int getWidth(){
        return Chell.width;
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

    public void moveUP(){
        int x = getPosition().getX();
        int y = getPosition().getY();
        setPosition(new Position(x,y-1));
    }

    public void moveDOWN(){
        int x = getPosition().getX();
        int y = getPosition().getY();
        setPosition(new Position(x,y+1));
    }

    public void moveLEFT(){
        int x = getPosition().getX();
        int y = getPosition().getY();
        setPosition(new Position(x-1,y));
    }

    public void moveRIGHT(){
        int x = getPosition().getX();
        int y = getPosition().getY();
        setPosition(new Position(x+1,y));
    }


    public Gun getGun() {
        return this.gun;
    }
    public void setGun(Gun gun) {
        this.gun = gun;
    }
}
