package com.l06g06.shellshift.viewer.tutorial;

import com.l06g06.shellshift.Components;
import com.l06g06.shellshift.gui.Gui;
import com.l06g06.shellshift.model.game.elements.Position;
import com.l06g06.shellshift.model.tutorial.Tutorial;
import com.l06g06.shellshift.viewer.View;

public class TutorialViewer extends View<Tutorial> {
    public TutorialViewer(Tutorial model) {
        super(model);
    }

    @Override
    protected void drawElements(Gui gui) {
        gui.drawImageASCII(getModel().isChellFacingRight()? Components.Chell.getImage() : Components.Chell.getImageSelected(), new Position(70,40));
        gui.drawImageASCII(getModel().isSelectedArrowUp() ? Components.ArrowUp.getImageSelected() : Components.ArrowUp.getImage(), new Position(72, 22));
        gui.drawImageASCII(getModel().isSelectedArrowLeft() ? Components.ArrowLeft.getImageSelected() : Components.ArrowLeft.getImage(), new Position(50, 43));
        gui.drawImageASCII(getModel().isSelectedArrowRight() ? Components.ArrowRight.getImageSelected() : Components.ArrowRight.getImage(), new Position(93, 43));
        gui.drawImageASCII(getModel().isSelectedSpace() ? Components.SpaceBar.getImageSelected() : Components.SpaceBar.getImage(), new Position(63, 60));

    }
}
