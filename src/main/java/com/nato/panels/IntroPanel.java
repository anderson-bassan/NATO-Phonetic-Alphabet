package com.nato.panels;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyListener;

public class IntroPanel extends JPanel {
    public final JLabel introMessage;

    public IntroPanel() {
        this.introMessage = new JLabel();
    }

    public void set(String INTRO_MESSAGE) {
        this.introMessage.setText(INTRO_MESSAGE);
        this.add(introMessage);
        this.setLayout(new GridBagLayout());
    }
}
