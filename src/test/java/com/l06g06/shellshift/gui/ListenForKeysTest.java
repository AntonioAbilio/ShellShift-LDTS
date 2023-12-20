package com.l06g06.shellshift.gui;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.awt.event.KeyEvent;

import static org.mockito.Mockito.*;

public class ListenForKeysTest {
    private LanternaGUI lanterna_gui;
    private ListenForKeys listenForKeys;
    private KeyEvent keyEvent;

    @BeforeEach
    public void setUp() {
        lanterna_gui = mock(LanternaGUI.class);
        listenForKeys = new ListenForKeys(lanterna_gui);
        keyEvent = mock(KeyEvent.class);
    }

    @Test
    public void keyPressedTest() {
        when(keyEvent.getKeyCode()).thenReturn(KeyEvent.VK_ENTER);
        listenForKeys.keyPressed(keyEvent);
        verify(lanterna_gui, times(1)).addButton(KeyEvent.VK_ENTER);
    }

    @Test
    public void keyReleasedTest() {
        when(keyEvent.getKeyCode()).thenReturn(KeyEvent.VK_ENTER);
        listenForKeys.keyReleased(keyEvent);
        verify(lanterna_gui, times(1)).removeButton(KeyEvent.VK_ENTER);
    }
}