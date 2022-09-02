package com.nato;

import java.awt.event.*;
import java.util.concurrent.*;

public class GuessTheNatoWordController {
    private final GuessTheNatoWordViewer viewer;
    private final GuessTheNatoWordModel model;
    private Future<?> future;
    private ExecutorService executor;


    private final IntroEnterListener introEnterListener;

    GuessTheNatoWordController(GuessTheNatoWordViewer viewer, GuessTheNatoWordModel model) {
        this.viewer = viewer;
        this.model = model;

        this.introEnterListener = new IntroEnterListener();

        viewer.addWordInputListener(new WordInputSelected());
        viewer.addGuessButtonClickListener(new GuessWordButtonClicked());
        viewer.addEnterPressedListener(new EnterPressedListener());
        viewer.addIntroEnterListener(introEnterListener);
    }


    /* Utilities */


    void start() {
        viewer.setIntro(model.getIntroMessage());
        viewer.showIntro();
    }

    void loadGuessWordPanel() {
        setRandomWord();
        viewer.setGuessWordPanel();
        viewer.showGuessWordPanel();
    }

    public void setRandomWord() {
        model.generateCorrect();
        viewer.showTip(model.getCorrectChar());
    }

    private boolean guess() {
        model.setUserInput(viewer.getGuessWord());
        viewer.clearWordInput();

        if (model.isCorrectByFuzzyMatch(model.getUserInput(), model.getCorrectWord())) {
            viewer.showCorrectWordMessage();
            model.increasePoints();
            model.removeCorrectWord();

        } else {
            viewer.showWrongWordMessage(model.getCorrectWord());
            model.decreasePoints();
        }

        viewer.updatePoints(model.getPoints());

        if (model.noWordsLeft()) {
            viewer.setWinPanel(model.getPoints());
            viewer.showWinPanel();
            return false; // stop guessing
        }

        if (model.getPoints() == 0 ) {
            viewer.setLosePanel();
            viewer.showLosePanel();
            return false;
        }

        setRandomWord();
        return true;
    }


    /* event listeners for the controller */
    class WordInputSelected implements FocusListener {

        @Override
        public void focusGained(FocusEvent e) {
            viewer.clearWordInput();
        }

        @Override
        public void focusLost(FocusEvent e) {

        }
    }

    class GuessWordButtonClicked implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            guess();
        }
    }

    class EnterPressedListener implements KeyListener {

        @Override
        public void keyTyped(KeyEvent e) {
        }

        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == 10) {
                guess();
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {

        }
    }

    class IntroEnterListener implements KeyListener {

        @Override
        public void keyTyped(KeyEvent e) {
        }

        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == 10) {
                loadGuessWordPanel();
                viewer.removeIntroEnterListener(introEnterListener);
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {

        }
    }
}
