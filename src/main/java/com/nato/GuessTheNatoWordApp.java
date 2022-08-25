package com.nato;

import javax.swing.*;
import java.awt.*;

public class GuessTheNatoWordApp {
    private final JFrame frame;
    private final JPanel parentPanel;
    private final JPanel introPanel;
    private final JLabel introLabel;

    public GuessTheNatoWordApp(String INTRO_MESSAGE) {
        this.frame = new JFrame();
        this.parentPanel = new JPanel();
        this.introPanel = new JPanel();
        this.introLabel = new JLabel(INTRO_MESSAGE);
    }

    public void setIntroPanel() {
        introPanel.add(introLabel);
        introPanel.setLayout(new GridBagLayout());
    }

    public void injectNextPanel(JPanel nextPanel) {
        parentPanel.add(nextPanel);
    }

    public void removePanel(JPanel panelToDelete) {
        parentPanel.remove(panelToDelete);
        parentPanel.repaint();
    }

    public void setFrame() {
        parentPanel.setLayout(new GridBagLayout());
        frame.add(parentPanel);
        if (frame.getExtendedState() == 0) frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public void play() {
        setFrame();
        setIntroPanel();
        injectNextPanel(introPanel);
        try {
            Thread.sleep(10 * 1000);

        } catch (InterruptedException e) {
            System.out.println("Something went wrong while showing the intro. Exiting...");
            System.exit(0);
        }
        removePanel(introPanel);
    }
}
