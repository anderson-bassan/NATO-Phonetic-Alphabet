package com.nato;

import javax.swing.*;

public class LosePanel extends JPanel {
    private final JFrame parent;
    private final JLabel youLoseMessage;

    public LosePanel(JFrame parent) {
        this.parent = parent;
        this.youLoseMessage = new JLabel("You Lose");
    }

    public void set() {
        setSize(parent.getSize());
        setLayout(null);

        youLoseMessage.setBounds(getWidth() / 2, getHeight() / 2, 80, 20);

        add(youLoseMessage);
    }
}
