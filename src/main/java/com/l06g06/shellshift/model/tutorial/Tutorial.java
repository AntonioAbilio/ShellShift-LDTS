package com.l06g06.shellshift.model.tutorial;

import com.l06g06.shellshift.model.game.elements.Chell;

public class Tutorial {
    private boolean chellFacingRight;
    private boolean selectedSpace;
    private boolean selectedArrowUp;
    private boolean selectedArrowLeft;
    private boolean selectedArrowRight;


    public boolean isSelectedSpace() {
        return selectedSpace;
    }

    public void setSelectedSpace(boolean selectedSpace) {
        this.selectedSpace = selectedSpace;
    }

    public boolean isSelectedArrowUp() {
        return selectedArrowUp;
    }

    public void setSelectedArrowUp(boolean selectedArrowUp) {
        this.selectedArrowUp = selectedArrowUp;
    }

    public boolean isSelectedArrowLeft() {
        return selectedArrowLeft;
    }

    public void setSelectedArrowLeft(boolean selectedArrowLeft) {
        this.selectedArrowLeft = selectedArrowLeft;
        this.chellFacingRight = !selectedArrowLeft;

    }

    public boolean isSelectedArrowRight() {
        return selectedArrowRight;
    }

    public void setSelectedArrowRight(boolean selectedArrowRight) {
        this.selectedArrowRight = selectedArrowRight;
        this.chellFacingRight = selectedArrowRight;
    }

    public boolean isChellFacingRight() {
        return chellFacingRight;
    }
}
