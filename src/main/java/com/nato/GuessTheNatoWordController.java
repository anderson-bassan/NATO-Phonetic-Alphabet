package com.nato;

import java.awt.event.*;
import java.util.concurrent.*;

public class GuessTheNatoWordController {
    private final GuessTheNatoWordViewer viewer;
    private final GuessTheNatoWordModel model;
    private Future<?> future;
    private ExecutorService executor;


    private final NextPanelEnterListener nextPanelEnterListener;

    GuessTheNatoWordController(GuessTheNatoWordViewer viewer, GuessTheNatoWordModel model) {
        this.viewer = viewer;
        this.model = model;

        this.nextPanelEnterListener = new NextPanelEnterListener();

        viewer.addWordInputListener(new WordInputSelected());
        viewer.addGuessButtonClickListener(new GuessWordButtonClicked());
        viewer.addEnterPressedListener(new EnterPressedListener());
        viewer.addNextPanelEnterListener(nextPanelEnterListener);
    }


    /* Utilities */


    void start() {
        viewer.setIntroPanel(model.getIntroMessage());
        viewer.showIntroPanel();
    }

    public void setRandomWord() {
        model.generateCorrect();
        viewer.showTip(model.getCorrectChar());
    }

    private boolean guess() {
        model.setUserInput(viewer.getGuessInput());
        viewer.clearGuessInput();

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


    /* UTILITIES */


    void loadGuessWordPanel() {
        setRandomWord();
        viewer.setGuessWordPanel();
        viewer.showGuessWordPanel();
    }

    void loadPhoneticAlphabetPanel() {
        viewer.setPhoneticAlphabetPanel();
        viewer.showPhoneticAlphabetPanel();

    }

    /* event listeners for the controller */
    class WordInputSelected implements FocusListener {

        @Override
        public void focusGained(FocusEvent e) {
            viewer.clearGuessInput();
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

    class NextPanelEnterListener implements KeyListener {

        @Override
        public void keyTyped(KeyEvent e) {
        }

        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == 10) {
                if (viewer.getCurrentPanel() == "intro panel") {
                    loadPhoneticAlphabetPanel();

                } else if (viewer.getCurrentPanel() == "nato panel") {
                    loadGuessWordPanel();
                    viewer.removeNextPanelEnterListener(nextPanelEnterListener);

                }
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {

        }
    }
}
