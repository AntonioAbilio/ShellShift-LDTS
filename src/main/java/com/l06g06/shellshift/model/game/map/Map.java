package com.l06g06.shellshift.model.game.map;

import com.l06g06.shellshift.model.game.elements.*;

import java.util.List;

public class Map {
    private final int width;
    private final int height;

    private Chell chell;
    private Gun gun; // Not in this branch.
    private List<Monster> monsters;
    private List<Platform> platforms;
    private List<Bullet> bullets;

    public Map(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Chell getChell() {
        return this.chell;
    }

    public void setChell(Chell chell) {
        this.chell = chell;
    }

    public Gun getgun() {
        return this.gun;
    }

    public void setgun(Gun gun) {
        this.gun = gun;
    }

    public List<Monster> getMonsters() {
        return monsters;
    }

    public void setMonsters(List<Monster> monsters) {
        this.monsters = monsters;
    }

    // TODO
    // Add monsters, add platforms, add bullets...
}
