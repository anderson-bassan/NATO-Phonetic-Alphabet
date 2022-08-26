package com.nato;

import javax.swing.*;
import java.awt.*;

public class IntroPanel extends JPanel {
    public final JLabel introMessage;

    IntroPanel() {
        this.introMessage = new JLabel();
    }

    public void set(String INTRO_MESSAGE) {
        this.introMessage.setText(INTRO_MESSAGE);
        this.add(introMessage);
        this.setLayout(new GridBagLayout());
    }
}
