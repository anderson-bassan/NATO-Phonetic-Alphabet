package com.nato;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.FocusListener;
import java.awt.event.KeyListener;

public class GuessTheNatoWordViewer extends JFrame {
    private final CardLayout cards;
    private final IntroPanel introPanel;
    private final GuessWordPanel guessWordPanel;
    private final WinPanel winPanel;
    private final LosePanel losePanel;
    private final TimeOverPanel timeOverPanel;

    public GuessTheNatoWordViewer() {
        this.cards = new CardLayout();
        this.introPanel = new IntroPanel();
        this.guessWordPanel = new GuessWordPanel(this);
        this.winPanel = new WinPanel(this);
        this.losePanel = new LosePanel(this);
        this.timeOverPanel = new TimeOverPanel(this);

        setFrame();
    }

    public void setIntro(String INTRO_MESSAGE) {
        introPanel.set(INTRO_MESSAGE);
        add(introPanel, "intro panel");
    }

    public void showIntro() {
        cards.show(this.getContentPane(), "intro panel");
    }

    public void setWinPanel() {
        winPanel.set();
        add(winPanel, "win");
    }

    public void showWinPanel() {
        cards.show(this.getContentPane(), "win");
    }


    public void setLosePanel() {
        losePanel.set();
        add(losePanel, "lose");
    }

    public void showLosePanel() {
        cards.show(this.getContentPane(), "lose");
    }

    public void setTimeOverPanel() {
        timeOverPanel.set();
        add(timeOverPanel, "time over");
    }

    public void showTimeOverPanel() {
        cards.show(this.getContentPane(), "time over");
    }

    public void addWordInputListener(FocusListener listener) {
        guessWordPanel.addWordInputListener(listener);
    }

    public void addGuessButtonClickListener(ActionListener listener) {
        guessWordPanel.addGuessButtonClickListener(listener);
    }

    public String getGuessWord() {
        return guessWordPanel.getGuessWord();
    }

    public void setGuessWordPanel() {
        guessWordPanel.set();
        add(guessWordPanel, "guess word panel");
    }

    public void showGuessWordPanel() {
        cards.show(this.getContentPane(), "guess word panel");
    }

    public void clearWordInput() {
        guessWordPanel.clearWordInput();
    }

    private void setFrame() {
        setResizable(false);
        setType(Type.UTILITY);
        setLayout(cards);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(this.getState() | JFrame.MAXIMIZED_BOTH);
        setSize(1024, 800);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void addEnterPressedListener(KeyListener listener) {
        guessWordPanel.addEnterPressedListener(listener);
    }
}
