package com.nato;

import javax.swing.*;
import java.awt.*;

public class IntroPanel extends JPanel {
    public final String INTRO_MESSAGE;
    public final JLabel introMessage;

    IntroPanel(String INTRO_MESSAGE) {
        this.INTRO_MESSAGE = INTRO_MESSAGE;
        this.introMessage = new JLabel(INTRO_MESSAGE);
    }

    public void set() {
        this.add(introMessage);
        this.setLayout(new GridBagLayout());
    }
}
