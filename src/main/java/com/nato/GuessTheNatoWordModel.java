package com.nato;

import com.nato.utilities.LevenshteinDistanceAlgorithm;
import com.nato.utilities.MessageManager;
import com.nato.utilities.NATOPhoneticAlphabet;
import com.nato.utilities.ScoreBoard;

public class GuessTheNatoWordModel {
    private final MessageManager messageManager;
    private boolean awaitUserInput;
    private String userInput;
    private NATOPhoneticAlphabet nato;
    private final ScoreBoard scoreBoard;
    private final LevenshteinDistanceAlgorithm levAlgorithm;

    public GuessTheNatoWordModel() {
        this.messageManager = new MessageManager();
        this.nato = new NATOPhoneticAlphabet();
        this.scoreBoard = new ScoreBoard();
        this.levAlgorithm = new LevenshteinDistanceAlgorithm(2);
    }

    public String getIntroMessage() {
        return messageManager.INTRO_MESSAGE;
    }


    /* USER INPUT INTERFACE */



    public void setUserInput(String input) {
        userInput = input;
    }

    public String getUserInput() {
        return userInput;
    }


    /* RANDOM GENERATOR INTERFACE */


    public void generateCorrect() {
        nato.generateCorrect();
    }

    public String getCorrectWord() {
        return nato.getCorrectWord();
    }

    public char getCorrectChar() {
        return nato.getCorrectWordSymbol();
    }

    public void removeCorrectWord() {
        nato.removeCorrectWord();
    }
    public boolean noWordsLeft() {
        return (nato.isEmpty());
    }


    /* POINTS INTERFACE */


    public void increasePoints() {
        scoreBoard.increasePoints();
    }

    public void decreasePoints() {
        scoreBoard.decreasePoints();
    }

    public int getPoints() {
        return scoreBoard.getPoints();
    }


    public boolean isCorrectByFuzzyMatch(String guess, String correct) {
        return levAlgorithm.isCorrectByFuzzyMatch(guess, correct);
    }
}
