package com.nato;

import java.awt.event.*;
import java.util.concurrent.*;

public class GuessTheNatoWordController {
    private final GuessTheNatoWordViewer viewer;
    private final GuessTheNatoWordModel model;
    private Future<?> future;

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
        // function to set a timed task to get the user input
        // but if the user press enter or clicks cancel the task
        viewer.showGuessWordPanel();
//        viewer.setWinPanel();
//        viewer.showWinPanel();
//        viewer.setLosePanel();
//        viewer.showLosePanel();
//        viewer.setTimeOverPanel();
//        viewer.showTimeOverPanel();

        ExecutorService executor = Executors.newFixedThreadPool(3);

        try {
            this.future = executor.submit(new TimedOutUserInput(viewer));

        } finally {
            executor.shutdown();

        }
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
            future.cancel(true);
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
                future.cancel(true);
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {

        }
    }
}
