package com.nato;

import javax.swing.*;

public class Viewer extends JFrame {
    public Viewer() {
        setFrame();
    }

    public void setFrame() {
        this.setExtendedState(this.getExtendedState() | JFrame.MAXIMIZED_BOTH); // set frame to maximized
        this.setSize(1000, 680); // size in case the window is unmaximized
        this.setLocationRelativeTo(null); // center the unmaximized frame in the screen
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
