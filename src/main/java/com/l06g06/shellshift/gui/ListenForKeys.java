package com.l06g06.shellshift.gui;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class ListenForKeys implements KeyListener {
    private LanternaGUI lanterna_gui;
    public ListenForKeys(LanternaGUI gui) {
        this.lanterna_gui = gui;
        lanterna_gui.addKeyListener(this);
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        this.lanterna_gui.addButton(e.getKeyCode());
    }

    @Override
    public void keyReleased(KeyEvent e) {
        this.lanterna_gui.removeButton(e.getKeyCode());
    }
}
