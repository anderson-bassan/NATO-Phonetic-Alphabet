package com.nato;

import javax.swing.*;
import java.awt.*;

public class GuessTheNatoWordViewer extends JFrame {
    private final JPanel parentPanel;
    private final IntroPanel introPanel;


    public GuessTheNatoWordViewer(String INTRO_MESSAGE) {
        this.parentPanel = new JPanel();
        this.introPanel = new IntroPanel(INTRO_MESSAGE);
    }


    public void injectNextPanel(JPanel nextPanel) {
        parentPanel.add(nextPanel);
    }

    public void removePanel(JPanel panelToDelete) {
        parentPanel.remove(panelToDelete);
        parentPanel.repaint();
    }


    public void setParentPanel() {
        parentPanel.setLayout(new GridBagLayout());
        this.add(parentPanel);
    }


    public void setPanels() {
        introPanel.set();
        setParentPanel();
    }

    public void setFrame() {
        this.setExtendedState(this.getExtendedState() | JFrame.MAXIMIZED_BOTH); // set frame to maximized
        this.setSize(1000, 680); // size in case the window is unmaximized
        this.setLocationRelativeTo(null); // center the unmaximized frame in the screen
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public void set() {
        setPanels();
        setFrame();
    }

    public void waitForNSeconds(int seconds) {
        try {
            Thread.sleep(seconds * 1000);

        } catch (InterruptedException e) {
            System.out.println("Something went wrong while showing the intro. Exiting...");
            System.exit(0);
        }
    }

    public void showIntro() {
        injectNextPanel(introPanel);
        waitForNSeconds(10);
        removePanel(introPanel);
    }

    public void play() {
        set();
        showIntro();
    }
}
