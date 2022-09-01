package com.nato;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class WinPanel extends JPanel {
    private final JLabel winMessage;
    private final JFrame parent;
    private final JLabel image;

    private final JLabel points;

    public WinPanel(JFrame parent) {
        this.winMessage = new JLabel("You won congrats.");
        this.parent = parent;
        this.points = new JLabel("00");

        BufferedImage trophyImage;

        try {
            trophyImage = ImageIO.read(new File("C:\\Users\\nero\\Downloads\\trophy.jpg"));
        } catch (Exception e) {
            trophyImage = new BufferedImage(1, 1, 1);
        }

        this.image = new JLabel(new ImageIcon(trophyImage));
    }

    void set() {
        setLayout(null);
        setSize(parent.getSize());
        setBackground(Color.white);

        winMessage.setBounds(this.getWidth() / 2 - 80, this.getHeight() / 2, 160, 20);
        add(winMessage);

        points.setBounds(this.getWidth() / 2 - 20, this.getHeight() / 2 + 20, 40, 20);
        add(points);


        image.setBounds(this.getWidth() / 2 - 200, this.getHeight() / 2 - 400, 400, 400);
        add(image);
    }
}
