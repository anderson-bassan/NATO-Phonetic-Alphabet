package com.nato;


import java.util.HashMap;
import java.util.ArrayList;
import java.util.Random;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import static java.util.concurrent.TimeUnit.SECONDS;


public class GuessTheNatoWord {
	// rewrite this into the contructor and move the building logic to the main class
	
    private final Random randomGenerator = new Random();
	
	private char previousRandomChar = '`';
	private char randomChar;
    private int points = 0;
	
	private static NATOPhoneticAlphabet natoPhoneticAlphabet;
	
	private static final int INPUT_TIMEOUT_SECONDS = 3;
	private static final TimedOutUserInput timedOutUserInput = new TimedOutUserInput(new InputReader(new BufferedReader(new InputStreamReader(System.in))));

	private static final LevenshteinAlgorithm lev = new LevenshteinAlgorithm();
	private static final int MAXIMUM_ACCEPTED_DISTANCE = 2;

 	public GuessTheNatoWord() {
		this.natoPhoneticAlphabet = new NATOPhoneticAlphabet();
	}

	public void showIntro() {
		// show an intro explaining the project
		
		try {
			System.out.printf("%n%n\tWelcome to NATO Phonetic Alphabet%n%n");
			Thread.sleep(3000);
			System.out.printf("\tThis is a game to help you learn the NATO Phonetic Alphabet while having fun.%n%n");
			Thread.sleep(3000);
			System.out.printf("\tYou have %d seconds to type the word equivalent to the letter shown, otherwise you'll lose.%n", INPUT_TIMEOUT_SECONDS);
			System.out.printf("\tIf you get all words correctly, then you win the game.%n%n");
			Thread.sleep(5000);
			System.out.printf("\tThe main idea for this project was taken from Reddit, namely, r/learnJava, but I designed and coded this%n");
			System.out.printf("\tprogram on my own while receiving feedback on my code from the reddit users u/NautiHooker, u/Nightcorex_.%n");
			System.out.printf("\tand u/geoffreychallen.%n%n");
			Thread.sleep(6000);
			System.out.printf("\tmy post link: https://www.reddit.com/r/learnjava/comments/wgwowp/how_can_i_improve_this_code/%n%n");
			Thread.sleep(4000);
			System.out.printf("\tEnjoy!%n");
			Thread.sleep(3000);
			System.out.printf("\t\t\t\t\t- Created by Anderson Bassan%n%n%n");
			Thread.sleep(3000);
			
		} catch (InterruptedException e) {
			e.printStackTrace();
			
		}
	}

 	private void generateRandomChar() {	// refactor into RandomGenerator Class
		/*  picks a random char that corresponds to a nato phonetic alphabet word, implemented in a way that feels more random */

	 	int randomCharIndex = randomGenerator.nextInt(natoPhoneticAlphabet.getSize());
		Character[] availableWordsSymbols = natoPhoneticAlphabet.getKeys();

		// if the random char is precedes, follows or is the same as the previous random char then generate a new one
		if (2 <= natoPhoneticAlphabet.getSize() && (previousRandomChar == (char) (availableWordsSymbols[randomCharIndex] - 1) || previousRandomChar == (char) (availableWordsSymbols[randomCharIndex] + 1) || previousRandomChar == (char) (availableWordsSymbols[randomCharIndex]))) {
			generateRandomChar();
			
		} else {
			randomChar = availableWordsSymbols[randomCharIndex];
			previousRandomChar = randomChar;
			
		}
	} 
	
 	public char getRandomChar() { // refactor into RandomGenerator Class
		return randomChar;
	}
	
	private String getInput() {
		try {
			return timedOutUserInput.getTimedOutUserInput(INPUT_TIMEOUT_SECONDS, SECONDS, "you ran out of time and lost", "exit");
		} catch (IOException e) {
			return "exit";
		}
	}
	
	private void showPoints() {		
		System.out.println("");
		System.out.println("");
		System.out.println("####################################");
		System.out.println("#                                  #");
		
		if (0 <= points && points < 10) {
			System.out.printf("#    Your current points are %d     #%n", points);
		
		} else if (-10 < points || 10 < points) {
			System.out.printf("#    Your current points are %d    #%n", points);
		
		} else {
			System.out.printf("#    Your current points are %d   #%n", points);
		}

		System.out.println("#                                  #");
		System.out.println("####################################");
		System.out.println("");
		System.out.println("");
	}
	
	private void showFinalPoints() {
		/* shows if you won and your final score */
		
		System.out.println("");
		System.out.println("");
		System.out.println("####################################");
		
 		if (natoPhoneticAlphabet.getSize() == 0) {
			System.out.println("#              YOU WON             #");
			
		} else {
			System.out.println("#             GAME OVER            #");
		}
		
		System.out.println("####################################");
		System.out.println("");
		System.out.println("");		
		System.out.println("####################################");
		System.out.println("#                                  #");

		if (0 <= points && points < 10) {
			System.out.printf("#    You final score was %d         #%n", points);
		
		} else if (-10 < points || 10 < points) {
			System.out.printf("#    You final score was %d        #%n", points);
			
		} else {
			System.out.printf("#    You final score was %d       #%n", points);
		}	

		System.out.println("#                                  #");
		System.out.println("####################################");
	}

	private boolean guess() {
		/* generates a random word, show the first letter to the user and see if they get it right in less than N seconds */

 		generateRandomChar();
		String correctWord = natoPhoneticAlphabet.getByKey(getRandomChar());
		
		System.out.printf("What is the word for %c (exit to exit): ", getRandomChar());
		String inputWord = getInput();

		if (inputWord.equals("exit")) {
			return false;
		}

		// verify if the input word is close enough to the correct word
		if (lev.fuzzyMatch(inputWord, correctWord, MAXIMUM_ACCEPTED_DISTANCE)) {
			natoPhoneticAlphabet.removeByKey(randomChar); // remove word from possible random words
			points++;
			
			// ends the game if theres no words left to guess
			if (natoPhoneticAlphabet.getSize() == 0) {
				return false;
				
			}
		
		} else {
			System.out.printf("%nThe correct word is %s.%n", correctWord);
			points--;
			
		}

		showPoints();	
		return true; 	
	}
 
 	public void play() {
   		showIntro();
  		while (guess());
		showFinalPoints();
		System.exit(0); // Exits the code in case the user takes too long to type and lose, otherwise readLine() will hang
	}
}