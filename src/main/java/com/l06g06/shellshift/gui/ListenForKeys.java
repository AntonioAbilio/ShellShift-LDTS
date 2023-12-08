package com.l06g06.shellshift.gui;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class ListenForKeys implements KeyListener {
    private LanternaGUI guigui;
    public ListenForKeys(LanternaGUI gui) {
        this.guigui = gui;
        guigui.addKeyListenner(this);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        System.out.println("AAAAAAAAA");
    }

    @Override
    public void keyPressed(KeyEvent e) {
        this.guigui.addButton(e.getKeyCode());
        System.out.println("Pressed: " + e.getKeyCode());

    }

    @Override
    public void keyReleased(KeyEvent e) {
        this.guigui.removeButton(e.getKeyCode());
        System.out.println("Unpressed" + e.getKeyCode());
    }
}


