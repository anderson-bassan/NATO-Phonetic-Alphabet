package com.nato;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyListener;
import java.util.EventListener;

public class GuessWordPanel extends JPanel {
    private final JFrame parent;
    private final JTextField wordInput;
    private final JLabel wordLabel;
    private final JLabel scoreLabel;
    private final JLabel scorePoints;
    private final JLabel feedbackMessage;
    private final JButton guessButton;
    public GuessWordPanel(JFrame parent) {
        this.parent = parent;
        this.wordInput = new JTextField("hi");
        this.wordLabel = new JLabel("What is the correct word for x?");
        this.scoreLabel = new JLabel("score");
        this.scorePoints = new JLabel("00");
        this.feedbackMessage = new JLabel("That's wrong the correct word is xray.");
        this.guessButton = new JButton("GUESS");
    }

    private void setWordInput() {
        wordInput.setBounds(this.getWidth() / 2 - 100, this.getHeight() / 2, 200, 20);
        wordInput.setBorder(new EmptyBorder(5, 5, 5, 5));
        add(wordInput);
    }

    private void setWordLabel() {
        wordLabel.setBounds(this.getWidth() / 2 - 90, this.getHeight() / 2 - 24, 200, 20);
        add(wordLabel);
    }

    private void setGuessButton() {
        guessButton.setBounds(this.getWidth() / 2 + 120, this.getHeight() / 2, 80, 20);
        guessButton.setBackground(Color.decode("#FFFF00"));
        add(guessButton);
    }

    private void setScoreLabel() {
        scoreLabel.setBounds(this.getWidth() - 100, 20, 60, 20);
        add(scoreLabel);
    }

    private void setFeedbackMessage() {
        feedbackMessage.setBounds(this.getWidth() / 2 - 104, this.getHeight() / 2 + 24, 240, 20);
        add(feedbackMessage);
    }

    private void setScorePoints() {
        scorePoints.setBounds(this.getWidth() - 110, 30, 60, 60);
        scorePoints.setFont(new Font("TimesRoman", Font.PLAIN, 48));
        add(scorePoints);
    }

    public void setSelf() {
        setLayout(null);
        this.setSize(parent.getSize());
    }

    public void set() {
        setSelf();
        setWordLabel();
        setWordInput();
        setFeedbackMessage();
        setScoreLabel();
        setScorePoints();
        setGuessButton();
    }

    public void addWordInputListener(FocusListener listener) {
        wordInput.addFocusListener(listener);
    }

    public void addGuessButtonClickListener(ActionListener listener) {
        guessButton.addActionListener(listener);
    }

    public String getGuessWord() {
        return wordInput.getText();
    }

    public void clearWordInput() {
        wordInput.setText("");
    }

    public void addEnterPressedListener(KeyListener listener) {
        wordInput.addKeyListener(listener);
    }
}
