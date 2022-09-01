package com.nato;

import javax.swing.*;

public class TimeOverPanel extends JPanel {
    private final JFrame parent;
    private final JLabel timeOverMessage;

    public TimeOverPanel(JFrame parent) {
        this.parent = parent;
        this.timeOverMessage = new JLabel("Time Over. You Lost.");
    }

    public void set() {
        setSize(parent.getSize());
        setLayout(null);

        timeOverMessage.setBounds(getWidth() / 2 - 80, getHeight() / 2 - 20, 160, 20);

        add(timeOverMessage);
    }
}
