package com.nato;

import javax.swing.*;
import java.awt.*;

public class GuessTheNatoWordViewer extends JFrame {
    private final JPanel parentPanel;
    private final IntroPanel introPanel;


    public GuessTheNatoWordViewer() {
        this.parentPanel = new JPanel();
        this.introPanel = new IntroPanel();

        set();
    }


    public void injectNextPanel(JPanel nextPanel) {
        removePanel();
        parentPanel.add(nextPanel);
    }

    public void removePanel() {
        parentPanel.removeAll();
        parentPanel.repaint();
    }


    public void setParentPanel() {
        parentPanel.setLayout(new GridBagLayout());
        this.add(parentPanel);
    }

    public void setFrame() {
        this.setExtendedState(this.getExtendedState() | JFrame.MAXIMIZED_BOTH); // set frame to maximized
        this.setSize(1000, 680); // size in case the window is unmaximized
        this.setLocationRelativeTo(null); // center the unmaximized frame in the screen
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public void set() {
        setParentPanel();
        setFrame();
    }

    public void setIntro(String INTRO_MESSAGE) {
        introPanel.set(INTRO_MESSAGE);
    }

    public void showIntro() {
        injectNextPanel(introPanel);
    }
}
