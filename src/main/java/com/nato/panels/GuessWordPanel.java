package com.nato.panels;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.FocusListener;
import java.awt.event.KeyListener;

public class GuessWordPanel extends JPanel {
    private final JFrame parentFrame;
    private final JTextField wordInput;
    private final JLabel wordLabel;
    private final JLabel scoreLabel;
    private final JLabel scorePoints;
    private final JLabel correctFeedbackMessage;
    private final JLabel wrongFeedbackMessage;
    private final JButton guessButton;
    public GuessWordPanel(JFrame parent) {
        this.parentFrame = parent;

        this.wordInput = new JTextField("type your guess here");
        this.wordLabel = new JLabel();

        this.scoreLabel = new JLabel("score");
        this.scorePoints = new JLabel("00");

        this.correctFeedbackMessage = new JLabel();
        this.wrongFeedbackMessage = new JLabel();

        this.guessButton = new JButton("GUESS");
    }


    /* SETTINGS */


    private void setWordInput() {
        wordInput.setBounds(this.getWidth() / 2 - 100, this.getHeight() / 2 , 200, 30);
        wordInput.setBorder(new EmptyBorder(5, 5, 5, 5));
        add(wordInput);
    }

    private void setWordLabel() {
        wordLabel.setBounds(this.getWidth() / 2 - 90, this.getHeight() / 2 - 24, 200, 20);
        add(wordLabel);
    }

    private void setGuessButton() {
        guessButton.setBounds(this.getWidth() / 2 + 120, this.getHeight() / 2, 80, 20);
        guessButton.setBackground(Color.decode("#058E3F"));
        guessButton.setForeground(Color.decode("#dddddd"));
        add(guessButton);
    }

    private void setScoreLabel() {
        scoreLabel.setBounds(this.getWidth() - 100, 20, 60, 20);
        add(scoreLabel);
    }

    private void setCorrectFeedbackMessage() {
        correctFeedbackMessage.setBounds(this.getWidth() / 2 - 45, this.getHeight() / 2 + 40, 90, 20);
        correctFeedbackMessage.setForeground(Color.decode("#058E3F"));
        add(correctFeedbackMessage);
    }

    private void setWrongFeedbackMessage() {
        wrongFeedbackMessage.setBounds(this.getWidth() / 2 - 110, this.getHeight() / 2 + 40, 240, 20);
        wrongFeedbackMessage.setForeground(Color.decode("#8B1E3F"));
        add(wrongFeedbackMessage);
    }

    private void setScorePoints() {
        scorePoints.setBounds(this.getWidth() - 110, 30, 60, 60);
        scorePoints.setFont(new Font("TimesRoman", Font.PLAIN, 48));
        add(scorePoints);
    }

    public void setSelf() {
        setLayout(null);
        this.setSize(parentFrame.getSize());
    }

    public void set() {
        setSelf();
        setWordLabel();
        setWordInput();
        setCorrectFeedbackMessage();
        setWrongFeedbackMessage();
        setScoreLabel();
        setScorePoints();
        setGuessButton();
    }


    /* LISTENERS */


    public void addWordInputFocusedListener(FocusListener listener) {
        wordInput.addFocusListener(listener);
    }

    public void addGuessButtonClickListener(ActionListener listener) {
        guessButton.addActionListener(listener);
    }
    public void addEnterPressedListener(KeyListener listener) {
        wordInput.addKeyListener(listener);
    }

    public void showTip(char correctChar) {
        wordLabel.setText(String.format("What is the correct word for %c?", correctChar));
    }


    /* VISUAL UPDATES */


    public void showCorrectWordMessage() {
        correctFeedbackMessage.setVisible(true);
        wrongFeedbackMessage.setVisible(false);

        correctFeedbackMessage.setText("That's correct.");
    }

    public void showWrongWordMessage(String correctWord) {
        correctFeedbackMessage.setVisible(false);
        wrongFeedbackMessage.setVisible(true);

        wrongFeedbackMessage.setText(String.format("That's wrong. The correct word is %s.", correctWord));
    }

    public void updatePoints(int points) {
        scorePoints.setText(String.format("%02d", points));
    }


    /* UTILITIES */


    public String getGuessWord() {
        return wordInput.getText();
    }

    public void clearWordInput() {
        wordInput.setText("");
    }

}
