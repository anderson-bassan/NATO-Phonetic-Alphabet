package com.nato;

import javax.swing.*;
import java.awt.*;

public class GuessTheNatoWordApp {
    private final JFrame viewer;
    private final JPanel parentPanel;
    private final JPanel introPanel;
    private final JLabel introLabel;

    public GuessTheNatoWordApp(String INTRO_MESSAGE, JFrame viewer) {
        this.viewer = viewer;
        this.parentPanel = new JPanel();
        this.introPanel = new JPanel();
        this.introLabel = new JLabel(INTRO_MESSAGE);
    }

    public void injectNextPanel(JPanel nextPanel) {
        parentPanel.add(nextPanel);
    }

    public void removePanel(JPanel panelToDelete) {
        parentPanel.remove(panelToDelete);
        parentPanel.repaint();
    }

    public void setIntroPanel() {
        introPanel.add(introLabel);
        introPanel.setLayout(new GridBagLayout());
    }

    public void setParentPanel() {
        parentPanel.setLayout(new GridBagLayout());
        viewer.add(parentPanel);
    }

    public void setPanels() {
        setIntroPanel();
        setParentPanel();
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
        setPanels();
        showIntro();
    }
}
