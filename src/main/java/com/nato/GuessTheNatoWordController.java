package com.nato;

import java.awt.event.*;

public class GuessTheNatoWordController {
    private final GuessTheNatoWordViewer viewer;
    private final GuessTheNatoWordModel model;

    GuessTheNatoWordController(GuessTheNatoWordViewer viewer, GuessTheNatoWordModel model) {
        this.viewer = viewer;
        this.model = model;

        viewer.addWordInputListener(new WordInputSelected());
        viewer.addGuessButtonClickListener(new GuessWordButtonClicked());
        viewer.addEnterPressedListener(new EnterPressedListener());
    }

    void run() {
//        viewer.setIntro(model.getIntroMessage());
//        viewer.showIntro();
//        model.waitForNSeconds(5);
        viewer.setGuessWordPanel();
        viewer.showGuessWordPanel();
    }

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
            System.out.println("word: " + viewer.getGuessWord());
            viewer.clearWordInput();
        }
    }

    class EnterPressedListener implements KeyListener {

        @Override
        public void keyTyped(KeyEvent e) {
        }

        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == 10) {
                System.out.println("word: " + viewer.getGuessWord());
                viewer.clearWordInput();
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {

        }
    }
}
