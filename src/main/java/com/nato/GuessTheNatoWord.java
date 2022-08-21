package com.nato;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.ArrayList;
import java.io.IOException;


public class GuessTheNatoWord {
	// rewrite this into the contructor and move the building logic to the main class
	
	private final WordManager WORD_MANAGER;
	private final LevenshteinAlgorithm LEVENSHTEIN_ALGORITHM;
	private final TimedOutUserInput TIMED_OUT_USER_INPUT;
	private final Points POINTS;

 	public GuessTheNatoWord(WordManager wordManager, LevenshteinAlgorithm levenshteinAlgorithm, TimedOutUserInput timedOutUserInput, Points points) {
		this.WORD_MANAGER = wordManager;
		this.LEVENSHTEIN_ALGORITHM = levenshteinAlgorithm;
		this.TIMED_OUT_USER_INPUT = timedOutUserInput;
		this.POINTS = points;
	}

	public void showIntro() {
		// show an intro explaining the project
		
		try {
			var bf = new BufferedReader(new InputStreamReader(System.in));

			System.out.printf("%n%n\tWelcome to NATO Phonetic Alphabet%n%n");
			System.out.printf("\tThis is a game to help you learn the NATO Phonetic Alphabet while having fun.%n%n");
			System.out.printf("\tYou have %d seconds to type the word equivalent to the letter shown, otherwise you'll lose.%n", TIMED_OUT_USER_INPUT.getTimeOutValue());
			System.out.printf("\tIf you get all words correctly, then you win the game.%n%n");
			System.out.printf("\tThe main idea for this project was taken from Reddit, namely, r/learnJava, but I designed and coded this%n");
			System.out.printf("\tprogram on my own while receiving feedback on my code from the reddit users u/NautiHooker, u/Nightcorex_.%n");
			System.out.printf("\tand u/geoffreychallen.%n%n");
			System.out.printf("\tmy post link: https://www.reddit.com/r/learnjava/comments/wgwowp/how_can_i_improve_this_code/%n%n");
			System.out.printf("\tEnjoy!%n");
			System.out.printf("\t\t\t\t\t- Created by Anderson Bassan%n%n%n");
			System.out.printf("\t\t\t\t\t[PRESS ENTER TO START THE GAME]%n");

			try {
				while (!bf.ready()) {
					Thread.sleep(20);
				}
			
				bf.readLine();
			} catch (IOException e) {
				System.out.println("input error when getting enter to start the game");
				e.printStackTrace();
			}
			
		} catch (InterruptedException e) {
			e.printStackTrace();
			
		}
	}

	private boolean guessWord() {
		/* generates a random word, show the first letter to the user and see if they get it right in less than N seconds */

 		String inputWord;
		WORD_MANAGER.generateRandomCorrectword();

		System.out.printf("What is the word for %c (type exit to exit): ", WORD_MANAGER.getCorrectWordSymbol());
		try {
			inputWord = TIMED_OUT_USER_INPUT.getTimedOutUserInput();
		} catch (IOException e) {
			inputWord = "exit";
		}

		if (inputWord.equals("exit")) {
			POINTS.showGameOverMessage();
			POINTS.showFinalPoints();

			return false;
		}

		if (inputWord.equals("time out")) {
			POINTS.showGameOverByTimeOutMessage();
			POINTS.showFinalPoints();

			return false;
		}


		if (LEVENSHTEIN_ALGORITHM.isCorrectByFuzzyMatch(inputWord, WORD_MANAGER.getCorrectWord())) {
			WORD_MANAGER.removeCorrectWord();
			POINTS.increasePoints();

			if (WORD_MANAGER.isEmpty()) {
				POINTS.showWinMessage();
				POINTS.showFinalPoints();

				return false;
				
			}
		
		} else {
			System.out.printf("%nThat's wrong. The correct word is %s.%n", WORD_MANAGER.getCorrectWord());
			POINTS.decreasePoints();
			
		}

		POINTS.showCurrentPoints();
		return true; 	
	}

 	public void play() {
   		showIntro();
  		while (guessWord());
		System.exit(0); // Exits the code in case the user takes too long to type and lose, otherwise readLine() will hang
	}
}
